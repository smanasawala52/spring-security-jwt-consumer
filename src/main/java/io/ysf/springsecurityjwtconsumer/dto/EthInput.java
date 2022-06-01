package io.ysf.springsecurityjwtconsumer.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EthInput {
	private String ethAccount;
	private String ethAccountPrivateKey;
	private String ethTokenAddress;
	private BigInteger ethAmount;

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

	public BigInteger getEthAmount() {
		return ethAmount;
	}

	public void setEthAmount(BigInteger ethAmount) {
		this.ethAmount = ethAmount;
	}

	public List<String> getEthAvailableTokenAddress() {
		return ethAvailableTokenAddress;
	}

	public void setEthAvailableTokenAddress(List<String> ethAvailableTokenAddress) {
		this.ethAvailableTokenAddress = ethAvailableTokenAddress;
	}

}
