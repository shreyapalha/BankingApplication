package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;



/**
 * @author Palha_s
 *
 */
public interface AccountDao {

	/**
	 * It saves new Account 
	 * @param account
	 */
	void saveNewAccount(Account account);

	/**
	 * it updates account
	 * @param account
	 */
	void updateAccount(Account account);

	/**
	 * it search for account using customerid
	 * @param customerId
	 * @return
	 * @throws UserNotFoundException
	 */
	List<Account> findByCustomerId(Integer customerId) throws UserNotFoundException;

	/**
	 * it withdraw amount from account table
	 * @param accountNumber
	 * @param amount
	 */
	void withdrawBalance(long accountNumber, long amount);

	/**
	 * it deposit amount from account table
	 * @param accountNumber
	 * @param amount
	 */
	void depositBalance(long accountNumber, double amount);

	/**
	 * it finds account using account number
	 * @param accountNumber
	 * @return
	 */
	Account findById(long accountNumber);

	/**
	 * it fetch the balance from account 
	 * @param toAccount
	 * @return
	 */
	double getBalance(long toAccount);

	
	
	
	

}
