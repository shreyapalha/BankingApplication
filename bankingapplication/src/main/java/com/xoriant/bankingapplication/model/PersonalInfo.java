package com.xoriant.bankingapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	
	private String personName;
	
	private Gender gender;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="branchId")
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;

	@Column(name="role",insertable=false,updatable = false)
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PersonalInfo [personId=" + personId + ", personName=" + personName + ", gender=" + gender + ", user="
				+ user + ", branch=" + branch + ", address=" + address + "]";
	}

}
