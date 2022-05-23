//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0; 
pragma experimental ABIEncoderV2;

import "@chainlink/contracts/src/v0.8/interfaces/AggregatorV3Interface.sol";
import "hardhat/console.sol";

contract FunMe{
    AggregatorV3Interface private priceFeed=  AggregatorV3Interface(0x9326BFA02ADD2366b30bacB125260Af641031331); 
    mapping(address => uint256) public addressToAmount;
    address private  owner  ;    
    address[] private funders ;
    constructor(){
        owner=msg.sender;        
    }
    function fund() public nonOwner payable{
        uint256  usrAmtInWEI= msg.value;
        uint256 minimumUSD = 50;
        uint256 minimumUSDinWEI = getConversionUSDToWEI(minimumUSD);
        uint256 minimumUSDinGWEI = minimumUSDinWEI / (10 ** 9);

        console.log("Message amount enterd by user in WEI: ", usrAmtInWEI);
        console.log("Minimum USD in Wei: ", minimumUSDinWEI);
        console.log("Minimum USD in GWei: ", minimumUSDinGWEI);
        // string memory errorMessage = abi.encodePacked(abi.encodePacked(abi.encodePacked(abi.encodePacked("You need to spend more ETH - minimum ",string(minimumUSD))," USD ("),string(minimumUSDinGWEI))," GWEI)!");
        // console.log("Error Message: ","You need to spend more ETH - minimum 50 USD!");
        require(usrAmtInWEI >= minimumUSDinWEI,"You need to spend more ETH - minimum 50 USD!");            
        addressToAmount[msg.sender]+= usrAmtInWEI;
        funders.push(msg.sender);
    }
    modifier onlyOwner {
        require(owner==msg.sender,"Only admin can withdraw funds!");
        _;
    }
    modifier nonOwner {
        require(owner!=msg.sender,"Only non admin can deposit funds!");
        _;
    }

    function withdraw() public onlyOwner payable{        
        console.log("owner: ", owner);
        console.log("owner.balance: ", owner.balance);
        console.log("address(this): ", address(this));
        console.log("address(this).balance: ", address(this).balance);
       // console.log("of(address(this)): ", of(address(this)));
        

        payable(msg.sender).transfer(address(this).balance);
        for(uint256 i=0;i<funders.length;i++){
          // payable(funders[i]).transfer(addressToAmount[funders[i]]);

           addressToAmount[funders[i]] = 0;
        }
        funders= new address[](0);
    }
   
    function getConversionUSDToWEI(uint256 inputAmtUSD) private pure returns (uint256){
        uint256 usdToEth = inputAmtUSD * (10 ** 9) * (10 ** 9) * (10 ** 8);
        usdToEth = usdToEth / getPriceHardCode();
        return usdToEth;
    }   
    function getPriceHardCode() private pure returns (uint256){
         // returns price of (10 ** 8) ETH in USD 
        uint256 ans= 332451516808;
        return ans;
    }
    function getThisBalance() public view returns (uint256){        
        return address(this).balance;
    }
    function getPrice() private view returns (uint256){
        (,int256 answer,,,) = priceFeed.latestRoundData();
        return uint256(answer);
        //332451516808
    }
    function getPriceAll() private view returns (uint80,int256,uint256,uint256,uint80){
        (uint80 roundId,int256 answer, uint256 startedAt,uint256 updatedAt,uint80 answerInRound) = priceFeed.latestRoundData();
        return ( roundId, answer,  startedAt, updatedAt, answerInRound);
    }
}