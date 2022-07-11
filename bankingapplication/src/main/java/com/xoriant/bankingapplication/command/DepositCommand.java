package com.xoriant.bankingapplication.command;

public class DepositCommand {
	
	private long toAccount;
	private double amount;
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	

}
