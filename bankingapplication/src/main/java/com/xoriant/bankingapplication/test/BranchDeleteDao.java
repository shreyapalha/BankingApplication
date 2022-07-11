package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.BranchDao;
import com.xoriant.bankingapplication.model.Branch;

public class BranchDeleteDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		BranchDao branchDao= context.getBean("branchDao",BranchDao.class);
		
		Branch branch = new Branch();
		branch.setBranchId(4);
		branch.setBranchName("BOB");
		branch.setIFSC("244sbobs");
		branchDao.deleteBranch(branch);
	}
	
}
