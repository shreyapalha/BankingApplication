package com.xoriant.bankingapplication.service;

import java.sql.Date;
import java.util.List;

import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Transactions;

/**
 * @author Palha_s
 *
 */
public interface CustomerService {
	/**
	 * @param accountNumber
	 */
	public void balanceEnquiry(int accountNumber); 
	/**
	 * @param l
	 * @param m
	 * @param amount
	 */
	public void fundTransfer(long l ,long m , double amount); 
	/**
	 * @param l
	 * @return
	 */
	public List<Transactions> miniStatement(long l); 
	/**
	 * @param accountNumber
	 * @param toDate
	 * @param fromDate
	 */
	public void customizedStatement(int accountNumber,Date toDate,Date fromDate);
	/**
	 * @param Id
	 * @return
	 * @throws UserNotFoundException
	 */
	public List<Account> getAccount(int Id) throws UserNotFoundException;
	/**
	 * @param id
	 * @return
	 */
	public Customer getCustomerByPersonId(int id);
	/**
	 * @param accountNo
	 * @param fromDate
	 * @param toDate
	 * @param amountLowerLimit
	 * @param numberOfTransaction
	 * @return
	 */
	public List<Transactions> customizedStatement(long accountNo, Date fromDate, Date toDate, double amountLowerLimit,
			int numberOfTransaction);
	
}
