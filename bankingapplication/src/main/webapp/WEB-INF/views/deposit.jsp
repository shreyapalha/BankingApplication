<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Form</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>
<div class="container">
   <f:form action="successDeposit" modelAttribute="depositCommand">
   <div class="heading"><h2>Deposit Form</h2></div>
   <div class="table">
	     <table>
	           <tr>
	              <td>Account Number</td>
	              <td><f:input path="toAccount" /></td>
	           </tr>
	           <tr>
	              <td>Amount to be deposited</td>
	              <td><f:input path="amount" /></td>
	           </tr>
	           <tr>
	              <td><button onclick="myFunction()">Deposit</button></td>
	             
	           </tr>
	     </table>
     </div> 
   </f:form>
</div>   

<script>
		function myFunction() {
			if (!(confirm('are you sure you want to deposit?')))
				return false;
			
			alert("succesfully deposited")
		}
</script> 

</body>
</html>