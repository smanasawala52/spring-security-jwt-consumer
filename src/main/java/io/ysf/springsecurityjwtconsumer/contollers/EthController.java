package io.ysf.springsecurityjwtconsumer.contollers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

@RestController
public class EthController {
	@GetMapping("/eth")
	public ModelAndView getEthHomePage() {
		ModelAndView modelAndView = new ModelAndView("ethWalletHome");
		return modelAndView;
	}

	@GetMapping("/ethConnectWallet")
	public ModelAndView ethConnectWallet() {
		ModelAndView modelAndView = new ModelAndView("ethWallet");
//		String url = "HTTP://127.0.0.1:7545";
//		String ethAddressAccount1 = "0x14494c0A9ADd1314286d523C04F17F1D698722c0";
//		String ethPrivateKeyAccount1 = "0x0c51696558fb2ed5412ec432945a2939fe3fe13afdb69136c8251e3eeec4185b";

		String url = "https://kovan.infura.io/v3/1bc7f1f7e1404bf5a2a59e8937e741ca";
		String ethAddressAccount1 = "0x515Dba6A9c2f35baAa8ef5c4748819EFa0Ad6692";
		
		Web3j client = Web3j.build(new HttpService(url));

		try {
			EthGetBalance balance = client.ethGetBalance(ethAddressAccount1, DefaultBlockParameter.valueOf("latest"))
					.sendAsync().get(10, TimeUnit.SECONDS);
			System.out.println("Balance: " + balance.getBalance());
			modelAndView.addObject("balance", Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelAndView;
	}

}
