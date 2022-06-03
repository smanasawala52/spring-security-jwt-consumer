https://docs.web3j.io/4.8.7/transactions/transfer_eth/#transfer-of-ether-from-one-party-to-another
web3j generate solidity -a SimpleStorage.abi -o D:/ysfaligit/spring-security-jwt-consumer/src/main/java/io/ysf/springsecurityjwtconsumer -p io.ysf.springsecurityjwtconsumer.contracts

0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d
0x6cbed15c793ce57650b9877cf6fa156fbef513c4e6134f022a85b1ffdd59b2a1


solcjs SimpleStorage.sol --bin --abi --optimize -o D:/ysfaligit/spring-security-jwt-consumer/src/main/resources
solcjs D:/Test/crypto_demos/brownie_simple_storage/openzeppelin-contracts/contracts/mocks/ERC20Mock.sol --bin --abi --optimize -o D:/ysfaligit/spring-security-jwt-consumer/src/main/resources
solcjs ERC20Mock.sol --bin --abi --optimize -o D:/ysfaligit/spring-security-jwt-consumer/src/main/resources

cls
web3j generate truffle --truffle-json=FundMe.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=SimpleStorage.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=AggregatorV3Interface.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=MockV3Aggregator.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=MockDAI.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=MockWeth.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts

web3j generate truffle --truffle-json=D:/Test/crypto_demos/defi-stake-yield-brownie/build/contracts/TokenFarm.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts
web3j generate truffle --truffle-json=D:/Test/crypto_demos/defi-stake-yield-brownie/build/contracts/TokenFarm.json --outputDir=D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ --package=io.ysf.springsecurityjwtconsumer.contracts


web3j generate solidity -a SimpleStorage_sol_SimpleStorage.abi -b SimpleStorage_sol_SimpleStorage.bin -o D:/ysfaligit/spring-security-jwt-consumer/src/main/java/ -p io.ysf.springsecurityjwtconsumer.contracts


https://consensys.net/quorum/developers/
npx quorum-dev-quickstart

https://trufflesuite.com/docs/drizzle/quickstart/


npm install --save-dev @openzeppelin/truffle-upgrades
