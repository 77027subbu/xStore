/**
 * 
 */
package com.xstore.services.exception;

import javax.xml.ws.WebFault;

import com.xstore.services.web.fault.XStoreFault;

/**
 * @author subbu
 * 
 */
@WebFault(name="XStoreFault", faultBean="com.xstore.services.web.fault.XStoreFault",targetNamespace="http://xstore.com/wsdl")
public class XStoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9040927147178399960L;
	private XStoreFault xStoreFault;
	
	/**
	 * @return the xStoreFault
	 */
	public XStoreFault getFaultInfo() {
		return xStoreFault;
	}

	/**
	 * 
	 */
	public XStoreException() {

	}

	/**
	 * @param xStoreFault
	 */
	public XStoreException(XStoreFault xStoreFault) {
		super(xStoreFault.getFaultString()); 
		this.xStoreFault = xStoreFault;
	}
	
	/**
	 * @param message
	 * @param xStoreFault
	 */
	public XStoreException(String message, XStoreFault xStoreFault) {
		super(message); 
		this.xStoreFault = xStoreFault;
	}

	/**
	 * @param message
	 * @param xStoreFault
	 * @param cause
	 */
	public XStoreException(String message, XStoreFault xStoreFault, Throwable cause) {
		super(message, cause); 
		this.xStoreFault = xStoreFault;
	}
	
	/**
	 * @param message
	 */
	public XStoreException(String message) {
		super(message); 
	}
	
	/**
	 * @param cause
	 */
	public XStoreException(Throwable cause) {
		super(cause); 
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public XStoreException(String message, Throwable cause) {
		super(message, cause); 
	}
	
	/**
	 * @param code
	 * @param message
	 */
	public XStoreException(String code, String message) {
		super(message); 
		this.xStoreFault = new XStoreFault();
		this.xStoreFault.setFaultCode(code);
		this.xStoreFault.setFaultString(message);
	}
}
