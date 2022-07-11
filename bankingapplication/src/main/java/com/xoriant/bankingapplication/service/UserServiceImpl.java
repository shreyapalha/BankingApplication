
package com.xoriant.bankingapplication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.bankingapplication.dao.CustomerDao;
import com.xoriant.bankingapplication.dao.ManagerDao;
import com.xoriant.bankingapplication.dao.UserDao;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Branch;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.User;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ManagerDao managerDao;

	UserDao getUserDao() {
		return userDao;
	}

	void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> login(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * Authenticate the user by userName and password,
	 * returns User obj if correct credentials provided
	 * else null
	 */

	@Override
	public User authUser(String userName, String password) {
		User user= userDao.authenticateUser(userName, password);
		return user;
	}

	@Override
	public void register(User user) {
		userDao.saveNewUser(user);
	}

	@Override
	public Map<Object, Object> getDetails(User user) {
		//Integer userId=  user.getUserId();
		Map<Object,Object> userDetails = new HashMap<Object, Object>();
		Customer personalInfo = customerDao.findById(user.getUserId());
		userDetails.put("personId", personalInfo.getPersonId());
		userDetails.put("name", personalInfo.getPersonName());
		userDetails.put("gender", personalInfo.getGender());
		
		Branch branch = personalInfo.getBranch();
		userDetails.put("branch", branch.getBranchName());
		userDetails.put("IFSC", branch.getIFSC());
		
		Address address = personalInfo.getAddress();
		userDetails.put("city",address.getCity());
		userDetails.put("flatNo",address.getFlatNo());
		userDetails.put("pin",address.getPincode());
		userDetails.put("state",address.getState());
		
//		branch=Branch [branchId=1, branchName=ABCD branch, IFSC=ABC0000323]
//		address=Address [addressId=1, flatNo=32, city=Ujjain, state=MH, pincode=414113]
		return userDetails;
	}

	@Override
	public Map<Object, Object> getDetailsforManager(User user) {
		Map<Object,Object> userDetails = new HashMap<Object, Object>();
		Manager personalInfo = managerDao.findByUserId(user.getUserId());
		System.out.println(personalInfo);
		userDetails.put("personId", personalInfo.getPersonId());
		userDetails.put("name", personalInfo.getPersonName());
		userDetails.put("gender", personalInfo.getGender());
		
		Branch branch = personalInfo.getBranch();
		userDetails.put("branch", branch.getBranchName());
		userDetails.put("IFSC", branch.getIFSC());
		
		Address address = personalInfo.getAddress();
		userDetails.put("city",address.getCity());
		userDetails.put("flatNo",address.getFlatNo());
		userDetails.put("pin",address.getPincode());
		userDetails.put("state",address.getState());
		
		System.out.println(userDetails);
		return userDetails;
	}
	
	@Override
	public String getRolebyId(Integer personId) {
		return userDao.getRoleById(personId);
		
	}

}