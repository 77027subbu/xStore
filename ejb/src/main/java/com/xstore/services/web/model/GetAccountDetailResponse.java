/**
 * 
 */
package com.xstore.services.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author subbu
 *
 */

@XmlRootElement(namespace = "http://xstore.com/wsdl", name = "GetAccountDetailResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://xstore.com/wsdl", name = "", propOrder= {"getAccountResponse"})
public class GetAccountDetailResponse {
	
	@XmlElement(required = true, nillable=false,name="GetAccountResponse",namespace="http://xstore.com/wsdl")
	private GetAccountResponse getAccountResponse;

	/**
	 * @return the getAccountResponse
	 */
	public GetAccountResponse getGetAccountResponse() {
		return getAccountResponse;
	}

	/**
	 * @param getAccountResponse the getAccountResponse to set
	 */
	public void setGetAccountRequest(GetAccountResponse getAccountResponse) {
		this.getAccountResponse = getAccountResponse;
	}
}
