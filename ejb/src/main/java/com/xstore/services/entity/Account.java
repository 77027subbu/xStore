package com.xstore.services.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private int accountId;

	@Column(name="account_acl")
	private String accountAcl;

	@Column(name="account_name")
	private String accountName;

	@Column(name="account_secret")
	private String accountSecret;

	@Column(name="account_status")
	private String accountStatus;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="account")
	private List<Order> orders;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountAcl() {
		return this.accountAcl;
	}

	public void setAccountAcl(String accountAcl) {
		this.accountAcl = accountAcl;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountSecret() {
		return this.accountSecret;
	}

	public void setAccountSecret(String accountSecret) {
		this.accountSecret = accountSecret;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setAccount(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setAccount(null);

		return order;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

}