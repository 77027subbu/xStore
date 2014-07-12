/**
 * 
 */
package com.xstore.services.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author subbu
 * 
 */

@XmlRootElement(namespace = "http://xstore.com/wsdl", name = "GetAccountResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://xstore.com/wsdl", name = "", propOrder = {
		"clientId", "accountId", "accountName", "orderCount" })
public class GetAccountResponse {
	
	@XmlElement(required = true)
	private String clientId;
	
	@XmlElement(required = true)
	private String accountId;
	
	@XmlElement(required = true)
	private String accountName;
	
	@XmlElement(required = true)
	private String orderCount;

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the orderCount
	 */
	public String getOrderCount() {
		return orderCount;
	}

	/**
	 * @param orderCount
	 *            the orderCount to set
	 */
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
