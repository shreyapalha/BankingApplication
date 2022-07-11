<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>
<div class="container">
<f:form action="newAccountSubmit" modelAttribute="account">
     <div class="heading"><h2>Add New Account Detail</h2></div>
     <div class="table">
	     <table>
	           <tr>
	              <td>Customer Id</td>
	              <td><f:input path="personId" /></td>
	           </tr>
	           <tr>
	              <td>Balance</td>
	              <td><f:input path="balance" /></td>
	           </tr>
	           <tr>
	              <td>Status</td>
	              <td><f:input path="status" /></td>
	           </tr>
	           <tr>
	              <td>Account Type</td>
	              <td><f:input path="accountType" /></td>
	           </tr>
	           <tr>
	              <td>Minimum Balance</td>
	              <td><f:input path="minBalance" /></td>
	           </tr>
	           <tr>
	             <td><button onclick="myFunction()">Add Account</button></td>
	           </tr>
	           
	     </table>
     </div>
</f:form>
</div>
   
 <script>
	function myFunction() {
	  alert("Account has been successfully created")
	}
</script>

</body>
</html>