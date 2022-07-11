<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password Form</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>

<div class="container">
   <f:form action="successPassword" modelAttribute="changePasswordCommand">
   
     <div class="heading"><h2>Change Password Form</h2></div>
     <div class="table">
	     <table>
	           <tr>
	              <td>Old Password </td>
	              <td><f:input path="oldPassword" /></td>
	           </tr>
	           <tr>
	              <td>New Password</td>
	              <td><f:input path="newPassword" /></td>
	           </tr>
	           <tr>
	              <td>Confirm Password</td>
	              <td><f:input path="confirmPassword" /></td>
	           </tr>
	           <tr>
	              <td><input type="submit" value="Submit" /></td>
	             
	           </tr>
	     </table>
     </div>
   </f:form>
</div>

</body>
</html>