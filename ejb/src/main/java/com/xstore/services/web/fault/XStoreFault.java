/**
 * 
 */
package com.xstore.services.web.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author subbu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "faultCode","faultString"
})
@XmlRootElement(name = "XStoreFault")
public class XStoreFault {
	
	@XmlElement(required = true)
	private String faultCode;
	
	@XmlElement(required = true)
	private String faultString;
	
	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}
	/**
	 * @param faultCode the faultCode to set
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	/**
	 * @return the faultString
	 */
	public String getFaultString() {
		return faultString;
	}
	/**
	 * @param faultString the faultString to set
	 */
	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}
	
	public static XStoreFault getInstance(String faultCode, String faultString) {
		XStoreFault xStoreFault = new XStoreFault();
		xStoreFault.setFaultCode(faultCode);
		xStoreFault.setFaultString(faultString);
		return xStoreFault;
	}

}
