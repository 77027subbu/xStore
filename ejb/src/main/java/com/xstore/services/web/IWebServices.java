package com.xstore.services.web;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.xstore.services.exception.XStoreException;
import com.xstore.services.web.model.GetAccountRequest;
import com.xstore.services.web.model.GetAccountResponse;

@Local
@WebService(name = "xStoreWebServices", targetNamespace = "http://xstore.com/wsdl")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface IWebServices {
	/**
	 * This method returns the Account details of a given client and account
	 * 
	 * @param getAccountRequest
	 * @return
	 */
	@WebResult(name = "GetAccountResponse", targetNamespace = "")
	@RequestWrapper(localName = "GetAccountDetailRequest", targetNamespace = "http://xstore.com/wsdl", className="com.xstore.services.web.model.GetAccountDetailRequest")
	@WebMethod(operationName = "GetAccountDetail")
	@ResponseWrapper(localName = "GetAccountDetailResponse", targetNamespace = "http://xstore.com/wsdl", className="com.xstore.services.web.model.GetAccountDetailResponse")
	public GetAccountResponse GetAccountDetail(
			@WebParam(name = "GetAccountRequest", targetNamespace = "http://xstore.com/wsdl") GetAccountRequest getAccountRequest) throws XStoreException;
}