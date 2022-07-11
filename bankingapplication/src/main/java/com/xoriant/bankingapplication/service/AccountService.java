package com.xoriant.bankingapplication.service;

import com.xoriant.bankingapplication.exception.InsufficientBalanceException;
import com.xoriant.bankingapplication.model.Account;

/**
 * @author Palha_s
 *
 */
public interface AccountService {
	
	/**
	 * it authenticate account using account number
	 * @param accountNumber
	 * @return
	 */
	boolean authAccount(long accountNumber);
	/**
	 * to deposit amount it is used
	 * @param accountNumber
	 * @param amount
	 */
	void depositAmount(long accountNumber,double amount);
	/**
	 * to get balance by id it is used
	 * @param toAccount
	 * @return
	 */
	double getBalanceByAccountNo(long toAccount);
	/**
	 * to withdraw amount it is used
	 * @param toAccount
	 * @param amount
	 * @throws InsufficientBalanceException
	 */
	void withdrawAmount(long toAccount, double amount) throws InsufficientBalanceException;
	/**
	 * to create account
	 * @param account
	 */
	void createAccount(Account account);
	/**
	 * to get account from account no
	 * @param accountNo
	 * @return
	 */
	Account getAccountByAccountNo(Long accountNo);
	/**
	 * to gte account using account object
	 * @param account
	 */
	void update(Account account);

}
