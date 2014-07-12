package com.xstore.services.web.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.xstore.services.data.IDataService;
import com.xstore.services.entity.Account;
import com.xstore.services.entity.Order;
import com.xstore.services.web.IWebServices;
import com.xstore.services.web.model.GetAccountRequest;
import com.xstore.services.web.model.GetAccountResponse;

/**
 * Session Bean implementation class WebServices
 */
@Stateless
@WebService(name = "xStoreWebServices", portName = "xStoreWebServicePort", serviceName = "xStoreWebService", targetNamespace = "http://xstore.com/wsdl", endpointInterface = "com.xstore.services.web.IWebServices")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class WebServices implements IWebServices {

	private static final Logger logger = Logger.getLogger(WebServices.class
			.getName());

	@EJB
	private IDataService dataService;

	/**
	 * Default constructor.
	 */
	public WebServices() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method returns the Account details of a given client and account
	 * 
	 * @param getAccountRequest
	 * @return
	 */
	@WebResult(name = "GetAccountResponse", targetNamespace = "")
	@RequestWrapper(localName = "GetAccountDetailRequest", targetNamespace = "http://xstore.com/wsdl", className = "com.xstore.ws.client.GetAccountDetail")
	@WebMethod(operationName = "GetAccountDetail")
	@ResponseWrapper(localName = "GetAccountDetailResponse", targetNamespace = "http://xstore.com/wsdl", className = "com.xstore.ws.client.GetAccountDetailResponse")
	public GetAccountResponse GetAccountDetail(
			@WebParam(name = "GetAccountRequest", targetNamespace = "http://xstore.com/wsdl") GetAccountRequest getAccountRequest) {
		GetAccountResponse gResponse = new GetAccountResponse();
		logger.info("Request - " + getAccountRequest);
		try {
			String accountID = getAccountRequest.getAccountId();
			String clientID = getAccountRequest.getClientId();

			// Find the list of orders
			List<Order> orders = dataService.findOrder(accountID, clientID);

			// Find the account details
			Account account = dataService.findAccount(accountID, clientID);

			gResponse.setAccountId(accountID);
			gResponse.setAccountName(account.getAccountName());
			gResponse.setClientId(clientID);
			gResponse.setOrderCount(String.valueOf(orders.size()));
		} catch (Exception e) {
			logger.severe("Error occured - " + e.getMessage());
			logger.severe("Stacktrace - \n" + ExceptionUtils.getStackTrace(e));
		}

		return gResponse;
	}
}
