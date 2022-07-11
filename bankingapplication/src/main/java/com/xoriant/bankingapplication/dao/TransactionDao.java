package com.xoriant.bankingapplication.dao;

import java.sql.Date;
import java.util.List;

import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Transactions;

public interface TransactionDao {
	/**
	 * It saves new transactions
	 * @param transaction
	 */
	public void saveNewTransactions(Transactions transaction);

	/**
	 * it searches for transaction using it id
	 * @param transactionsId
	 * @return
	 */
	public Transactions findById(Integer transactionsId);
	
	/**
	 * it searches for transaction using account object
	 * @param account
	 * @return
	 */
	public List<Transactions> findByAccount(Account account);
	
	/**
	 * it searches for transaction using account number
	 * @param accountNumber
	 * @return
	 */
	public List<Transactions> findByAccountNumber(long accountNumber);
	
	/**
	 * it filter transactions 
	 * @param accountNumber
	 * @param filter
	 * @param value
	 * @return
	 */
	public List<Transactions> filter(int accountNumber,String filter ,Object value  );

	/**
	 * to view the statement it is used
	 * @param account
	 * @return
	 */
	public  List<Transactions> statement(Account account);

	/**
	 * to get the customised statement
	 * @param account
	 * @param fromDate
	 * @param toDate
	 * @param amountLowerLimit
	 * @param numberOfTransaction
	 * @return
	 */
	public List<Transactions> customizedStatement(Account account, Date fromDate, Date toDate, double amountLowerLimit,
			int numberOfTransaction); 
	
	
	
}
