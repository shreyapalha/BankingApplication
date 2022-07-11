package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.UserDao;
import com.xoriant.bankingapplication.model.User;

public class UserDeleteDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/xoriant/bankingapplication/test/config.xml");

		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = new User();
		user.setUserName("ds");
		user.setPassword("45");
		user.setUserId(10);
		userDao.deleteUser(user);
		System.out.println("User is delete successfully");
	}

}
