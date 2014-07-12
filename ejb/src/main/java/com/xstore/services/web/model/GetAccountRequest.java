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

@XmlRootElement(namespace = "http://xstore.com/wsdl", name = "GetAccountRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://xstore.com/wsdl", name = "", propOrder= {"clientId","accountId"})
public class GetAccountRequest {
	
	@XmlElement(required = true, nillable=false)
	private String clientId;
	
	@XmlElement(required = true, nillable=false)
	private String accountId;
	
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
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
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
