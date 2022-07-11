package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.UserDao;

public class UserLoginTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		UserDao userDao =  (UserDao) context.getBean("userDao");
		System.out.println(userDao.authenticateUser("usetosif", "1"));
	}
}