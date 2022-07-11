package com.xoriant.bankingapplication.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("manager")
public class Manager extends PersonalInfo {
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	
	@OneToMany(mappedBy = "manager",cascade = CascadeType.PERSIST)
	private List<Customer> customer;

	
	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	@Override
	public String toString() {
		return "Manager [personId=" + super.getPersonId() + ", personName=" + super.getPersonName() 
		+ ", gender=" + super.getGender() + ", user="
				+ super.getUser() + ", address=" + super.getAdress() + ", branch=" +
				super.getBranch() + "managerId=" + managerId +"]";
	}
	
}
