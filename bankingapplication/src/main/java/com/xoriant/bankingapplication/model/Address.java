package com.xoriant.bankingapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private int flatNo;
	private String city;
	private String state;
	private int pincode;
	
	public Address() {}
	
	public Address(int addressId, int flatNo, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.flatNo = flatNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
}
