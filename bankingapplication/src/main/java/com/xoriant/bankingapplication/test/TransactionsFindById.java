package com.xoriant.bankingapplication.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.TransactionDao;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Status;
import com.xoriant.bankingapplication.model.AccountType;

public class TransactionsFindById {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/xoriant/bankingapplication/test/config.xml");

		Account account1 = new Account();
		account1.setAccountBalance(99901.23);
		account1.setAccountNumber(1);
		account1.setAccountStatus(Status.ACTIVE);
		account1.setAccountType(AccountType.CURRENT);
		account1.setDate(new Date(2021, 12, 2));
		account1.setDateOfClosure(new Date(2032, 12, 31));
		account1.setDescription("description");
		account1.setMinimumBalance(3500);

		account1.setTransaction(null);

		TransactionDao trans = (TransactionDao) context.getBean("transactionsDao");
		System.out.println(trans.findByAccount(account1));
	}

}
