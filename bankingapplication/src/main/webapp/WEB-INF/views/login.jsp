<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">

<title>User Login Form</title>
<style>
.error{color:red}
</style>
</head>
<body >
<div class="container">
	<form:form name="submitForm" method="POST"  modelAttribute="command">
		
		    <div class="heading"><h2 id="col">Enter Your Credentials</h2></div>
		    <div class="table">
				<table >
					<tr>
						<td>User Name </td>
						<td><input type="text" name="userName" required/></td>
						<form:errors path="userName" cssClass="error"/>
					</tr>
					<tr>
						<td>Password </td>
						<td><input type="password" name="password" required /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</div>
			
	</form:form>
</div>	


</body>
</html>