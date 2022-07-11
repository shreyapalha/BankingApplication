package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.AccountDao;


public class AccountBalanceDao {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
	
		accountDao.depositBalance(1l,100000l);
		//accountDao.withdrawBalance(1l,100000l);
	}
	
}
