<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>
<div class="container">
     <f:form action="editAccountSubmit" modelAttribute="editAccount">
   <div class="heading"><h2>Enter Account Details</h2></div>
   <div class="table">
	     <table>
	          <tr>
	              <td>Account No</td>
	              <td><f:input path="accountNo" /></td>
	          <tr>
	          <tr>
	              <td>Balance</td>
	              <td><f:input path="balance" /></td>
	           </tr>
	           <tr>
	              <td>Status</td>
	              <td><f:input path="status"/></td>
	           </tr>
	           <tr>
	              <td>Account Type</td>
	              <td><f:input path="accountType"/></td>
	           </tr>
	           <tr>
	              <td>Minimum Balance</td>
	              <td><f:input path="minBalance"/></td>
	           </tr>
	           <tr>
	             <td><button onclick="myFunction()">Edit Account</button></td>
	           </tr>
	           
	     </table>
	  </div>
   
   </f:form>
  </div> 
    <script>
    
		function myFunction() {
		  alert("Account has been successfully updated")
		}
		
    </script>

</body>
</html>