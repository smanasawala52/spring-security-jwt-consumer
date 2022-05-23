package io.ysf.springsecurityjwtconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:envionment.properties")
public class EthAccountConfig {
	@Value("${URL}")
	private String url;

	@Value("${ETH_ADDRESS_ACCOUNT_1}")
	private String ethAddressAccount1;

	@Value("${ETH_ADDRESS_ACCOUNT_2}")
	private String ethAddressAccount2;

	@Value("${ETH_PRIVATE_KEY_ACCOUNT_1}")
	private String ethPrivateKeyAccount1;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the ethAddressAccount1
	 */
	public String getEthAddressAccount1() {
		return ethAddressAccount1;
	}

	/**
	 * @param ethAddressAccount1
	 *            the ethAddressAccount1 to set
	 */
	public void setEthAddressAccount1(String ethAddressAccount1) {
		this.ethAddressAccount1 = ethAddressAccount1;
	}

	/**
	 * @return the ethAddressAccount2
	 */
	public String getEthAddressAccount2() {
		return ethAddressAccount2;
	}

	/**
	 * @param ethAddressAccount2
	 *            the ethAddressAccount2 to set
	 */
	public void setEthAddressAccount2(String ethAddressAccount2) {
		this.ethAddressAccount2 = ethAddressAccount2;
	}

	/**
	 * @return the ethPrivateKeyAccount1
	 */
	public String getEthPrivateKeyAccount1() {
		return ethPrivateKeyAccount1;
	}

	/**
	 * @param ethPrivateKeyAccount1
	 *            the ethPrivateKeyAccount1 to set
	 */
	public void setEthPrivateKeyAccount1(String ethPrivateKeyAccount1) {
		this.ethPrivateKeyAccount1 = ethPrivateKeyAccount1;
	}

	/**
	 * @return the ethPrivateKeyAccount2
	 */
	public String getEthPrivateKeyAccount2() {
		return ethPrivateKeyAccount2;
	}

	/**
	 * @param ethPrivateKeyAccount2
	 *            the ethPrivateKeyAccount2 to set
	 */
	public void setEthPrivateKeyAccount2(String ethPrivateKeyAccount2) {
		this.ethPrivateKeyAccount2 = ethPrivateKeyAccount2;
	}

	@Value("${ETH_PRIVATE_KEY_ACCOUNT_2}")
	private String ethPrivateKeyAccount2;
}
