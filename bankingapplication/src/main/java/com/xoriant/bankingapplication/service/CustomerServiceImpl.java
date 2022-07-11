package com.xoriant.bankingapplication.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.AccountDao;
import com.xoriant.bankingapplication.dao.CustomerDao;
import com.xoriant.bankingapplication.dao.TransactionDao;
import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Transactions;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private TransactionDao transactionDao;

	@Override
	public void balanceEnquiry(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fundTransfer(long toAccountNumber, long fromAccountNumber, double amount) {
		deposit(toAccountNumber, amount);
		withdrawal(fromAccountNumber, amount);
		Account toAccount = accountDao.findById(toAccountNumber);
		Account fromAccount = accountDao.findById(fromAccountNumber);
		Transactions trx1 = new Transactions();
		trx1.setAmount(amount);
		trx1.setDateOfTransaction(new Date(System.currentTimeMillis()));
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

	private void deposit(long accountNumber, double amount) {
		Account account = accountDao.findById(accountNumber);
		account.setAccountBalance(account.getAccountBalance() - amount);
		accountDao.updateAccount(account);
	}

	private void withdrawal(long accountNumber, double amount) {
		Account account = accountDao.findById(accountNumber);
		account.setAccountBalance(account.getAccountBalance() + amount);
		accountDao.updateAccount(account);
	}

	@Override
	public List<Transactions> miniStatement(long accountNumber) {
		Account account = accountDao.findById(accountNumber);
		 return transactionDao.statement(account);
		
	}

	@Override
	public void customizedStatement(int accountNumber, Date toDate, Date fromDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
     public List<Account> getAccount(int userId) throws  UserNotFoundException {
		
		return accountDao.findByCustomerId(userId);
	}

	
	@Override
	public List<Transactions> customizedStatement(long accountNumber, Date toDate, Date fromDate,
			double amountLowerLimit, int numberOfTransaction) {
		Account account = accountDao.findById(accountNumber);
		return transactionDao.customizedStatement(account, fromDate, toDate, amountLowerLimit, numberOfTransaction);

	}
	@Override
	public Customer getCustomerByPersonId(int personId) {
		return customerDao.getCustomerByPersonId(personId);
	}

}
