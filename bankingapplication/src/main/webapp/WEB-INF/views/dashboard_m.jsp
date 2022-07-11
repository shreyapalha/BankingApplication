<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.xoriant.bankingapplication.model.User"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Dashboard</title>

<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/styleUser.css">
</head>
<body>
<div class="nav-container">
        <div class="btn-div-nav"><button class="btn-1" onclick="location.href='logoutManager';"  type="button">Logout</button></div> 

         <div class="nav-heading">
               <h2>Welcome To The Bank</h2>
         </div>
         
         <div class="nav-info">
              <div>
					<% String name = (String)session.getAttribute("name");%>
					<% out.println(name);%>(Manager)
				</div>
				
				<div>
					<% String branch = (String)session.getAttribute("branch");%>
					<% out.println(branch);%>
				</div>
         </div>
</div>
<hr>
<div class="container-body">
   <div>
       <h2>My Dashboard</h2>
   </div>
   <div class="btn-body">
	   <div class="btn-manager">
	      <div class="btn-div "><button class="btn-1" onclick="location.href='newCustomer';"  type="button">New Customer</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='editCustomer';"  type="button">Edit Customer</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='deleteCustomer';"  type="button">Delete Customer</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='newAccount';"  type="button">New Account</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='editAccount';"  type="button">Edit Account</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='deleteAccount';"  type="button">Delete Account</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='deposit';"  type="button">Deposit</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='withdrawal';"  type="button">Withdraw Amount</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='fundTransfer';"  type="button">Fund Transfer</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='changePassword';"  type="button">Change Password</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='balanceEnquiry';"  type="button">Balance Enquiry</button></div>
	      <div class="btn-div"><button class="btn-1" onclick="location.href='miniStatement';"  type="button">Mini Statement</button></div>
	     
	      </div>
	   </div>
</div>

</body>
</html>