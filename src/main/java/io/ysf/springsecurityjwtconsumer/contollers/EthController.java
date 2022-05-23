package io.ysf.springsecurityjwtconsumer.contollers;

import java.io.IOException;
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
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import io.ysf.springsecurityjwtconsumer.config.EthAccountConfig;
import io.ysf.springsecurityjwtconsumer.contracts.SimpleStorage;

@RestController
public class EthController {

	private static final BigInteger GAS_LIMIT = new BigInteger("200000");
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
		String ethPrivateKeyAccount1 = ethAccountConfig
				.getEthPrivateKeyAccount1();

		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);

		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig
				.getEthPrivateKeyAccount2();

		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);

		Web3j client = Web3j.build(new HttpService(url));

		try {
			EthGetBalance balance = client
					.ethGetBalance(ethAddressAccount1,
							DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out
					.println("account1BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account1BeforeBalance", Convert.fromWei(
					balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client
					.ethGetBalance(ethAddressAccount2,
							DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out
					.println("account2BeforeBalance: " + balance.getBalance());
			modelAndView.addObject("account2BeforeBalance", Convert.fromWei(
					balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Credentials credentials;
		try {
			credentials = Credentials.create(ethPrivateKeyAccount1);
			TransactionReceipt transactionReceipt = Transfer
					.sendFunds(client, credentials, ethAddressAccount2,
							BigDecimal.valueOf(0.01), Convert.Unit.ETHER)
					.send();
			modelAndView.addObject("transactionReceipt", transactionReceipt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client
					.ethGetBalance(ethAddressAccount1,
							DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account1Balance: " + balance.getBalance());
			modelAndView.addObject("account1Balance", Convert.fromWei(
					balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			EthGetBalance balance = client
					.ethGetBalance(ethAddressAccount2,
							DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("account2Balance: " + balance.getBalance());
			modelAndView.addObject("account2Balance", Convert.fromWei(
					balance.getBalance().toString(), Convert.Unit.ETHER));
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
		String ethPrivateKeyAccount1 = ethAccountConfig
				.getEthPrivateKeyAccount1();

		modelAndView.addObject("ethAddressAccount1", ethAddressAccount1);

		String ethAddressAccount2 = ethAccountConfig.getEthAddressAccount2();
		String ethPrivateKeyAccount2 = ethAccountConfig
				.getEthPrivateKeyAccount2();

		modelAndView.addObject("ethAddressAccount2", ethAddressAccount2);

		Web3j client = Web3j.build(new HttpService(url));
		Credentials credentials = Credentials.create(ethPrivateKeyAccount1);

		try {
			SimpleStorage contract = SimpleStorage.load(ethAddressAccount1,
					client, credentials, requestCurrentGasPrice(), GAS_LIMIT);
			modelAndView.addObject("beforeRetrive",
					contract.retrive().sendAsync().get(10, TimeUnit.SECONDS));
			contract.store(new BigInteger("150"));
			modelAndView.addObject("afterRetrive",
					contract.retrive().sendAsync().get(10, TimeUnit.SECONDS));
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
