package com.xoriant.bankingapplication.dao;

import com.xoriant.bankingapplication.model.Customer;

/**
 * @author Palha_s
 *
 */
public interface CustomerDao {
	/**
	 * it creates new customer
	 * @param customer
	 */
	public void saveNewCustomer(Customer customer);

	/**
	 * it updates customer
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * it deletes customer using customer object
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);

	/**
	 * it deletes customer using customer id
	 * @param customerId
	 */
	public void deleteCustomer(Integer customerId);

	/**
	 * it search customer using customer id
	 * @param customerId
	 * @return
	 */
	public Customer findById(Integer customerId);

	/**
	 * it searches customer using person id
	 * @param id
	 * @return
	 */
	public Customer getCustomerByPersonId(int id);
}
