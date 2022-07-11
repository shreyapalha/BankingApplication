package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AddressDao;
import com.xoriant.bankingapplication.model.Address;

public class AddressUpdateDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AddressDao addressDao = context.getBean("addressDao",AddressDao.class);
	
		Address address= new Address();
		address.setAddressId(2);
		address.setCity("jha");
		address.setFlatNo(109);
		address.setPincode(45);
		address.setState("mp");
		addressDao.updateAddress(address);
		System.out.println("address is saved successfully");
	}
	
}
