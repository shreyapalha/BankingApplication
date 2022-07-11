package com.xoriant.bankingapplication.command;

import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Status;

public class CustomerCommand {
	
	private String personName;
	private Gender gender;
	
	private Status customerStatus;
	
	private int flatNo;
	private String city;
	private String state;
	private int pincode;
	
	private int branchId;
	
	private String username;
	private String password;
	
	private int managerId;
	
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Status getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(Status customerStatus) {
		this.customerStatus = customerStatus;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
