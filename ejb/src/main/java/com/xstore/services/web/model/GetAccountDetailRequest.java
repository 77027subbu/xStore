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

@XmlRootElement(namespace = "http://xstore.com/wsdl", name = "GetAccountDetailRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://xstore.com/wsdl", name = "", propOrder= {"getAccountRequest"})
public class GetAccountDetailRequest {
	
	@XmlElement(required = true, nillable=false,name="GetAccountRequest",namespace="http://xstore.com/wsdl")
	private GetAccountRequest getAccountRequest;

	/**
	 * @return the getAccountRequest
	 */
	public GetAccountRequest getGetAccountRequest() {
		return getAccountRequest;
	}

	/**
	 * @param getAccountRequest the getAccountRequest to set
	 */
	public void setGetAccountRequest(GetAccountRequest getAccountRequest) {
		this.getAccountRequest = getAccountRequest;
	}
}
