package com.xoriant.bankingapplication.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xoriant.bankingapplication.command.AccountCommand;
import com.xoriant.bankingapplication.command.CustomerCommand;
import com.xoriant.bankingapplication.command.ChangePasswordCommand;
import com.xoriant.bankingapplication.command.DeleteCustomerCommand;
import com.xoriant.bankingapplication.command.DepositCommand;
import com.xoriant.bankingapplication.command.EditCustomerCommand;
import com.xoriant.bankingapplication.command.LoginCommand;
import com.xoriant.bankingapplication.exception.InsufficientBalanceException;
import com.xoriant.bankingapplication.exception.UserNotFoundException;
import com.xoriant.bankingapplication.model.Account;
import com.xoriant.bankingapplication.model.AccountType;
import com.xoriant.bankingapplication.model.Address;
import com.xoriant.bankingapplication.model.Branch;
import com.xoriant.bankingapplication.model.Customer;
import com.xoriant.bankingapplication.model.Gender;
import com.xoriant.bankingapplication.model.Manager;
import com.xoriant.bankingapplication.model.Status;
import com.xoriant.bankingapplication.model.User;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.service.BranchService;
import com.xoriant.bankingapplication.service.CustomerService;
import com.xoriant.bankingapplication.service.ManagerService;
import com.xoriant.bankingapplication.service.UserService;

@Controller
public class ManagerController {
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * This method is called for get mapping of login request
	 * @return
	 */
	@RequestMapping(value = {"/","/loginManager"}, method = RequestMethod.GET)
	public String loginManager() {

		return "login";
	}
	
	/**
	 * This method takes the managerdashboard mapping and map it to managerdashboard page
	 * @return
	 */
	@RequestMapping("user/managerdashboard")
	public String managerDashboard() {
		return "dashboard_m";
	}
	
	/**
	 * This method is called for post mapping of login request
	 * @param cmd
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginManager", method = RequestMethod.POST)
	public String handleManagerLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		try {
			User loggedInUser = userService.authUser(cmd.getUserName(), cmd.getPassword());
			if (loggedInUser == null) {
				m.addAttribute("err", "Login Failed! Enter valid credentials.");
				return "loginFailure";
			} else {
				addDetailsInSession(userService.getDetailsforManager(loggedInUser),session);
				addUserInSession(loggedInUser, session);
				return "redirect:user/managerdashboard";
			}
		} catch (Exception ex) {
			m.addAttribute("err", ex.getMessage());
			System.out.println(ex);
			return "index";
		}
	}
	
	/**
	 * add user detail in current session
	 * @param userDetails
	 * @param session
	 */
	private void addDetailsInSession(Map<Object,Object> userDetails,HttpSession session) {
		session.setAttribute("personId", userDetails.get("personId"));
		session.setAttribute("name", userDetails.get("name"));
		session.setAttribute("gender", userDetails.get("gender").toString());
		session.setAttribute("branch", userDetails.get("branch"));
		session.setAttribute("IFSC", userDetails.get("IFSC"));
		session.setAttribute("city",userDetails.get("city"));
		session.setAttribute("flatNo",userDetails.get("flatNo"));
		session.setAttribute("pin",userDetails.get("pin"));
		session.setAttribute("state",userDetails.get("state"));
	}
	
	/**
	 *  this function writes to httpSession of current authenticated user
	 * @param user
	 * @param session
	 */
	private void addUserInSession(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		
	}
	
	
	/**
	 * @param m
	 * @return
	 */
	@GetMapping("user/newCustomer")
	public String newCustomer(Model m)
	{	
		m.addAttribute("customer", new CustomerCommand());
		return "newCustomer";
	}
	
	/**
	 * @param acd
	 * @return
	 */
	@PostMapping("user/newCustomerSubmit")
	public String newCustomerSubmit(@ModelAttribute("customer") CustomerCommand acd)
	{
		Customer customer=new Customer();
		customer.setPersonName(acd.getPersonName());
		customer.setGender(acd.getGender());
		customer.setStatus(acd.getCustomerStatus());
		
		int branchId=acd.getBranchId();
		Branch branch=branchService.getBranchByID(branchId);
		
		Address address=new Address();
		address.setFlatNo(acd.getFlatNo());
		address.setCity(acd.getCity());
		address.setState(acd.getState());
		address.setPincode(acd.getPincode());
		
		User user=new User();
		user.setUserName(acd.getUsername());
		user.setPassword(acd.getPassword());
		
		Manager manager=managerService.managerFindById(1);
		
		customer.setManager(manager);
		customer.setAddress(address);
		customer.setBranch(branch);
		customer.setUser(user);
		
		managerService.addCustomer(customer,branch,user,address,manager);
		return "dashboard_m";
	}
	
	
	/**
	 * @param m
	 * @return
	 */
	@GetMapping("user/newAccount")
	public String newAccount(Model m)
	{
		m.addAttribute("account",new AccountCommand());
		return "newAccount";
	}
	
	/**
	 * @param aac
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@PostMapping("user/newAccountSubmit")
	public String newAccountSubmit(@ModelAttribute("account") AccountCommand aac)
	{
		Customer customer=customerService.getCustomerByPersonId(aac.getPersonId());
		Account account1=new Account();
		
		account1.setAccountBalance(aac.getBalance());
		account1.setAccountStatus(aac.getStatus());
		account1.setAccountType(aac.getAccountType());
		account1.setDate(new Date(2021, 12, 2));
		account1.setDateOfClosure(new Date(2043, 2, 6));
		account1.setDescription("desc");
		account1.setMinimumBalance(aac.getMinBalance());
		account1.setCustomer(customer);
		accountService.createAccount(account1);
		
		return "dashboard_m";
	}
	
	/**
	 * @param m
	 * @return
	 */
	@GetMapping("user/editAccount")
	public String editAccount(Model m)
	{
		m.addAttribute("editAccount",new AccountCommand());
		return "editAccount";
	}
	
	/**
	 * @param aac
	 * @return
	 */
	@PostMapping("user/editAccountSubmit")
	public String editAccountSubmit(@ModelAttribute("editaccount") AccountCommand aac)
	{
		Account account=accountService.getAccountByAccountNo(aac.getAccountNo());
		if(aac.getBalance()!=0.0)
		   account.setAccountBalance(aac.getBalance());
		if(aac.getAccountType()==null)
			account.setAccountType(aac.getAccountType());
		if(aac.getMinBalance()!=0.0)
			account.setMinimumBalance(aac.getMinBalance());
		if(aac.getStatus()==null)
			account.setAccountStatus(aac.getStatus());
		
		accountService.update(account);
		
		return "dashboard_m";
	}
	
	/**
	 * @param m
	 * @return
	 */
	@GetMapping("user/deleteAccount")
	public String deleteAccount(Model m)
	{
		m.addAttribute("account",new DepositCommand());
		return "deleteAccount";
	}
	 
	/**
	 * @param dc
	 * @return
	 */
	@PostMapping("user/deleteAccountDetail")
	public String deleteAccountDetail(@ModelAttribute("account") DepositCommand dc)
	{
		Account account=accountService.getAccountByAccountNo(dc.getToAccount());
		account.setAccountStatus(Status.INACTIVE);
		accountService.update(account);
		return "dashboard_m";
		
	}
	
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping("user/logoutManager")
	public String logoutManager(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	//new
	
	
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/editCustomer", method = RequestMethod.GET)
	public String editCustomerHandler(Model m) {
		m.addAttribute("editCustomerCommand", new EditCustomerCommand());
		return "editCustomer";
	}

	/**
	 * @param cmd
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "user/successCustomer", method = RequestMethod.POST)
	public String editCustomerHandler(@ModelAttribute("editCustomer") EditCustomerCommand cmd, Model m,
			HttpSession session) {
		try {
			Address address = managerService.adderssFindById(cmd.getAddressId());
			if (address == null) {
				throw new UserNotFoundException("address NOT FOUND");
			}
			address.setCity(cmd.getCity());
			address.setFlatNo(cmd.getFlatNo());
			address.setPincode(cmd.getPincode());
			address.setState(cmd.getState());

			Branch branch = managerService.branchFindById(cmd.getBranchId());
			if (branch == null) {
				throw new UserNotFoundException("Branch NOT FOUND");
			}
			branch.setBranchName(cmd.getBranchName());
			branch.setIFSC(cmd.getIFSC());

			Customer customer = managerService.customerFindById(cmd.getPersonId());
			if (customer == null) {
				throw new UserNotFoundException("CUSTOMER NOT FOUND");
			}

			if (cmd.getCustomerStatus().equals("ACTIVE"))
				customer.setStatus(Status.ACTIVE);
			else
				customer.setStatus(Status.INACTIVE);

//			PersonalInfo personalInfo = customerService.personalInfoFindById(customer.getPersonId());
//			if (personalInfo == null) {
//				throw new NotFoundException("personalInfo ID NOT FOUND");
//			}

			if (cmd.getGender().equals("MALE"))
				customer.setGender(Gender.MALE);
			else
				customer.setGender(Gender.FEMALE);

			customer.setPersonName(cmd.getPersonName());

			Account account = managerService.accountFindById(cmd.getAccountNumber());
			if (account == null) {
				throw new UserNotFoundException("account ID NOT FOUND");
			}
			if (cmd.getAccountType().equals("CURRENT"))
				account.setAccountType(AccountType.CURRENT);
			else
				account.setAccountType(AccountType.SAVING);

			managerService.updateCustomer(customer, account, branch, address);

			return "redirect:managerdashboard";
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "editCustomer";
	}
	
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomerHandler(Model m) {
		m.addAttribute("deleteCustomerCommand", new DeleteCustomerCommand());
		return "deleteCustomer";
	}

	/**
	 * @param cmd
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/successDeleteCustomer", method = RequestMethod.POST)
	public String deleteCustomerHandler(@ModelAttribute("deleteCustomerCommand") DeleteCustomerCommand cmd, Model m)  {

		Customer customer = managerService.customerFindById(cmd.getPersonId());
		System.out.println(">>>>>>" + customer);
		try {
			managerService.deleteCustomer(customer);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}

		return "dashboard_m";

	}
	
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/changePassword", method = RequestMethod.GET)
	public String changePassword(Model m) {
		m.addAttribute("changePasswordCommand", new ChangePasswordCommand());
		return "changePassword";
	}

	/**
	 * @param cmd
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "user/successPassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePasswordCommand") ChangePasswordCommand cmd, Model m,
			HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			managerService.changePassword(cmd.getOldPassword(), cmd.getNewPassword(), cmd.getConfirmPassword(),
					user.getUserId());
			return "redirect:managerdashboard";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "changePassword";
		}
	}
	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("user/deposit")
	public String deposit(Model m)
	{
		m.addAttribute("depositCommand",new DepositCommand());
		
		return "deposit";
	}
	
	/**
	 * @param dmd
	 * @return
	 */
	@RequestMapping("user/successDeposit")
	public String successDeposit(@ModelAttribute("depositCommand") DepositCommand dmd)
	{
		boolean res=accountService.authAccount(dmd.getToAccount());
		if(res)
		{
			accountService.depositAmount(dmd.getToAccount(),  dmd.getAmount());
			return "successDeposit";
		}
		else
			return "failure";	
	}
	


	
	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("user/withdrawal")
	public String withdrawAmount(Model m)
	{
		m.addAttribute("withdrawCommand", new DepositCommand());
		return "withdraw";
	}
	
	/**
	 * @param wmd
	 * @param m
	 * @return
	 * @throws InsufficientBalanceException
	 */
	@RequestMapping("user/successWithdrawal")
	public String successWithdrawal(@ModelAttribute("withdrawCommand") DepositCommand wmd,Model m) throws InsufficientBalanceException
	{
		boolean res=accountService.authAccount(wmd.getToAccount());
		if(res)
		{
			try {
				accountService.withdrawAmount(wmd.getToAccount(),wmd.getAmount());
				return "successWithdrawal";
			}
			catch(InsufficientBalanceException e)
			{
				m.addAttribute("err", e.getMessage());
				return "fail";
			}
		}else
			return "failure";
	}
	

}
