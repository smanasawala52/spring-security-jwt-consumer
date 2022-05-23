//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
pragma experimental ABIEncoderV2;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";
import "@openzeppelin/contracts/access/Ownable.sol";
import "@chainlink/contracts/src/v0.8/interfaces/VRFCoordinatorV2Interface.sol";
import "@chainlink/contracts/src/v0.8/VRFConsumerBaseV2.sol";

contract Lottery is Ownable, VRFConsumerBaseV2 {
    address payable[] public players;
    address payable public recentWinner;
    uint256 public usdEntryFee;
    AggregatorV3Interface internal ethUSDPriceFeed;
    enum LOTTERY_STATE {
        OPEN,
        CLOSED,
        CALCULATING_WINNER
    }
    LOTTERY_STATE public lottery_state;
    uint256 public fee;
    bytes32 public keyhash;
    uint256 public randomness;
    // Your subscription ID.
  uint64 public s_subscriptionId;
  VRFCoordinatorV2Interface public COORDINATOR;
  // Depends on the number of requested values that you want sent to the
  // fulfillRandomWords() function. Storing each word costs about 20,000 gas,
  // so 100,000 is a safe default for this example contract. Test and adjust
  // this limit based on the network that you select, the size of the request,
  // and the processing of the callback request in the fulfillRandomWords()
  // function.
  uint32 public callbackGasLimit = 100000;

  // The default is 3, but you can set this higher.
  uint16 public requestConfirmations = 3;

  // For this example, retrieve 2 random values in one request.
  // Cannot exceed VRFCoordinatorV2.MAX_NUM_WORDS.
  uint32 public numWords =  2;

  uint256[] public s_randomWords;
  uint256 public s_requestId;

    constructor(
        uint256 _minUsdEntryFee,
        address _priceFeedAddress,
        address _vrfCoordinator,
        bytes32 _keyhash,
        uint256 _fee,        
        uint64 _subscriptionId
    ) public VRFConsumerBaseV2(_vrfCoordinator) {
        COORDINATOR = VRFCoordinatorV2Interface(_vrfCoordinator);
        usdEntryFee = _minUsdEntryFee * (10**18);
        ethUSDPriceFeed = AggregatorV3Interface(_priceFeedAddress);
        fee = _fee;
        keyhash = _keyhash;
        lottery_state = LOTTERY_STATE.CLOSED;
        s_subscriptionId = _subscriptionId;
    }

    function enter() public payable {
        require(lottery_state == LOTTERY_STATE.OPEN, "Lottery is closed!");
        require(
            msg.value >= getEntranceFee(),
            "Please add more than _minUsdEntryFee!"
        );
        players.push(payable(msg.sender));
    }

    function getEntranceFee() public view returns (uint256) {
        // minimumUSD
        uint256 price = getPriceHardCode() * 10**10;
        uint256 precision = 1 * 10**18;
        return ((usdEntryFee * precision) / price);
    }

    function startLottery() public onlyOwner {
        require(
            lottery_state == LOTTERY_STATE.CLOSED,
            "Cannot start new Lottery!"
        );
        lottery_state = LOTTERY_STATE.OPEN;
    }

    function endLottery() public onlyOwner {
        // uint256(
        //   keccak256(
        //     abi.encodePacked(
        //       block.number,
        //     msg.sender,
        //   block.difficulty,
        //  block.timestamp
        // )
        // )
        // ) % players.length;
        require(lottery_state == LOTTERY_STATE.OPEN, "Lottery is not open!");
        lottery_state = LOTTERY_STATE.CALCULATING_WINNER;
       
    // Will revert if subscription is not set and funded.
    s_requestId = COORDINATOR.requestRandomWords(
      keyhash,
      s_subscriptionId,
      requestConfirmations,
      callbackGasLimit,
      numWords
    );
  }
 
  function fulfillRandomWords(
    uint256 _requestId, /* requestId */
    uint256[] memory randomWords
  ) internal override {
      s_requestId = _requestId;
      s_randomWords = randomWords;
      require(
            lottery_state == LOTTERY_STATE.CALCULATING_WINNER,
            "You are not there yet!"
        );
    s_randomWords = randomWords;
    uint256 _randomness = randomWords[0];
       // require(_randomness > 0, "Random not found");
        uint256 indexOfWinner = _randomness % players.length;
        recentWinner = players[indexOfWinner];
        recentWinner.transfer(address(this).balance);
        players = new address payable[](0);
        randomness = _randomness;
        lottery_state = LOTTERY_STATE.CLOSED;
    }

    function getPriceHardCode() private pure returns (uint256) {
        // returns price of (10 ** 8) ETH in USD
        uint256 ans = 277321966310;
        return ans;
    }

    function getPrice() private view returns (uint256) {
        (, int256 answer, , , ) = ethUSDPriceFeed.latestRoundData();
        return uint256(answer);
        //277321966310
    }

    function getPriceAll()
        public
        view
        returns (
            uint80,
            int256,
            uint256,
            uint256,
            uint80
        )
    {
        (
            uint80 roundId,
            int256 answer,
            uint256 startedAt,
            uint256 updatedAt,
            uint80 answerInRound
        ) = ethUSDPriceFeed.latestRoundData();
        return (roundId, answer, startedAt, updatedAt, answerInRound);
    }

    function getRecentWinner() public view returns (address payable) {
        return recentWinner;
    }

    function getRandomness() public view returns (uint256) {
        return randomness;
    }

    function getPlayers() public view returns (address payable[] memory) {
        return players;
    }
     function getLotteryStatus() public view returns (string memory ) {
       if(lottery_state == LOTTERY_STATE.OPEN){
           return "Lottery is Open";
       } else if(lottery_state == LOTTERY_STATE.CLOSED){
           return "Lottery is Closed";
        } else if(lottery_state == LOTTERY_STATE.CALCULATING_WINNER){
           return "Lottery is CALCULATING_WINNER";
       }
       return '';
    } 
    function setLotteryState(uint16 _lotState) public{
        if(_lotState==0){
            lottery_state = LOTTERY_STATE.OPEN;
        }
        else if(_lotState==1){
            lottery_state = LOTTERY_STATE.CLOSED;
        }
        else if(_lotState==2){
            lottery_state = LOTTERY_STATE.CALCULATING_WINNER;
        }
    }
    function setNumRandomWords(uint32 _numWords) public{
       numWords = _numWords;
    }
}