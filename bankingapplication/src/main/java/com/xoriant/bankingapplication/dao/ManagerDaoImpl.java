package com.xoriant.bankingapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;

@Component("managerDao")
public class ManagerDaoImpl implements ManagerDao {

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
	public Manager findByUserId(Integer userId) {
		Manager manager = hibernateTemplate.get(Manager.class, userId);
		return manager;
	}

	@Override
	public Manager findByCustomer(Customer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> findByProperty(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public Manager findById(Integer userId) {
		String sql = "from PersonalInfo p where p.personId=?0";
		Manager manager = (Manager) hibernateTemplate.find(sql, userId).get(0);
		return manager;
	}

}
