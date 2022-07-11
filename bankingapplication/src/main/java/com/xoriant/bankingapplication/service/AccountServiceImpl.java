package com.xoriant.bankingapplication.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.AccountDao;
import com.xoriant.bankingapplication.dao.TransactionDao;
import com.xoriant.bankingapplication.exception.InsufficientBalanceException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.TransactionStatus;
import com.xoriant.bankingapplication.model.Transactions;

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernate() {
		return hibernateTemplate;
	}

	public void setHibernate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean authAccount(int accountNumber) {
		Account account=accountDao.findById(accountNumber);
		if(account==null)
		return false;
		else
			return true;
	}

	
	public void depositAmount(int accountNumber, Long amount) {
		accountDao.depositBalance(accountNumber, amount);

	}

	@Override
	public boolean authAccount(long accountNumber) {
		Account account=accountDao.findById(accountNumber);
		if(account==null)
		return false;
		else
			return true;
	}

	@Override
	public void depositAmount(long accountNumber, double amount) {
		accountDao.depositBalance(accountNumber, amount);

		
	}


	@Override
	public double getBalanceByAccountNo(long toAccount) {
		double balance=accountDao.getBalance(toAccount);
		return balance;
	}


	@Override
	public void withdrawAmount(long toAccount, double amount) throws InsufficientBalanceException {
		Transactions trx1 = new Transactions();
		Account account = accountDao.findById(toAccount);
		trx1.setAmount(amount);
		trx1.setDateOfTransaction(new Date(System.currentTimeMillis()));
		trx1.setFromAccount(account);
		trx1.setToAccount(null);
		double balance = account.getAccountBalance();
		if (balance < amount) {
			trx1.setTransactionStatus(TransactionStatus.FAILED);
			transactionDao.saveNewTransactions(trx1);
			throw new InsufficientBalanceException();
		} else {
			account.setAccountBalance(balance - amount);
			trx1.setTransactionStatus(TransactionStatus.SUCCESS);
			transactionDao.saveNewTransactions(trx1);
			accountDao.updateAccount(account);			
		}			
		
		
	}

	@Override
	public void createAccount(Account account) {
		accountDao.saveNewAccount(account);
		
	}

	@Override
	public Account getAccountByAccountNo(Long accountNo) {
		
		return accountDao.findById(accountNo);

	}

	@Override
	public void update(Account account) {
		accountDao.updateAccount(account);
		
	}

}
