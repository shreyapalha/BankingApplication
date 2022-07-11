package com.xoriant.bankingapplication.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.exception.InsufficientBalanceException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.AccountType;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Status;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.service.CustomerService;

public class AccountServiceTest {

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws InsufficientBalanceException {
ApplicationContext context = new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
		
		AccountService accountService=(AccountService) context.getBean("accountService");
		CustomerService customerService=(CustomerService) context.getBean("customerService");
//		accountDao.depositBalance(1, 5000.0);
//		System.out.println("deposited succesfully");
		
//		Account account=accountDao.findById(6l);
//		accountService.withdrawAmount(1l, 5000);
		
		Customer customer=customerService.getCustomerByPersonId(7);
		System.out.println(customer);
		System.out.println(customer.getPersonName());
		
		
		Account account1=new Account();
		account1.setAccountBalance(99901.23);
		account1.setAccountNumber(1l);
		account1.setAccountStatus(Status.ACTIVE);
		account1.setAccountType(AccountType.CURRENT);
		account1.setDate(new Date(2021, 12, 2));
		account1.setDateOfClosure(new Date(2044, 2, 6));
		account1.setDescription("desc");
		account1.setMinimumBalance(3500);
		account1.setCustomer(customer);
		accountService.createAccount(account1);
		
		

	}

}
