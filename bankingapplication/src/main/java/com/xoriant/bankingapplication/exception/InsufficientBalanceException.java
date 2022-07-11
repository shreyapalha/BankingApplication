package com.xoriant.bankingapplication.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception  {
	
	public InsufficientBalanceException() {
		// TODO Auto-generated constructor stub
	}
	
	public InsufficientBalanceException(String msg)
	{
		super(msg);
	}

}
