package com.xoriant.bankingapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.model.PersonalInfo;
import com.xoriant.bankingapplication.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

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
	public void saveNewUser(User user) {

		hibernateTemplate.save(user);

		System.out.println("user has been saved");

	}

	@Override
	@Transactional
	public void updateUser(User user) {

		hibernateTemplate.update(user);
		System.out.println("user has been udate");
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		hibernateTemplate.delete(user);
		System.out.println("user has been deleted");
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		User user = hibernateTemplate.get(User.class, userId);
		hibernateTemplate.delete(user);

		System.out.println("user has been deleted");
	}

	@Override
	@Transactional
	public User findById(Integer userId) {
		User user = hibernateTemplate.get(User.class, userId);
		return user;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	/*
	 * authenticating the user
	 */
	public User authenticateUser(String userName, String password) {
		String sqlQuery = "from User u where u.userName=?0 and u.password=?1";
		User validUser;
		try {

			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, userName, password);
			validUser = null;
			if (userObj != null && userObj.size() > 0) {
				validUser = (User) userObj.get(0);
			}
		} catch (Exception e) {
			validUser = null;
		}
		return validUser;

	}
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public String getRoleById(Integer personId) {
		String sql = "from PersonalInfo p where p.personId=?0";
		PersonalInfo personalInfo = (PersonalInfo) hibernateTemplate.find(sql, personId).get(0);
		return personalInfo.getRole();
	}

}
