package com.xstore.services.data.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.xstore.services.data.IDataService;
import com.xstore.services.entity.Account;
import com.xstore.services.entity.Order;

/**
 * Session Bean implementation class DataService
 */
@Stateless
public class DataService implements IDataService {

private final static Logger logger = Logger.getLogger(DataService.class.getName());
	
	@PersistenceContext(unitName="xStoreServices")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DataService() {
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * This method returns the Account details given an accountName
	 * 
	 * @param accountName
	 * @param clientId
	 * @return
	 */
	public Account findAccount(String accountName, String clientId) {
		Account account = null;
		logger.info("accountName - " + accountName);
		logger.info("clientId - " + clientId);
		try {
			TypedQuery<Account> qry = em.createQuery("select A from Account A where A.client.clientName=:clientId and A.accountName=:accountName", Account.class);
			qry.setParameter("accountName", accountName);
			qry.setParameter("clientId", clientId);
			account = qry.getSingleResult();
			logger.info("Number of records fetched - " + account);
		} catch(Exception e) {
			logger.severe("Error occured - " + e.getMessage());
			logger.severe("Stacktrace - \n" + ExceptionUtils.getStackTrace(e));
		}
		return account;
	}
	
	/**
	 * This method returns the Order detail given an accountName
	 * 
	 * @param accountName
	 * @param clientId
	 * @return
	 */
	public List<Order> findOrder(String accountName, String clientId) {
		List<Order> orders = null;
		logger.info("accountName - " + accountName);
		logger.info("clientId - " + clientId);
		try {
			TypedQuery<Order> qry = em.createQuery("select O from Order O where O.account.client.clientName=:clientId and O.account.accountName=:accountName", Order.class);
			qry.setParameter("accountName", accountName);
			qry.setParameter("clientId", clientId);
			orders = qry.getResultList();
			logger.info("Number of records fetched - " + orders.size());
		} catch(Exception e) {
			logger.severe("Error occured - " + e.getMessage());
			logger.severe("Stacktrace - \n" + ExceptionUtils.getStackTrace(e));
		}
		return orders;
	}

}
