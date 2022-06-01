package io.ysf.springsecurityjwtconsumer.dto;

import java.math.BigInteger;

public class EthToken {
	private String ethTokenAddress;
	private BigInteger ethAccountBalance;
	private BigInteger ethTokenBalance;

	public String getEthTokenAddress() {
		return ethTokenAddress;
	}

	public void setEthTokenAddress(String ethTokenAddress) {
		this.ethTokenAddress = ethTokenAddress;
	}

	public BigInteger getEthAccountBalance() {
		return ethAccountBalance;
	}

	public void setEthAccountBalance(BigInteger ethAccountBalance) {
		this.ethAccountBalance = ethAccountBalance;
	}

	public BigInteger getEthTokenBalance() {
		return ethTokenBalance;
	}

	public void setEthTokenBalance(BigInteger ethTokenBalance) {
		this.ethTokenBalance = ethTokenBalance;
	}

}
