package com.xoriant.bankingapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Customer;

@Component("accountDao")
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	CustomerDao customerDao;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernate() {
		return hibernateTemplate;
	}

	public void setHibernate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	@Transactional
	public void saveNewAccount(Account account) {
		hibernateTemplate.saveOrUpdate(account);
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		hibernateTemplate.update(account);
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	@Transactional
	public List<Account> findByCustomerId(Integer customerId) throws UserNotFoundException {
		Customer customer = customerDao.getCustomerByPersonId(customerId);
		System.out.println(customer);
		if (customer != null) {
			String sql = "from Account a where a.customer=?0";
			List<Account> accounts = (List<Account>) hibernateTemplate.find(sql, customer);
			return accounts;

		} else {
			throw new UserNotFoundException();
		}
	}
		
	
	@Override
	@Transactional
	public void withdrawBalance(long accountNumber,long amount) {
		Account account=hibernateTemplate.get(Account.class, accountNumber);
		account.setAccountBalance(account.getAccountBalance()-amount);
		hibernateTemplate.update(account);
		System.out.println("Amount withdraw");
		
	}

	@Override
	@Transactional
	public void depositBalance(long accountNumber, double amount) {
		Account account=hibernateTemplate.get(Account.class, accountNumber);
		account.setAccountBalance(account.getAccountBalance()+amount);
		hibernateTemplate.update(account);
		System.out.println("Amount Deposited");
		
	}

	@Override
	@Transactional
	public Account findById(long accountNumber) {
		Account account=hibernateTemplate.get(Account.class, accountNumber);
		return account;
	}

	@Override
	@Transactional
	public double getBalance(long toAccount) {
		Account account=hibernateTemplate.get(Account.class, toAccount);
		double balance=account.getAccountBalance();
		return balance;
	}

}
