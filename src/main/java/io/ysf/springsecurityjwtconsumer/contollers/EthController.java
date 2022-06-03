package io.ysf.springsecurityjwtconsumer.contollers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import io.ysf.springsecurityjwtconsumer.config.EthAccountConfig;
import io.ysf.springsecurityjwtconsumer.contracts.DappToken;
import io.ysf.springsecurityjwtconsumer.contracts.FundMe;
import io.ysf.springsecurityjwtconsumer.contracts.MockDAI;
import io.ysf.springsecurityjwtconsumer.contracts.MockERC20;
import io.ysf.springsecurityjwtconsumer.contracts.MockV3Aggregator;
import io.ysf.springsecurityjwtconsumer.contracts.MockWeth;
import io.ysf.springsecurityjwtconsumer.contracts.SimpleStorage;
import io.ysf.springsecurityjwtconsumer.contracts.TokenFarm;
import io.ysf.springsecurityjwtconsumer.dto.EthAccount;
import io.ysf.springsecurityjwtconsumer.dto.EthInput;
import io.ysf.springsecurityjwtconsumer.dto.EthToken;
import io.ysf.springsecurityjwtconsumer.dto.EthTokenFarm;

@RestController
public class EthController {

	private static final BigInteger GAS_LIMIT = new BigInteger("6721975");
	private static final BigInteger GAS_PRICE = new BigInteger("20000000000");
	private static final BigInteger DECIMALS = new BigInteger("18");
	private static final BigInteger INITIAL_ANSWER = Convert.toWei("2000", Unit.ETHER).toBigInteger();
	// ) new BigInteger("280291526315455192404096188");
	@Autowired
	private EthAccountConfig ethAccountConfig;

	@GetMapping("/eth")
	public ModelAndView getEthHomePage() {
		ModelAndView modelAndView = new ModelAndView("ethHome");
		return modelAndView;
	}

	@GetMapping("/ethConnectWallet")
	public ModelAndView ethConnectWallet() {
		ModelAndView modelAndView = new ModelAndView("ethWallet");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		String ethAddressAccount1 = ethAccountConfig.getEthAddressAccount1();
		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);
		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);
		Web3j client = Web3j.build(new HttpService(url));
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account1BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account1BeforeBalance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount2, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account2BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account2BeforeBalance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@GetMapping("/ethSimpleTransfer")
	public ModelAndView ethSimpleTransfer() {
		ModelAndView modelAndView = new ModelAndView("ethSimpleTransfer");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		String ethAddressAccount1 = ethAccountConfig.getEthAddressAccount1();
		String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);
		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig.getEthPrivateKeyAccount2();
		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);
		Web3j client = Web3j.build(new HttpService(url));
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account1BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account1BeforeBalance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount2, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account2BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account2BeforeBalance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Credentials credentials;
		try {
			credentials = Credentials.create(ethPrivateKeyAccount1);
			TransactionReceipt transactionReceipt = Transfer
					.sendFunds(client, credentials, ethAddressAccount2, BigDecimal.valueOf(0.01), Convert.Unit.ETHER)
					.send();
			modelAndView.addObject("transactionReceipt", transactionReceipt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account1Balance: " + balance.getBalance());
			modelAndView.addObject("account1Balance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount2, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account2Balance: " + balance.getBalance());
			modelAndView.addObject("account2Balance",
					Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@GetMapping("/ethSimpleStorage")
	public ModelAndView ethSimpleStorage() {
		ModelAndView modelAndView = new ModelAndView("ethSimpleStorage");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		System.out.println("URL: " + ethAccountConfig.getUrl());
		String ethAddressAccount1 = ethAccountConfig.getEthAddressAccount1();
		String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);

		Web3j client = Web3j.build(new HttpService(url));
		try {
			Web3ClientVersion web3ClientVersion = client.web3ClientVersion().send();
			System.out.println("web3ClientVersion: " + web3ClientVersion.getWeb3ClientVersion());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Credentials credentials = Credentials.create(ethPrivateKeyAccount1);

		try {
			SimpleStorage contract = SimpleStorage.deploy(client, credentials,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT), "Shabbir Test Simple Storage Demo").send();

			SimpleStorage contract2 = SimpleStorage.load(contract.getContractAddress(), client, credentials,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
			modelAndView.addObject("msg", contract2.getMessage().send().toString());
			modelAndView.addObject("beforeRetrive", contract2.retrive().send().toString());
			contract2.store(new BigInteger("12321")).send();
			modelAndView.addObject("afterRetrive", contract2.retrive().send().toString());
//			io.ysf.springsecurityjwtconsumer.contracts.People tx = contract2.getPerson().send();
//			tx.toString();
//			System.out.println(tx.getClass());
//			for (Field field : tx.getClass().getDeclaredFields()) {
//				field.setAccessible(true); // You might want to set modifier to public first.
//				Object value = field.get(tx);
//				if (value != null) {
//					System.out.println(field.getName() + "=" + value.getClass());
//				}
//			}
//
//			Class returnType = Pe;
//			Object value = result.getValue();
//			if (returnType.isAssignableFrom(tx.getClass())) {
//				return (R) tx;
//			} else if (result.getClass().equals(Address.class) && returnType.equals(String.class)) {
//				return (R) result.toString(); // cast isn't necessary
//			} else {
//				throw new ContractCallException(
//						"Unable to convert response: " + value + " to expected type: " + returnType.getSimpleName());
//			}

			// System.out.println(tx.toString() + "");
//			System.out.println(contract2.retrivePeople("Ted").send());
// 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@GetMapping("/ethFundMe")
	public ModelAndView ethFundMe() {
		ModelAndView modelAndView = new ModelAndView("ethFundMe");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		String ethAddressAccount1 = ethAccountConfig.getEthAddressAccount1();
		String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);
		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig.getEthPrivateKeyAccount2();
		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);
		String ethAddressAccount3 = ethAccountConfig.getEthAddressAccount3();
		String ethPrivateKeyAccount3 = ethAccountConfig.getEthPrivateKeyAccount3();
		modelAndView.addObject("ethAddressAccount3", ethAddressAccount3);

		Web3j client = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);
		Credentials credentialsAccount2 = Credentials.create(ethPrivateKeyAccount2);
		Credentials credentialsAccount3 = Credentials.create(ethPrivateKeyAccount3);

		BigInteger entranceFee = new BigInteger("30000000000000");
		entranceFee = Convert.toWei("0.001", Convert.Unit.ETHER).toBigInteger();
		String priceFeedAddress = ethAccountConfig.getEthUSDPriceFeed();
		if (priceFeedAddress == null || priceFeedAddress.isEmpty()) {
			MockV3Aggregator mockAggregator = null;
			try {
				mockAggregator = MockV3Aggregator.deploy(client, credentialsAccount1,
						new StaticGasProvider(GAS_PRICE, GAS_LIMIT), DECIMALS, INITIAL_ANSWER).send();
				priceFeedAddress = mockAggregator.getContractAddress();
				entranceFee = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		modelAndView.addObject("priceFeedAddress", priceFeedAddress);

		try {
			FundMe contract = FundMe.deploy(client, credentialsAccount1, new StaticGasProvider(GAS_PRICE, GAS_LIMIT),
					priceFeedAddress, new BigInteger("0")).send();

			// contract.get price
			System.out.println("getEntranceFee: " + contract.getEntranceFee().send());
			System.out.println("Price : " + contract.getPrice().send());
			System.out.println("getConversionUSDToWEI: " + contract.getConversionUSDToWEI(new BigInteger("50")).send());
			System.out.println("getPriceAll: " + contract.getPriceAll().send());

			System.out.println(
					"getConversionUSDToWEIView: " + contract.getConversionUSDToWEIView(new BigInteger("50")).send());

			modelAndView.addObject("contractAddress", contract.getContractAddress());
			modelAndView.addObject("owner", contract.owner().send());
			try {
				EthGetBalance balance = client
						.ethGetBalance(contract.getContractAddress(), DefaultBlockParameter.valueOf("latest"))
						.sendAsync().get(10, TimeUnit.SECONDS);
				modelAndView.addObject("contractBalance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// When account 2 funds contract
			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount2, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account2BeforeBalance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			FundMe contract2 = FundMe.load(contract.getContractAddress(), client, credentialsAccount2,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT));

			TransactionReceipt transactionReceipt1 = contract2.fund(entranceFee).send();
			modelAndView.addObject("transactionReceipt1", transactionReceipt1);
			modelAndView.addObject("transactionReceipt1From", transactionReceipt1.getFrom());
			modelAndView.addObject("transactionReceipt1To", transactionReceipt1.getTo());
			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount2, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account2Balance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				EthGetBalance balance = client
						.ethGetBalance(contract.getContractAddress(), DefaultBlockParameter.valueOf("latest"))
						.sendAsync().get(10, TimeUnit.SECONDS);
				modelAndView.addObject("contractBalanceT1",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// When account 3 funds contract
			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount3, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account3BeforeBalance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			FundMe contract3 = FundMe.load(contract.getContractAddress(), client, credentialsAccount3,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
			TransactionReceipt transactionReceipt2 = contract3.fund(entranceFee).send();
			modelAndView.addObject("transactionReceipt2", transactionReceipt2);
			modelAndView.addObject("transactionReceipt2From", transactionReceipt2.getFrom());
			modelAndView.addObject("transactionReceipt2To", transactionReceipt2.getFrom());

			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount3, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account3Balance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				EthGetBalance balance = client
						.ethGetBalance(contract.getContractAddress(), DefaultBlockParameter.valueOf("latest"))
						.sendAsync().get(10, TimeUnit.SECONDS);
				modelAndView.addObject("contractBalanceT2",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// When all fund is transfer to owner - account 1

			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account1BeforeBalance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			contract.withdraw().send();
			try {
				EthGetBalance balance = client
						.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest")).sendAsync()
						.get(10, TimeUnit.SECONDS);
				modelAndView.addObject("account1Balance",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				EthGetBalance balance = client
						.ethGetBalance(contract.getContractAddress(), DefaultBlockParameter.valueOf("latest"))
						.sendAsync().get(10, TimeUnit.SECONDS);
				modelAndView.addObject("contractBalanceT3",
						Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// contract.get price
			System.out.println("Price: " + contract.getPrice().send());
			System.out.println("Price Hardcoded: " + contract.getPrice().send());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}
	// 1) deploy TokenFarm, DAPP, WETH and FAU at init and use that contract every
	// time passing from UI
	// 2) Stake in DAPP, WETH and FAU dynamically for different user passing values
	// from UI (TokenFarm.contractAddress, Token.contractAddress, Account.address,
	// AmountToBeStake[checks to prevent overdraft])
	// 3) Unstake in DAPP, WETH and FAU dynamically for different user passing
	// values
	// from UI (TokenFarm.contractAddress, Token.contractAddress, Account.address,
	// AmountToBeUnStake[checks to prevent negative])

	@GetMapping("/ethDApp")
	public ModelAndView ethDApp() {
		ModelAndView modelAndView = new ModelAndView("ethDApp");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		String ethAddressAccount1 = ethAccountConfig.getEthAddressAccount1();
		String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);
		modelAndView.addObject("ethPrivateKeyAccount1", ethPrivateKeyAccount1);

		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig.getEthPrivateKeyAccount2();
		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);
		modelAndView.addObject("ethPrivateKeyAccount2", ethPrivateKeyAccount2);

		String ethAddressAccount3 = ethAccountConfig.getEthAddressAccount3();
		String ethPrivateKeyAccount3 = ethAccountConfig.getEthPrivateKeyAccount3();
		modelAndView.addObject("ethAddressAccount3", ethAddressAccount3);
		modelAndView.addObject("ethPrivateKeyAccount3", ethPrivateKeyAccount3);
		Web3j web3j = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);

		ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

		String ethUsdPriceFeedAddress = ethAccountConfig.getEthUSDPriceFeed();
		if (ethUsdPriceFeedAddress == null || ethUsdPriceFeedAddress.isEmpty()) {
			MockV3Aggregator mockAggregator = null;
			try {
				mockAggregator = MockV3Aggregator.deploy(web3j, credentialsAccount1, contractGasProvider, DECIMALS,
						Convert.toWei(INITIAL_ANSWER.toString(), Convert.Unit.ETHER).toBigInteger()).send();
				ethUsdPriceFeedAddress = mockAggregator.getContractAddress();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		modelAndView.addObject("priceFeedAddress", ethUsdPriceFeedAddress);

		String daiUsdPriceFeedAddress = ethAccountConfig.getEthDaiUsdPriceFeed();
		if (daiUsdPriceFeedAddress == null || daiUsdPriceFeedAddress.isEmpty()) {
			MockV3Aggregator mockAggregator = null;
			try {
				mockAggregator = MockV3Aggregator.deploy(web3j, credentialsAccount1, contractGasProvider, DECIMALS,
						Convert.toWei(INITIAL_ANSWER.toString(), Convert.Unit.ETHER).toBigInteger()).send();
				daiUsdPriceFeedAddress = mockAggregator.getContractAddress();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		modelAndView.addObject("daiUsdPriceFeedAddress", daiUsdPriceFeedAddress);

		// Deploy DApp and Token farm
		try {
			DappToken dAppTokenContract = DappToken.deploy(web3j, credentialsAccount1, contractGasProvider).send();
			TokenFarm tokenFarmContract = TokenFarm.deploy(web3j, credentialsAccount1,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT), dAppTokenContract.getContractAddress()).send();
			modelAndView.addObject("tokenFarmContract", tokenFarmContract.getContractAddress());
			modelAndView.addObject("tokenFarmContractName", tokenFarmContract.name());
			BigInteger keptBalance = Convert.toWei(new BigInteger("100").toString(), Convert.Unit.ETHER).toBigInteger();
			BigInteger totalSupply = dAppTokenContract.totalSupply().send();
			TransactionReceipt transactionReceipt1 = dAppTokenContract
					.transfer(tokenFarmContract.getContractAddress(), totalSupply.subtract(keptBalance)).send();

			modelAndView.addObject("transactionReceipt1", transactionReceipt1);
			modelAndView.addObject("dAppTokenContract", dAppTokenContract.getContractAddress());
			modelAndView.addObject("dAppTokenContractName", dAppTokenContract.name().send());
			modelAndView.addObject("dAppTokenContractBalance",
					Convert.fromWei(dAppTokenContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER));

			MockWeth mockWETHContract = null;
			if (ethAccountConfig.getEthWethToken() == null || ethAccountConfig.getEthWethToken().isEmpty()) {
				mockWETHContract = MockWeth.deploy(web3j, credentialsAccount1, contractGasProvider).send();
				totalSupply = mockWETHContract.totalSupply().send();
				keptBalance = Convert.toWei(new BigInteger("100").toString(), Convert.Unit.ETHER).toBigInteger();
//						TransactionReceipt transactionReceipt2 = dAppTokenContract
//								.transfer(tokenFarmContract.getContractAddress(), totalSupply.subtract(keptBalance)).send();
//						modelAndView.addObject("transactionReceipt2", transactionReceipt2);
			} else {
				mockWETHContract = MockWeth.load(ethAccountConfig.getEthWethToken(), web3j, credentialsAccount1,
						contractGasProvider);
			}
			modelAndView.addObject("mockWETHContract", mockWETHContract.getContractAddress());
			modelAndView.addObject("mockWETHContractName", mockWETHContract.name().send());
			modelAndView.addObject("mockWETHContractBalance",
					Convert.fromWei(mockWETHContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER));
			MockDAI mockDaiContract = null;
			if (ethAccountConfig.getEthFauToken() == null || ethAccountConfig.getEthFauToken().isEmpty()) {
				mockDaiContract = MockDAI.deploy(web3j, credentialsAccount1, contractGasProvider).send();
				keptBalance = Convert.toWei(new BigInteger("100").toString(), Convert.Unit.ETHER).toBigInteger();
				totalSupply = mockDaiContract.totalSupply().send();
//						TransactionReceipt transactionReceipt3 = dAppTokenContract
//								.transfer(tokenFarmContract.getContractAddress(), totalSupply.subtract(keptBalance)).send();
//						modelAndView.addObject("transactionReceipt3", transactionReceipt3);
			} else {
				mockDaiContract = MockDAI.load(ethAccountConfig.getEthFauToken(), web3j, credentialsAccount1,
						contractGasProvider);
			}
			modelAndView.addObject("mockDaiContract", mockDaiContract.getContractAddress());
			modelAndView.addObject("mockDaiContractName", mockDaiContract.name().send());
			modelAndView.addObject("mockDaiContractBalance",
					Convert.fromWei(mockDaiContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER));

			// DAPP
			TransactionReceipt addAllowedTokensTransactionReceipt = tokenFarmContract
					.addAllowedTokens(dAppTokenContract.getContractAddress()).send();
			modelAndView.addObject("dAppAddAllowedTokensTransactionReceipt", addAllowedTokensTransactionReceipt);
			TransactionReceipt priceFeedContractTransactionReceipt = tokenFarmContract
					.setPriceFeedContract(dAppTokenContract.getContractAddress(), daiUsdPriceFeedAddress).send();
			modelAndView.addObject("dAppPriceFeedContractTransactionReceipt", priceFeedContractTransactionReceipt);

			// FAU
			addAllowedTokensTransactionReceipt = tokenFarmContract
					.addAllowedTokens(mockDaiContract.getContractAddress()).send();
			modelAndView.addObject("fauAddAllowedTokensTransactionReceipt", addAllowedTokensTransactionReceipt);
			priceFeedContractTransactionReceipt = tokenFarmContract
					.setPriceFeedContract(mockDaiContract.getContractAddress(), daiUsdPriceFeedAddress).send();
			modelAndView.addObject("fauPriceFeedContractTransactionReceipt", priceFeedContractTransactionReceipt);

			// WETH
			addAllowedTokensTransactionReceipt = tokenFarmContract
					.addAllowedTokens(mockWETHContract.getContractAddress()).send();
			modelAndView.addObject("wethAddAllowedTokensTransactionReceipt", addAllowedTokensTransactionReceipt);
			priceFeedContractTransactionReceipt = tokenFarmContract
					.setPriceFeedContract(mockWETHContract.getContractAddress(), ethUsdPriceFeedAddress).send();
			modelAndView.addObject("wethPriceFeedContractTransactionReceipt", priceFeedContractTransactionReceipt);

			List<String> ethAvailableTokenAddress = new ArrayList<>();
			ethAvailableTokenAddress.add(dAppTokenContract.getContractAddress());
			ethAvailableTokenAddress.add(mockWETHContract.getContractAddress());
			ethAvailableTokenAddress.add(mockDaiContract.getContractAddress());
			System.out.println("--------------------------------------------------------");
			System.out.println("Token Address:");
			System.out.println("DAPP Token Address: " + dAppTokenContract.getContractAddress());
			System.out.println("FAU  Token Address: " + mockDaiContract.getContractAddress());
			System.out.println("WETH Token Address: " + mockWETHContract.getContractAddress());
			System.out.println("--------------------------------------------------------");

			// account 1 token 1
			BigInteger amount = Convert.toWei("10", Convert.Unit.ETHER).toBigInteger();
			EthInput ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount1);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount1);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(dAppTokenContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");

			// account 1 token 2
			amount = Convert.toWei("20", Convert.Unit.ETHER).toBigInteger();
			ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount1);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount1);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(mockDaiContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");

			// account 3 token 2
			amount = Convert.toWei("30", Convert.Unit.ETHER).toBigInteger();
			ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount1);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount1);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(mockWETHContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");
			// account 2 token 1
			amount = Convert.toWei("40", Convert.Unit.ETHER).toBigInteger();
			ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount2);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount2);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(dAppTokenContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");

			// account 1 token 2
			amount = Convert.toWei("50", Convert.Unit.ETHER).toBigInteger();
			ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount2);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount2);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(mockDaiContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");

			// account 3 token 2
			amount = Convert.toWei("60", Convert.Unit.ETHER).toBigInteger();
			ethInput = new EthInput();
			ethInput.setEthAccount(ethAddressAccount2);
			ethInput.setEthAccountPrivateKey(ethPrivateKeyAccount2);
			ethInput.setEthAmount(amount);
			ethInput.setEthAvailableTokenAddress(ethAvailableTokenAddress);
			ethInput.setEthTokenAddress(mockWETHContract.getContractAddress());
			ethInput.setEthTokenFarmAddress(tokenFarmContract.getContractAddress());
			ethDAppStake(ethInput);
			System.out.println("--------------------------------------------------------");
			EthTokenFarm ethTokenFarm = populateTokenFarm(tokenFarmContract.getContractAddress(),
					ethPrivateKeyAccount1);
			System.out.println("--------------------------------------------------------");
			modelAndView.addObject("ethTokenFarm", ethTokenFarm);
			// print balance
			printAllBalance(tokenFarmContract, ethAddressAccount1, dAppTokenContract, mockWETHContract, mockDaiContract,
					modelAndView);
			// print balance
			printAllBalance(tokenFarmContract, ethAddressAccount2, dAppTokenContract, mockWETHContract, mockDaiContract,
					modelAndView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	private EthTokenFarm populateTokenFarm(String contractAddress, String ownerCreds) {
		// load token farm contract
		String url = ethAccountConfig.getUrl();
		Web3j web3j = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ownerCreds);
		TokenFarm tokenFarmContract = TokenFarm.load(contractAddress, web3j, credentialsAccount1,
				new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
		EthTokenFarm ethTokenFarm = new EthTokenFarm();
		ethTokenFarm.setContractAddress(tokenFarmContract.getContractAddress());

		// populate available tokens
		List<String> lst = new ArrayList<>();
		try {
			for (int i = 0; i < 3; i++) {
				lst.add(tokenFarmContract.allowedTokens(new BigInteger(String.valueOf(i))).send());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ethTokenFarm.setEthAvailableTokenAddress(lst);
		//

		// populate available accounts
		List<EthAccount> ethAvailableAccounts = new ArrayList<>();
		try {
			for (int i = 0; i < 2; i++) {
				EthAccount ethAvailableAccount = new EthAccount();
				ethAvailableAccount.setEthAccount(tokenFarmContract.stakers(new BigInteger(String.valueOf(i))).send());
				List<EthToken> ethTokens = new ArrayList<>();
				for (String ethAvailableTokenAddress : ethTokenFarm.getEthAvailableTokenAddress()) {
					EthToken ethToken = new EthToken();
					ethToken.setEthTokenAddress(ethAvailableTokenAddress);
					try {
						BigDecimal temp = Convert.fromWei(tokenFarmContract
								.stakingBalance(ethAvailableTokenAddress, ethAvailableAccount.getEthAccount()).send()
								.toString(), Unit.ETHER);
						ethToken.setEthTokenBalance(temp.toBigInteger());

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {

						if (credentialsAccount1.getAddress().equalsIgnoreCase(ethAvailableAccount.getEthAccount())) {
							ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
							MockERC20 ethAvailableToken = MockERC20.load(ethAvailableTokenAddress, web3j,
									credentialsAccount1, contractGasProvider);
							BigDecimal temp = Convert.fromWei(
									ethAvailableToken.balanceOf(ethAvailableAccount.getEthAccount()).send().toString(),
									Unit.ETHER);
							ethToken.setEthAccountBalance(temp.toBigInteger());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ethTokens.add(ethToken);
				}
				ethAvailableAccount.setEthToken(ethTokens);
				ethAvailableAccounts.add(ethAvailableAccount);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ethTokenFarm.setEthAvailableAccounts(ethAvailableAccounts);
		//

		try {
			ethTokenFarm.setOwnerAddress(tokenFarmContract.owner().send());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ethTokenFarm: " + ethTokenFarm);
		return ethTokenFarm;
	}

	@PostMapping("/ethDApp/mint")
	public ModelAndView ethDAppMint(@RequestBody EthInput ethInput) {
		System.out.println(ethInput);
		ModelAndView modelAndView = new ModelAndView("ethDApp");
		String url = ethAccountConfig.getUrl();
		Web3j web3j = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ethInput.getEthAccountPrivateKey());
		ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

		TokenFarm tokenFarmContract = TokenFarm.load(ethInput.getEthTokenFarmAddress(), web3j, credentialsAccount1,
				new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
		BigInteger amount = ethInput.getEthAmount();
		// FAU
		MockERC20 mockERC20FAU = MockERC20.load(ethInput.getEthTokenAddress(), web3j, credentialsAccount1,
				contractGasProvider);
//		mockERC20FAU.allowance(owner, spender);
		TransactionReceipt transactionReceipt6 = null;
		MockWeth mockWETHContract = null;
		if (ethAccountConfig.getEthWethToken() == null || ethAccountConfig.getEthWethToken().isEmpty()) {
			try {
				mockWETHContract = MockWeth.deploy(web3j, credentialsAccount1, contractGasProvider).send();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			TransactionReceipt transactionReceipt2 = dAppTokenContract
//					.transfer(tokenFarmContract.getContractAddress(), totalSupply.subtract(keptBalance)).send();
//			modelAndView.addObject("transactionReceipt2", transactionReceipt2);
		} else {
			mockWETHContract = MockWeth.load(ethAccountConfig.getEthWethToken(), web3j, credentialsAccount1,
					contractGasProvider);
		}
		modelAndView.addObject(
				"transactionReceipt_" + ethInput.getEthAccount() + "_" + mockERC20FAU.getContractAddress() + "_mint",
				transactionReceipt6);
		System.out.println("transactionReceipt_" + ethInput.getEthAccount() + "_" + mockERC20FAU.getContractAddress()
				+ "_mint: " + transactionReceipt6);

		return modelAndView;
	}

	@PostMapping("/ethDApp/stake")
	public ModelAndView ethDAppStake(@RequestBody EthInput ethInput) {
		System.out.println(ethInput);
		ModelAndView modelAndView = new ModelAndView("ethDApp");
		String url = ethAccountConfig.getUrl();
		Web3j web3j = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ethInput.getEthAccountPrivateKey());
		ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

		TokenFarm tokenFarmContract = TokenFarm.load(ethInput.getEthTokenFarmAddress(), web3j, credentialsAccount1,
				new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
		BigInteger amount = ethInput.getEthAmount();
		// FAU
		MockERC20 mockERC20FAU = MockERC20.load(ethInput.getEthTokenAddress(), web3j, credentialsAccount1,
				contractGasProvider);
		TransactionReceipt transactionReceipt6 = null;
		try {
			transactionReceipt6 = mockERC20FAU.approve(tokenFarmContract.getContractAddress(), amount).send();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		modelAndView.addObject(
				"transactionReceipt_" + ethInput.getEthAccount() + "_" + mockERC20FAU.getContractAddress() + "_approve",
				transactionReceipt6);

		TransactionReceipt transactionReceipt7 = null;
		try {
			transactionReceipt7 = tokenFarmContract.stakeTokens(amount, mockERC20FAU.getContractAddress()).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject(
				"transactionReceipt_" + ethInput.getEthAccount() + "_" + mockERC20FAU.getContractAddress(),
				transactionReceipt7);

		System.out.println("transactionReceipt_" + ethInput.getEthAccount() + "_" + mockERC20FAU.getContractAddress()
				+ ": " + transactionReceipt6);
		return modelAndView;
	}

	@GetMapping("/ethDApp/unstake")
	public ModelAndView ethDAppUnstake() {
		ModelAndView modelAndView = new ModelAndView("ethDApp");
		return modelAndView;
	}

	public void printAllBalance(TokenFarm tokenFarmContract, String ethAddressAccount1, DappToken dAppTokenContract,
			MockWeth mockWETHContract, MockDAI mockDaiContract, ModelAndView modelAndView) {
		System.out.println("--------------------------------------------------------");
		try {
			BigDecimal temp = Convert.fromWei(tokenFarmContract
					.stakingBalance(dAppTokenContract.getContractAddress(), ethAddressAccount1).send().toString(),
					Unit.ETHER);
			System.out.println(
					"TokenFarmContract - DAppToken Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
			temp = Convert.fromWei(dAppTokenContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER);
			System.out.println("User - DAppToken Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BigDecimal temp = Convert.fromWei(tokenFarmContract
					.stakingBalance(mockWETHContract.getContractAddress(), ethAddressAccount1).send().toString(),
					Unit.ETHER);
			System.out.println(
					"TokenFarmContract - Weth Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
			temp = Convert.fromWei(mockWETHContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER);
			System.out.println("User - WETHToken Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BigDecimal temp = Convert.fromWei(tokenFarmContract
					.stakingBalance(mockDaiContract.getContractAddress(), ethAddressAccount1).send().toString(),
					Unit.ETHER);
			System.out.println(
					"TokenFarmContract - FAU Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
			temp = Convert.fromWei(mockDaiContract.balanceOf(ethAddressAccount1).send().toString(), Unit.ETHER);
			System.out.println("User - FAUToken Contract Balance for account(" + ethAddressAccount1 + "): " + temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------------");
	}

	@GetMapping("/ethGetGasPrice")
	public BigInteger ethGetGasPrice() throws IOException {
		String url = ethAccountConfig.getUrl();
		Web3j web3j = Web3j.build(new HttpService(url));
		EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
		return ethGasPrice.getGasPrice();
	}
}
