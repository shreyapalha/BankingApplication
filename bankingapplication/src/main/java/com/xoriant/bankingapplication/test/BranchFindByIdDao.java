package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.BranchDao;

public class BranchFindByIdDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		BranchDao branchDao= context.getBean("branchDao",BranchDao.class);
		
		System.out.println(branchDao.findById(1));
	}
	
}
