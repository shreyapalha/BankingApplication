package com.xoriant.bankingapplication.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerServiceAddCustomer {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com/xoriant/bankingapplication/test/config.xml");
//		ManagerService managerService=(ManagerService) context.getBean("managerService");
//		BranchService branchService=(BranchService) context.getBean("branchService");
//		AddressService addressService=(AddressService)context.getBean("addressService");
//		UserService userService=(UserService)context.getBean("userService");
		
//		Customer customer=new Customer();
//		
//		customer.setPersonName("mani shroti");
//		customer.setGender(Gender.FEMALE);
//		customer.setStatus(Status.ACTIVE);
		
//		Branch branch=branchService.getBranchByID(3);
//		System.out.println(branch);
		
//		Address address=new Address();
//		address.setFlatNo(77);
//		address.setCity("balaghat");
//		address.setState("Karnataka");
//		address.setPincode(455467);
//
//		User user=new User();
//		user.setUserName("manu");
//		user.setPassword("123");
//		
//		customer.setBranch(branch);
//		customer.setAddress(address);
//		customer.setUser(user);
//		
//	
//		userService.register(user);
//		addressService.save(address);
//		managerService.addCustomer(customer);
	}

}
