package com.xoriant.bankingapplication.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xoriant.bankingapplication.command.CustomisedStatementCommand;
import com.xoriant.bankingapplication.command.DepositCommand;
import com.xoriant.bankingapplication.command.FundTransferCommand;
import com.xoriant.bankingapplication.command.LoginCommand;
import com.xoriant.bankingapplication.command.MiniStatementCommand;
import com.xoriant.bankingapplication.model.Transactions;
import com.xoriant.bankingapplication.model.User;
import com.xoriant.bankingapplication.service.AccountService;
import com.xoriant.bankingapplication.service.CustomerService;
import com.xoriant.bankingapplication.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
 
	
	/**
	 * This method is called for get mapping of login request
	 * @return
	 */
	@RequestMapping(value = {"/", "/loginUser"}, method = RequestMethod.GET)
	public String loginUser() {
		return "login";
	}
	
	/**
	 * This method is called for post mapping of login request
	 * @param cmd
	 * @param bs
	 * @param m
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String handleLogin(@Valid @ModelAttribute("command") LoginCommand cmd,BindingResult bs, Model m, HttpSession session) {
		System.out.println(bs.hasErrors());
		if(bs.hasErrors())
		{		
			return "login";
			
		}else
		{
			
			try {
				User loggedInUser = userService.authUser(cmd.getUserName(), cmd.getPassword());

				if (loggedInUser == null) {
					m.addAttribute("err", "Login Failed! Enter valid credentials.");
					return "loginFailure";
				} else {

					if (userService.getRolebyId(loggedInUser.getUserId()).equals("manager")) {
						addDetailsInSession(userService.getDetailsforManager(loggedInUser), session);
						addUserInSession(loggedInUser, session);
						return "redirect:user/managerdashboard";
					} else {
						addDetailsInSession(userService.getDetails(loggedInUser), session);
						addUserInSession(loggedInUser, session);
						return "redirect:user/userdashboard";
					}
				}

			} catch (

			Exception ex) {
				m.addAttribute("err", ex.getMessage());
				System.out.println(ex);
				return "loginFailure";
			}
		}
			
		
	}
	
	/**
	 * This method takes the userdashboard mapping and map it to userdashboard page
	 * @return
	 */
	@RequestMapping("user/userdashboard")
	public String userDashboard() {
		return "userdashboard";
	}
	
	/**
	 * If user does not exist or if its password is wrong then it will map to failure mapping and return failure page
	 * @return
	 */
	@RequestMapping("user/failure")
	public String userFailure() {
		return "loginFailure";
	}
	
	/**
	 * this function writes to httpSession of current authenticated user
	 * @param user
	 * @param session
	 */
	private void addUserInSession(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		
	}
	
	/**
	 * add user detail in current session
	 * @param userDetails
	 * @param session
	 */
	private void addDetailsInSession(Map<Object,Object> userDetails,HttpSession session) {
		session.setAttribute("personId", 122);
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
	 * This method map the balanceenquiry to get balance information 
	 * @param model
	 * @return
	 */
	@RequestMapping("user/balanceEnquiry")
	public String balanceEnquiry(Model model)
	{
		model.addAttribute("balanceCommand", new DepositCommand());
		return "balanceEnquiry";
	}
	
	/**
	 * This method will fetch the balance account service and return to view page
	 * @param dmd
	 * @param m
	 * @return
	 */
	@RequestMapping("user/successEnquire")
	public String enquire(@ModelAttribute("balanceCommand") DepositCommand dmd,Model m)
	{
		boolean res=accountService.authAccount(dmd.getToAccount());
		if(res)
		{
			double balance=accountService.getBalanceByAccountNo(dmd.getToAccount());
			System.out.println(balance);
			m.addAttribute("balance", balance);
			return "successEnquire";
			
		}
		return "successEnquire";
	}
	
	/**
	 * To logout we use this controller
	 * @param session
	 * @return
	 */
	@RequestMapping("user/logoutUser")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * This method returns the fundTransfer page which will fetch the account number for the fund transfer
	 * @param m
	 * @return
	 */
	@RequestMapping("user/fundTransfer")
	public String fundTransfer(Model m) {
		m.addAttribute("fundTransferCommand", new FundTransferCommand());
		return "fundTransfer";
	}

	/**
	 * This method will make the changes in database using service layer
	 * @param cmd
	 * @return
	 */
	@RequestMapping(value = "user/successTransfer", method = RequestMethod.POST)
	public String fundTransfer(@ModelAttribute("fundTransferCommand") FundTransferCommand cmd) {
		boolean toAccount = accountService.authAccount(cmd.getToAccount());
		boolean fromAccount = accountService.authAccount(cmd.getFromAccount());
		if (toAccount && fromAccount) {
			customerService.fundTransfer(cmd.getToAccount(), cmd.getFromAccount(), cmd.getAmount());
			return "successTransfer";
		} else {
			System.out.println("transfer failed");
			return "redirect:userdashboard";
		}
	}

	/**
	 * @param m
	 * @return
	 */
	@RequestMapping("user/miniStatement")
	public String miniStatement(Model m) {
		m.addAttribute("miniStatementCommand", new MiniStatementCommand());
		return "miniStatement";
	}

	/**
	 * @param cmd
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/successStatement", method = RequestMethod.POST)
	public String miniStatement(@ModelAttribute("miniStatementCommand") MiniStatementCommand cmd,Model m) {
		boolean accountNo = accountService.authAccount(cmd.getAccountNo());
		if (accountNo) {
			List<Transactions> tranc = customerService.miniStatement(cmd.getAccountNo());
			
			
			m.addAttribute("tranc",tranc);
			return "successStatement";
		} else {
			System.out.println("faild s");
			return "redirect:userdashboard";
		}
	}
	
	/**
	 * @param cmd
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "user/csuccessStatement", method = RequestMethod.POST)
	public String customisedStatement(@ModelAttribute("customisedStatementCommand") CustomisedStatementCommand cmd,
			Model m) {
		boolean accountNo = accountService.authAccount(cmd.getAccountNo());

		if (accountNo) {
			List<Transactions> tranc = customerService.customizedStatement(cmd.getAccountNo(), cmd.getFromDate(),
					cmd.getToDate(), cmd.getAmountLowerLimit(), cmd.getNumberOfTransaction());
			System.out.println(cmd.getFromDate());

			m.addAttribute("tranc", tranc);
			return "successStatement";
		} else {
			System.out.println("faild s");
			return "redirect:userdashboard";
		}
	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("user/customisedStatement")
	public String customerStatement(Model m) {
		m.addAttribute("customisedStatementCommand", new CustomisedStatementCommand());
		return "customisedStatement";
	}
	

}
