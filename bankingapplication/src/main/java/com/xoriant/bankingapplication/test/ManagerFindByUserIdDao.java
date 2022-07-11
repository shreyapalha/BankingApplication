package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.ManagerDao;

public class ManagerFindByUserIdDao {
	public static void main(String[] args) {
@SuppressWarnings("resource")
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		ManagerDao managerDao =  (ManagerDao) context.getBean("managerDao");
		
		System.out.println(	managerDao.findByUserId(1));
	}
	
}

