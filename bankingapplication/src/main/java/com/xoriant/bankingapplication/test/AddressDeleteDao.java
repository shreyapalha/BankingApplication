package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AddressDao;
import com.xoriant.bankingapplication.model.Address;

public class AddressDeleteDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AddressDao addressDao = context.getBean("addressDao",AddressDao.class);
	
		Address address= new Address();
		address.setAddressId(4);
		address.setCity("indore");
		address.setFlatNo(209);
		address.setPincode(20344);
		address.setState("mp");
		addressDao.deleteAddress(address);
		System.out.println("delete is saved successfully");
	}
	
}
