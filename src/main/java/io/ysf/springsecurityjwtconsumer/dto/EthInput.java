package io.ysf.springsecurityjwtconsumer.dto;

import java.util.ArrayList;
import java.util.List;

public class EthInput {
	private String ethAccount;
	private String ethAccountPrivateKey;
	private String ethTokenAddress = "";
	private String ethTokenFarmAddress = "";
	private String ethAmount;

	private List<String> ethAvailableTokenAddress = new ArrayList<>();

	public String getEthAccount() {
		return ethAccount;
	}

	public void setEthAccount(String ethAccount) {
		this.ethAccount = ethAccount;
	}

	public String getEthAccountPrivateKey() {
		return ethAccountPrivateKey;
	}

	public void setEthAccountPrivateKey(String ethAccountPrivateKey) {
		this.ethAccountPrivateKey = ethAccountPrivateKey;
	}

	public String getEthTokenAddress() {
		return ethTokenAddress;
	}

	public void setEthTokenAddress(String ethTokenAddress) {
		this.ethTokenAddress = ethTokenAddress;
	}

	public String getEthAmount() {
		return ethAmount;
	}

	public void setEthAmount(String ethAmount) {
		this.ethAmount = ethAmount;
	}

	public List<String> getEthAvailableTokenAddress() {
		return ethAvailableTokenAddress;
	}

	public void setEthAvailableTokenAddress(List<String> ethAvailableTokenAddress) {
		this.ethAvailableTokenAddress = ethAvailableTokenAddress;
	}

	public String getEthTokenFarmAddress() {
		return ethTokenFarmAddress;
	}

	public void setEthTokenFarmAddress(String ethTokenFarmAddress) {
		this.ethTokenFarmAddress = ethTokenFarmAddress;
	}

	@Override
	public String toString() {
		return "EthInput [ethAccount=" + ethAccount + ", ethAccountPrivateKey=" + ethAccountPrivateKey
				+ ", ethTokenAddress=" + ethTokenAddress + ", ethTokenFarmAddress=" + ethTokenFarmAddress
				+ ", ethAmount=" + ethAmount + ", ethAvailableTokenAddress=" + ethAvailableTokenAddress + "]";
	}

}
