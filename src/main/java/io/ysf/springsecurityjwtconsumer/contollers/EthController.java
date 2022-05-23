package io.ysf.springsecurityjwtconsumer.contollers;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import io.ysf.springsecurityjwtconsumer.config.EthAccountConfig;

@RestController
public class EthController {

	private static final String GAS_PRICE = null;
	private static final String GAS_LIMIT = null;
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

		YourSmartContract contract = YourSmartContract.load(
				"0x<address>|<ensName>", client, credentials, GAS_PRICE,
				GAS_LIMIT);

		return modelAndView;
	}

}
