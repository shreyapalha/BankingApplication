package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AddressDao;

public class AddressDeleteByDao {
	public static void main(String[] args) {
@SuppressWarnings("resource")
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AddressDao addressDao = context.getBean("addressDao",AddressDao.class);
		
		addressDao.deleteAddress(1);
		System.out.println("address is delete successfully");
	}
	
}
