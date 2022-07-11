package com.xoriant.bankingapplication.command;

import javax.validation.constraints.NotNull;

public class LoginCommand {

	@NotNull(message="is required")
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
