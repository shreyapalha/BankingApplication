package com.xoriant.bankingapplication.test;

import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Gender;

public class CustomerSaveDao {
	public static void main(String[] args) {
		
		/*
		 * User user1 =new User(); user1.setUserName("him123");
		 * user1.setPassword("123");
		 * 
		 * User user2 = new User(); user2.setUserId(2); user2.setPassword("22");
		 * user2.setUserName("isha231");
		 * 
		 * 
		 * Transactions trx1 = new Transactions(); trx1.setAmount(23);
		 * trx1.setDateOfTransaction(new Date()); trx1.setTransactionId(1);
		 * trx1.setFromAccount(null); trx1.setToAccount(null);
		 * 
		 * 
		 * 
		 * List<Transactions> transaction = new ArrayList<Transactions>();
		 * transaction.add(trx1);
		 * 
		 * Account account1 = new Account(); account1.setAccountBalance(9001.23);
		 * account1.setAccountNumber(3999100009l);
		 * account1.setAccountStatus(AccountStatus.ACTIVE);
		 * account1.setAccountType(AccountType.CURRENT); account1.setDate(new
		 * Date(2021,12,2)); account1.setDateOfClosure(new Date(2032,12,31));
		 * account1.setDescription("description"); account1.setMinimumBalance(3500);
		 * 
		 * account1.setTransaction(transaction);
		 * 
		 * trx1.setFromAccount(account1);
		 * 
		 * Address address1 = new Address(); address1.setAddressId(1);
		 * address1.setCity("kota"); address1.setFlatNo(02); address1.setPincode(34445);
		 * address1.setState("raj");
		 * 
		 * 
		 * Branch branch1= new Branch(); branch1.setBranchId(1);
		 * branch1.setBranchName("bob branch"); branch1.setIFSC("bob0000323");
		 * 
		 * List<Account> accountsOfCustomer = new ArrayList<Account>();
		 * accountsOfCustomer.add(account1);
		 * 
		 * Manager manager1 = new Manager(); manager1.setAdress(address1);
		 * manager1.setBranch(branch1); manager1.setCustomer(null);
		 * manager1.setGender(Gender.FEMALE); manager1.setUser(user1);
		 * manager1.setPersonId(3); manager1.setPersonName("jisper");
		 * 
		 */

		
		Customer customer = new Customer();
		customer.setAccount(null);
		customer.setAdress(null);
		customer.setBranch(null);
		customer.setGender(Gender.MALE);
		customer.setManager(null);
		customer.setPersonId(2);
		customer.setPersonName("lilaBai");
		customer.setUser(null);
		
		//customerDaoImpl.saveNewCustomer(customer);
		
		System.out.println("Customer is saved successfully");
	}
	
}
