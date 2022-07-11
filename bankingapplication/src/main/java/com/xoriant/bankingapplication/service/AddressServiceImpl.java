package com.xoriant.bankingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.AddressDao;
import com.xoriant.bankingapplication.model.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public void save(Address address) {
	    addressDao.saveNewAddress(address);
	}

}
