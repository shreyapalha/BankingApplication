package com.xoriant.bankingapplication.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.BranchDao;
import com.xoriant.bankingapplication.model.Branch;

public class BranchSaveDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		System.out.println("Bean names: " + Arrays.toString(context.getBeanNamesForType(BranchDao.class)));
        BranchDao branchDaoImpl =  (BranchDao) context.getBean("branchDao");
        
		Branch branch = new Branch();
		branch.setBranchId(3);
		branch.setBranchName("sOB");
		branch.setIFSC("dfdd");
		branchDaoImpl.saveNewBranch(branch);
		System.out.println("Branch is saved successfully");
	}
	
}
