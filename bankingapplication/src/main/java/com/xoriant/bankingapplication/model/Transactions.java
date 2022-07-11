package com.xoriant.bankingapplication.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "accountNumber")
	private Account fromAccount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Account toAccount;
	
	private double amount;
	private Date dateOfTransaction;
	private TransactionStatus transactionStatus;

	
	
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", dateOfTransaction=" + dateOfTransaction + "]";
	}

}
