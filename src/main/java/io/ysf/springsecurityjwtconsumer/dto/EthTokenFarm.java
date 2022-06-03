package io.ysf.springsecurityjwtconsumer.dto;

import java.util.ArrayList;
import java.util.List;

public class EthTokenFarm {
	private String contractAddress;
	private String ownerAddress;
	private List<String> ethAvailableTokenAddress = new ArrayList<>();
	private List<EthAccount> ethAvailableAccounts = new ArrayList<>();

	public List<String> getEthAvailableTokenAddress() {
		return ethAvailableTokenAddress;
	}

	public void setEthAvailableTokenAddress(List<String> ethAvailableTokenAddress) {
		this.ethAvailableTokenAddress = ethAvailableTokenAddress;
	}

	public List<EthAccount> getEthAvailableAccounts() {
		return ethAvailableAccounts;
	}

	public void setEthAvailableAccounts(List<EthAccount> ethAvailableAccounts) {
		this.ethAvailableAccounts = ethAvailableAccounts;
	}

	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	@Override
	public String toString() {
		return "EthTokenFarm [contractAddress=" + contractAddress + ", ownerAddress=" + ownerAddress
				+ ", ethAvailableTokenAddress=" + ethAvailableTokenAddress + ", ethAvailableAccounts="
				+ ethAvailableAccounts + "]";
	}

}
