package com.xoriant.bankingapplication.service;

import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Branch;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.User;

/**
 * @author Palha_s
 *
 */
public interface ManagerService {
	
	/**
	 * @param accountNumber
	 * @param amount
	 */
	public void deposit(long accountNumber , double amount); 
	/**
	 * @param accountNumber
	 * @param amount
	 */
	public void withdrawal(long accountNumber , double amount); 
	/**
	 * @param toAccountNumber
	 * @param fromAccountNumber
	 * @param amount
	 */
	public void fundTransfer(long toAccountNumber ,long fromAccountNumber , double amount); 
	/**
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @param userId
	 */
	public void changePassword(String oldPassword ,String newPassword,String confirmPassword,int userId); 
	/**
	 * @param accountNumber
	 * @return
	 */
	public double balanceEnquiry(long accountNumber); 
	/**
	 * @param accountNumber
	 */
	public void miniStatement(long accountNumber); 
	/**
	 * @param accountNumber
	 * @param filter
	 * @param value
	 */
	public void customizedStatement(long accountNumber,String filter ,Object value  ); 
	/**
	 * @param customer
	 */
	public void register(Customer customer);
	/**
	 * @param username
	 * @param password
	 */
	public void authManager(String username, String password);
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	User authUser(String userName, String password);
	/**
	 * 
	 */
	void login();
	
	/**
	 * @param customer
	 * @param branch
	 * @param user
	 * @param address
	 * @param manager
	 */
	void addCustomer(Customer customer, Branch branch, User user, Address address, Manager manager);
	/**
	 * @param personId
	 * @return
	 */
	public Manager managerFindById(Integer personId);

	/**
	 * @param addressId
	 * @return
	 */
	Address adderssFindById(Integer addressId);
	/**
	 * @param branchId
	 * @return
	 */
	public Branch branchFindById(int branchId);
	/**
	 * @param personId
	 * @return
	 */
	public Customer customerFindById(int personId);
	/**
	 * @param accountNumber
	 * @return
	 */
	public Account accountFindById(long accountNumber);
	/**
	 * @param customer
	 * @param account
	 * @param branch
	 * @param address
	 */
	public void updateCustomer(Customer customer, Account account, Branch branch, Address address);
	/**
	 * @param customer
	 * @throws UserNotFoundException
	 */
	public void deleteCustomer(Customer customer) throws UserNotFoundException;
}