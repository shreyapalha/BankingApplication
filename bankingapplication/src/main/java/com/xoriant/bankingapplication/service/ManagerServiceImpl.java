package com.xoriant.bankingapplication.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.AccountDao;
import com.xoriant.bankingapplication.dao.AddressDao;
import com.xoriant.bankingapplication.dao.BranchDao;
import com.xoriant.bankingapplication.dao.CustomerDao;
import com.xoriant.bankingapplication.dao.ManagerDao;
import com.xoriant.bankingapplication.dao.TransactionDao;
import com.xoriant.bankingapplication.dao.UserDao;
import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Branch;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.Status;
import com.xoriant.bankingapplication.model.Transactions;
import com.xoriant.bankingapplication.model.User;

@Transactional
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ManagerDao managerDao;
	
	

	@Override
	public void deposit(long accountNumber, double amount) {
		Account account = accountDao.findById(accountNumber);
		account.setAccountBalance(account.getAccountBalance()-amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void withdrawal(long accountNumber, double amount) {
		Account account = accountDao.findById(accountNumber);
		account.setAccountBalance(account.getAccountBalance()+amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void fundTransfer(long toAccountNumber, long fromAccountNumber, double amount) {
		deposit(toAccountNumber,amount);
		withdrawal(fromAccountNumber, amount);
		Account toAccount = accountDao.findById(toAccountNumber);
		Account fromAccount = accountDao.findById(fromAccountNumber);
		Transactions trx1 = new Transactions();
		trx1.setAmount(amount);
		trx1.setDateOfTransaction(new Date());
		trx1.setFromAccount(fromAccount);
		trx1.setToAccount(toAccount);
		transactionDao.saveNewTransactions(trx1);
		List<Transactions> fromTransactions = fromAccount.getTransaction();
		List<Transactions> toTransactions = toAccount.getTransaction();
		fromTransactions.add(trx1);
		toTransactions.add(trx1);
		fromAccount.setTransaction(fromTransactions);
		toAccount.setTransaction(toTransactions);
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String confirmPassword,int userId) {
		User user = userDao.findById(userId);
		if(user.getPassword().equals(oldPassword)) {
			if(confirmPassword.equals(newPassword))
			user.setPassword(newPassword);
			userDao.updateUser(user);
		}
		else {
			System.out.println("oldpassord is not correct");
		}
	}

	@Override
	public double balanceEnquiry(long accountNumber) {
		Account account = accountDao.findById(accountNumber);
		
		return account.getAccountBalance();
		
	}

	@Override
	public void miniStatement(long accountNumber) {
		

	}

	@Override
	public void customizedStatement(long accountNumber, String name, Object value) {
		
	}

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void authManager(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User authUser(String userName, String password) {
		User user= userDao.authenticateUser(userName, password);
		return user;
	}
	

	@Override
	public Manager managerFindById(Integer personId) {
		return managerDao.findById(personId);
	}

	@Override
	public void addCustomer(Customer customer, Branch branch, User user, Address address, Manager manager) {
		customer.setAddress(address);
		customer.setBranch(branch);
		customer.setUser(user);
		customer.setManager(manager);
		customer.setUser(user);
		
		addressDao.saveNewAddress(address);
		userDao.saveNewUser(user);
		customerDao.saveNewCustomer(customer);
		
	}

	@Override
	public Address adderssFindById(Integer addressId) {
		return addressDao.findById(addressId);
	}

	@Override
	public Branch branchFindById(int branchId) {
		return branchDao.findById(branchId);
	}

	@Override
	public Customer customerFindById(int personId) {
		return customerDao.getCustomerByPersonId(personId);
	}

	@Override
	public Account accountFindById(long accountNumber) {
		return accountDao.findById(accountNumber);
	}

	@Override
	public void updateCustomer(Customer customer, Account account, Branch branch, Address address) {
		account.setCustomer(customer);
		customer.setBranch(branch);
		customer.setAddress(address);

		accountDao.updateAccount(account);
		branchDao.updateBranch(branch);
		addressDao.updateAddress(address);
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) throws UserNotFoundException {
		System.out.println("--------"+customer);
		customer.setStatus(Status.INACTIVE);
		List<Account> listOfAccounts = null;
		try {
			listOfAccounts = accountDao.findByCustomerId(customer.getPersonId());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("<<<< "+listOfAccounts);
		customerDao.updateCustomer(customer);
		for (Account aa : listOfAccounts) {
			aa.setAccountStatus(Status.INACTIVE);
			accountDao.updateAccount(aa);
			System.out.println("*******"+aa);
		}
	}
	
	

}