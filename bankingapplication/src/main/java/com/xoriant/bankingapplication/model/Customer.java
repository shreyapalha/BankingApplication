package com.xoriant.bankingapplication.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("customer")
public class Customer extends PersonalInfo {
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="managerId")
	private Manager manager;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy ="accountNumber")
	private List<Account> account;
	
	private Status status;
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
}

	
