package com.xoriant.bankingapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.Address;

@Component("addressDao")
public class AddressDaoImpl implements AddressDao {

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
	public void saveNewAddress(Address address) {
		hibernateTemplate.save(address);
		System.out.println("address has been saved");
	}

	@Override
	@Transactional
	public void updateAddress(Address address) {
		hibernateTemplate.update(address);
		System.out.println("address has been udated");
	}

	
	@Override
	@Transactional
	public void deleteAddress(Address address) {
		hibernateTemplate.delete(address);
		System.out.println("address has been deleted");
	}

	@Override
	@Transactional
	public void deleteAddress(Integer addressId) {
		Address address = hibernateTemplate.get(Address.class, addressId);
		hibernateTemplate.delete(address);
		System.out.println("address has been deleted");
	}

	@Override
	@Transactional
	public Address findById(Integer addressId) {
		Address address = hibernateTemplate.get(Address.class, addressId);
		return address;
	}

}
