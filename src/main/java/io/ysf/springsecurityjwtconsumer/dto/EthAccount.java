package io.ysf.springsecurityjwtconsumer.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EthAccount {
	private String ethAccount;
	private String ethAccountPrivateKey;
	private BigInteger ethUserTotalValue;
	private List<EthToken> ethToken = new ArrayList<>();

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

	public List<EthToken> getEthToken() {
		return ethToken;
	}

	public void setEthToken(List<EthToken> ethToken) {
		this.ethToken = ethToken;
	}

	public BigInteger getEthUserTotalValue() {
		return ethUserTotalValue;
	}

	public void setEthUserTotalValue(BigInteger ethUserTotalValue) {
		this.ethUserTotalValue = ethUserTotalValue;
	}

	@Override
	public String toString() {
		return "EthAccount [ethAccount=" + ethAccount + ", ethAccountPrivateKey=" + ethAccountPrivateKey
				+ ", ethUserTotalValue=" + ethUserTotalValue + ", ethToken=" + ethToken + "]";
	}

}
