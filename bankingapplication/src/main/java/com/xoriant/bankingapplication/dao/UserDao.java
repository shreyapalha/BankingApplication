package com.xoriant.bankingapplication.dao;

import com.xoriant.bankingapplication.model.User;

public interface UserDao {
	/**
	 * @param user
	 */
	public void saveNewUser(User user);

	/**
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * @param user
	 */
	public void deleteUser(User user);

	/**
	 * @param userId
	 */
	public void deleteUser(Integer userId);
	
	/**
	 * @param userId
	 * @return
	 */
	public User findById(Integer userId);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public User authenticateUser(String userName,String password);

	/**
	 * @param personId
	 * @return
	 */
	public String getRoleById(Integer personId);
}
