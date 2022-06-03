package io.ysf.springsecurityjwtconsumer.dto;

public class EthOutput {
	private EthAccount ethAccount;
	private EthTokenFarm ethTokenFarm;

	public EthAccount getEthAccount() {
		return ethAccount;
	}

	public void setEthAccount(EthAccount ethAccount) {
		this.ethAccount = ethAccount;
	}

	public EthTokenFarm getEthTokenFarm() {
		return ethTokenFarm;
	}

	public void setEthTokenFarm(EthTokenFarm ethTokenFarm) {
		this.ethTokenFarm = ethTokenFarm;
	}

	@Override
	public String toString() {
		return "EthOutput [ethAccount=" + ethAccount + ", ethTokenFarm=" + ethTokenFarm + "]";
	}

}
