package com.xoriant.bankingapplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountNumber;
	
	@ManyToOne
	@JoinColumn(name="personId")
	private Customer customer;
	private double accountBalance;
	private double minimumBalance;
	private Status accountStatus;
	private Date date;
	private Date dateOfClosure;
	private String description;
	private AccountType accountType;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "fromAccount")
	private List<Transactions> transaction;
	
	
	public List<Transactions> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transactions> transaction) {
		this.transaction = transaction;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public Status getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Status accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateOfClosure() {
		return dateOfClosure;
	}
	public void setDateOfClosure(Date dateOfClosure) {
		this.dateOfClosure = dateOfClosure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", accountBalance="
				+ accountBalance + ", minimumBalance=" + minimumBalance + ", accountStatus=" + accountStatus + ", date="
				+ date + ", dateOfClosure=" + dateOfClosure + ", description=" + description + ", accountType="
				+ accountType + "]";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
	
	/*
	 * @Override public String toString() { return "Account [accountNumber=" +
	 * accountNumber + ", accountBalance=" + accountBalance + ", minimumBalance=" +
	 * minimumBalance + ", accountStatus=" + accountStatus + ", date=" + date +
	 * ", dateOfClosure=" + dateOfClosure + ", description=" + description +
	 * ", accountType=" + accountType + "]"; }
	 */

	
}
