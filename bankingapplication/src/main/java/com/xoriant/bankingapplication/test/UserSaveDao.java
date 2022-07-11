package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.UserDao;
import com.xoriant.bankingapplication.model.User;

public class UserSaveDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		UserDao userDao =  (UserDao) context.getBean("userDao");
		
		//UserDaoImpl userDao = new UserDaoImpl();
		User user = new User();
		user.setUserName("piyush");
		user.setPassword("p36");
		userDao.saveNewUser(user);

		System.out.println("User is saved successfully");
	}
	
}
