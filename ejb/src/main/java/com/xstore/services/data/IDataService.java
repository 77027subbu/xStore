package com.xstore.services.data;

import java.util.List;

import javax.ejb.Local;

import com.xstore.services.entity.Account;
import com.xstore.services.entity.Order;
import com.xstore.services.exception.XStoreException;

@Local
public interface IDataService {
	
	/**
	 * This method returns the Account details given an accountName
	 * 
	 * @param accountName
	 * @param clientId
	 * @return
	 */
	public Account findAccount(String accountName, String clientId) throws XStoreException;
	
	/**
	 * This method returns the Order detail given an accountName
	 * 
	 * @param accountName
	 * @param clientId
	 * @return
	 */
	public List<Order> findOrder(String accountName, String clientId) throws XStoreException;
}
