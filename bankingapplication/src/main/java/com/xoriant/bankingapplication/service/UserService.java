package com.xoriant.bankingapplication.service;

import java.util.List;
import java.util.Map;

import com.xoriant.bankingapplication.model.User;
/**
 * @author Palha_s
 *
 */
public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN =1;
	public static final Integer ROLE_USER=2;
	public void register(User user);
	public List<User> login(String loginName,String password);
	
	public List<User> getUserList();
	
	/**
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId,Integer loginStatus);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public User authUser(String userName,String password);
	
	/**
	 * @param loggedInUser
	 * @return
	 */
	public Map<Object, Object> getDetails(User loggedInUser);
	
	/**
	 * @param loggedInUser
	 * @return
	 */
	public Map<Object, Object> getDetailsforManager(User loggedInUser);

	/**
	 * @param personId
	 * @return
	 */
	String getRolebyId(Integer personId);

}