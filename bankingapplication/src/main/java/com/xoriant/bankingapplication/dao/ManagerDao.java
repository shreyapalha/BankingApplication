package com.xoriant.bankingapplication.dao;

import java.util.List;

import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;

/**
 * @author Palha_s
 *
 */
public interface ManagerDao {
	/**
	 * @param userId
	 * @return
	 */
	public Manager findByUserId(Integer userId);

	/**
	 * @param userId
	 * @return
	 */
	public Manager findById(Integer userId);

	/**
	 * @param customerId
	 * @return
	 */
	public Manager findByCustomer(Customer customerId);

	/**
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	public List<Manager> findByProperty(String propertyName, Object propertyValue);

}
