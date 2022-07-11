package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AccountDao;

public class AccountDaoDeposit {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		AccountDao accountDao=(AccountDao) context.getBean("accountDao");
     	accountDao.depositBalance(1, 5000.0);
		System.out.println("deposited succesfully");
		
     	
		
	}
}
