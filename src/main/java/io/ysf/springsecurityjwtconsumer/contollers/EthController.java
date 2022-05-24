package io.ysf.springsecurityjwtconsumer.contollers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import io.ysf.springsecurityjwtconsumer.config.EthAccountConfig;
import io.ysf.springsecurityjwtconsumer.contracts.People;
import io.ysf.springsecurityjwtconsumer.contracts.SimpleStorage;

@RestController
public class EthController {

	private static final BigInteger GAS_LIMIT = new BigInteger("6721975");
	private static final BigInteger GAS_PRICE = new BigInteger("20000000000");
	@Autowired
	private EthAccountConfig ethAccountConfig;

	@GetMapping("/eth")
	public ModelAndView getEthHomePage() {
		ModelAndView modelAndView = new ModelAndView("ethWalletHome");
		return modelAndView;
	}

	@GetMapping("/ethConnectWallet")
	public ModelAndView ethConnectWallet() {
		ModelAndView modelAndView = new ModelAndView("ethWallet");
		String url = ethAccountConfig.getUrl();
		modelAndView.addObject("url", url);
		System.out.println("URL: " + ethAccountConfig.getUrl());
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

		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig.getEthPrivateKeyAccount2();

		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);

		Web3j client = Web3j.build(new HttpService());
		try {
			Web3ClientVersion web3ClientVersion = client.web3ClientVersion().send();
			System.out.println("web3ClientVersion: " + web3ClientVersion.getWeb3ClientVersion());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Credentials credentials = Credentials
				.create("0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d");

		try {
			SimpleStorage contract = SimpleStorage.deploy(client, credentials,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT), "Shabbir Test Simple Storage Demo").send();

			SimpleStorage contract2 = SimpleStorage.load(contract.getContractAddress(), client, credentials,
					new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
			modelAndView.addObject("msg", contract2.getMessage().send().toString());
			modelAndView.addObject("beforeRetrive", contract2.retrive().send().toString());
			contract2.store(new BigInteger("12321")).send();
			modelAndView.addObject("afterRetrive", contract2.retrive().send().toString());
			io.ysf.springsecurityjwtconsumer.contracts.People tx = (People) contract2.getPerson().send();
			tx.toString();
			System.out.println(tx.getClass());
			for (Field field : tx.getClass().getDeclaredFields()) {
				field.setAccessible(true); // You might want to set modifier to public first.
				Object value = field.get(tx);
				if (value != null) {
					System.out.println(field.getName() + "=" + value.getClass());
				}
			}
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

			System.out.println(tx.toString() + "");
//			System.out.println(contract2.retrivePeople("Ted").send());
// 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	public BigInteger requestCurrentGasPrice() throws IOException {
		String url = ethAccountConfig.getUrl();
		Web3j web3j = Web3j.build(new HttpService(url));
		EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
		return ethGasPrice.getGasPrice();
	}
}
