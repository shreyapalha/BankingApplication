package com.xoriant.bankingapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.Customer;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {
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
	public void saveNewCustomer(Customer customer) {
		hibernateTemplate.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);

	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		hibernateTemplate.delete(customer);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		String sql = "from Transactions u where u.fromAccount=?0";
		Customer customer = (Customer) hibernateTemplate.find(sql, customerId).get(0);
		hibernateTemplate.delete(customer);

	}

	@Override
	public Customer findById(Integer customerId) {
		Customer customer = hibernateTemplate.get(Customer.class, customerId);
		return customer;
	}


	@SuppressWarnings("deprecation")
	@Override
	public Customer getCustomerByPersonId(int id) {
		String sql = "from PersonalInfo p where p.personId=?0";
		Customer customer = (Customer) hibernateTemplate.find(sql, id).get(0);
		return customer;

	}

}
