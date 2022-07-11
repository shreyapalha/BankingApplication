package com.xoriant.bankingapplication.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.bankingapplication.dao.CustomerDao;

public class CustomerDeleteDao {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/xoriant/bankingapplication/test/config.xml");
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * User user1 =new User(); user1.setUserId(1); user1.setUserName("usetosif");
		 * user1.setPassword("1");
		 * 
		 * User user2 = new User(); user2.setUserId(2); user2.setPassword("22");
		 * user2.setUserName("user2_iam");
		 * 
		 * User user3 = new User(); user3.setUserId(3);
		 * user3.setUserName("non_costumer_user"); user3.setPassword("sdasda");
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
		 * Account account1 = new Account(); account1.setAccountBalance(99901.23);
		 * account1.setAccountNumber(1l);
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
		 * address1.setCity("Ujjain"); address1.setFlatNo(32);
		 * address1.setPincode(414113); address1.setState("MH");
		 * 
		 * 
		 * Branch branch1= new Branch(); branch1.setBranchId(1);
		 * branch1.setBranchName("ABCD branch"); branch1.setIFSC("ABC0000323");
		 * 
		 * List<Account> accountsOfCustomer = new ArrayList<Account>();
		 * accountsOfCustomer.add(account1);
		 * 
		 * Manager manager1 = new Manager(); manager1.setAdress(address1);
		 * manager1.setBranch(branch1); manager1.setCustomer(null);
		 * manager1.setGender(Gender.FEMALE); manager1.setUser(user1);
		 * manager1.setPersonId(3); manager1.setPersonName("mangerFemale");
		 */
		CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
		/*
		 * Customer customer = new Customer(); customer.setAccount(accountsOfCustomer);
		 * customer.setAdress(address1); customer.setBranch(branch1);
		 * customer.setGender(Gender.MALE); customer.setManager(manager1);
		 * customer.setPersonId(2); customer.setPersonName("titan");
		 * customer.setUser(user2)
		 */;
		customerDao.deleteCustomer(1);
		System.out.println( " deleted");
	}
}