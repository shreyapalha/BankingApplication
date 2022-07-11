package com.xoriant.bankingapplication.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.AccountType;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Branch;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.Status;
import com.xoriant.bankingapplication.model.TransactionStatus;
import com.xoriant.bankingapplication.model.Transactions;
import com.xoriant.bankingapplication.model.User;
import com.xoriant.bankingapplication.util.HibernateUtil;

public class DummyInsertTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trx = session.beginTransaction();

		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("shreya");
		user1.setPassword("123");
		session.save(user1);

		User user2 = new User();
		user2.setUserName("mark");
		user2.setPassword("123");
		session.save(user2);

		User user3 = new User();
		user3.setUserName("Joey");
		user3.setPassword("123");
		session.save(user3);
		
		User user4 = new User();
		user3.setUserName("Monica");
		user3.setPassword("123");
		session.save(user4);

		List<Transactions> transaction = new ArrayList<Transactions>();

		Account account1 = new Account();
		account1.setAccountBalance(99901.23);
		account1.setAccountNumber(1l);
		account1.setAccountStatus(Status.ACTIVE);
		account1.setAccountType(AccountType.CURRENT);
		account1.setDate(new Date(2021, 12, 2));
		account1.setDateOfClosure(new Date(2044, 2, 6));
		account1.setDescription("desc");
		account1.setMinimumBalance(3500);

		Account account2 = new Account();
		account2.setAccountBalance(99901.23);
		account2.setAccountNumber(2l);
		account2.setAccountStatus(Status.ACTIVE);
		account2.setAccountType(AccountType.CURRENT);
		account2.setDate(new Date(2021, 12, 2));
		account2.setDateOfClosure(new Date(2044, 2, 6));
		account2.setDescription("desc");
		account2.setMinimumBalance(3500);
		session.save(account2);
		
		Account account3 = new Account();
		account3.setAccountBalance(99901.23);
		account3.setAccountNumber(3l);
		account3.setAccountStatus(Status.ACTIVE);
		account3.setAccountType(AccountType.CURRENT);
		account3.setDate(new Date(2021, 12, 2));
		account3.setDateOfClosure(new Date(2044, 2, 6));
		account3.setDescription("desc");
		account3.setMinimumBalance(3500);
		session.save(account3);
		
		Transactions trx1 = new Transactions();
		trx1.setTransactionId(1);
		trx1.setAmount(23);
		trx1.setDateOfTransaction(new Date());
		trx1.setToAccount(null);
		trx1.setTransactionStatus(TransactionStatus.SUCCESS);
		trx1.setFromAccount(null);
		transaction.add(trx1);
		account1.setTransaction(transaction);
		session.save(trx1);
		session.save(account1);

		Address address1 = new Address();
		address1.setAddressId(1);
		address1.setFlatNo(119);
		address1.setCity("mandala");
		address1.setPincode(333222);
		address1.setState("MP");
		session.save(address1);

		Branch branch1 = new Branch();
		branch1.setBranchId(1);
		branch1.setBranchName("BOI branch");
		branch1.setIFSC("SDFGHS");
		session.save(branch1);

		List<Account> accountsOfCustomer = new ArrayList<Account>();
		accountsOfCustomer.add(account1);
        Manager manager1 = new Manager();
		manager1.setManagerId(1);
		manager1.setAddress(address1);
		manager1.setGender(Gender.FEMALE);
		manager1.setBranch(branch1);
		manager1.setCustomer(null);
		manager1.setUser(user1);
		manager1.setPersonId(1);
		manager1.setPersonName("Shreya Palha");

		session.save(manager1);

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setAccount(accountsOfCustomer);
		customer.setAddress(address1);
		customer.setBranch(branch1);
		customer.setGender(Gender.MALE);
		customer.setManager(manager1);
		customer.setPersonId(2);
		customer.setPersonName("Markus");
		customer.setUser(user2);
		customer.setStatus(Status.ACTIVE);
		account1.setCustomer(customer);

		List<Account> accountsOfCustomer1 = new ArrayList<Account>();
		accountsOfCustomer1.add(account2);

		Customer customer1 = new Customer();
		
		customer1.setAccount(accountsOfCustomer);
		customer1.setAddress(address1);
		customer1.setBranch(branch1);
		customer1.setGender(Gender.MALE);
		customer1.setManager(manager1);
		customer1.setPersonId(3);
		customer1.setPersonName("Joey Tribbiani");
		customer1.setUser(user3);
		customer1.setStatus(Status.ACTIVE);
		account2.setCustomer(customer1);
		
		accountsOfCustomer1.add(account3);
		
		Customer customer2 = new Customer();
		customer2.setAccount(accountsOfCustomer);
		customer2.setAddress(address1);
		customer2.setBranch(branch1);
		customer2.setGender(Gender.MALE);
		customer2.setManager(manager1);
		customer2.setPersonId(4);
		customer2.setPersonName("ross");
		customer2.setUser(user4);
		customer2.setStatus(Status.ACTIVE);
		account3.setCustomer(customer2);
		
		session.save(customer);
		session.save(customer1);
		session.save(customer2);

		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		customers.add(customer1);
		customers.add(customer2);

		manager1.setCustomer(customers);

		trx.commit();
		session.clear();
		session.close();

	}
}