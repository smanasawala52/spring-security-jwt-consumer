package io.ysf.springsecurityjwtconsumer.dto;

import java.math.BigInteger;

public class EthToken {
	private String ethTokenAddress;
	private String ethTokenName;
	private BigInteger ethAccountBalance;
	private BigInteger ethTokenBalance;
	private BigInteger ethUserTokenStakingBalanceEthValue;
	private BigInteger ethTokenEthPrice;

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

	public String getEthTokenName() {
		return ethTokenName;
	}

	public void setEthTokenName(String ethTokenName) {
		this.ethTokenName = ethTokenName;
	}

	public BigInteger getEthUserTokenStakingBalanceEthValue() {
		return ethUserTokenStakingBalanceEthValue;
	}

	public void setEthUserTokenStakingBalanceEthValue(BigInteger ethUserTokenStakingBalanceEthValue) {
		this.ethUserTokenStakingBalanceEthValue = ethUserTokenStakingBalanceEthValue;
	}

	public BigInteger getEthTokenEthPrice() {
		return ethTokenEthPrice;
	}

	public void setEthTokenEthPrice(BigInteger ethTokenEthPrice) {
		this.ethTokenEthPrice = ethTokenEthPrice;
	}

	@Override
	public String toString() {
		return "EthToken [ethTokenAddress=" + ethTokenAddress + ", ethTokenName=" + ethTokenName
				+ ", ethAccountBalance=" + ethAccountBalance + ", ethTokenBalance=" + ethTokenBalance
				+ ", ethUserTokenStakingBalanceEthValue=" + ethUserTokenStakingBalanceEthValue + ", ethTokenEthPrice="
				+ ethTokenEthPrice + "]";
	}

}
