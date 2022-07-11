package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AddressDao;

public class AddressFindByIdDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AddressDao addressDao = context.getBean("addressDao",AddressDao.class);
		
		System.out.println(addressDao.findById(1));
	}
	
}
