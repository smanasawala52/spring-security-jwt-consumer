package io.ysf.springsecurityjwtconsumer.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EthTokenFarm {
	private String contractAddress;
	private String ownerAddress;
	private String currentUserAddress;
	private Map<String, String> ethAvailableTokenAddress = new HashMap<>();
	private List<EthAccount> ethAvailableAccounts = new ArrayList<>();
	private boolean flagAnyTokenStaked = false;

	public Map<String, String> getEthAvailableTokenAddress() {
		return ethAvailableTokenAddress;
	}

	public void setEthAvailableTokenAddress(Map<String, String> ethAvailableTokenAddress) {
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

	public String getCurrentUserAddress() {
		return currentUserAddress;
	}

	public void setCurrentUserAddress(String currentUserAddress) {
		this.currentUserAddress = currentUserAddress;
	}

	public boolean isFlagAnyTokenStaked() {
		return flagAnyTokenStaked;
	}

	public void setFlagAnyTokenStaked(boolean flagAnyTokenStaked) {
		this.flagAnyTokenStaked = flagAnyTokenStaked;
	}

	@Override
	public String toString() {
		return "EthTokenFarm [contractAddress=" + contractAddress + ", ownerAddress=" + ownerAddress
				+ ", currentUserAddress=" + currentUserAddress + ", ethAvailableTokenAddress="
				+ ethAvailableTokenAddress + ", ethAvailableAccounts=" + ethAvailableAccounts + ", flagAnyTokenStaked="
				+ flagAnyTokenStaked + "]";
	}

}
