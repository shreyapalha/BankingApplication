package com.xoriant.bankingapplication.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{

	
	public UserNotFoundException()
	{
		
	}
	
	public UserNotFoundException(String err)
	{
		super(err);
	}
}
