package com.xoriant.bankingapplication.dao;

import com.xoriant.bankingapplication.model.Address;

/**
 * @author Palha_s
 *
 */
public interface AddressDao {
	/**
	 * It saves new address
	 * @param address
	 */
	public void saveNewAddress(Address address);

	/**
	 * it updates the current address
	 * @param address
	 */
	public void updateAddress(Address address);

	/**
	 * it deletes the address using address object
	 * @param address
	 */
	public void deleteAddress(Address address);

	/**
	 * it deletes the address using address id
	 * @param addressId
	 */
	public void deleteAddress(Integer addressId);
	
	/**
	 * it search for address using address id
	 * @param addressId
	 * @return
	 */
	public Address findById(Integer addressId);
	
}
