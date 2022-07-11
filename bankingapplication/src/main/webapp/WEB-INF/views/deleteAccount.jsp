<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
</head>
<body>
<div class="container">
	<f:form action="deleteAccountDetail" modelAttribute="account">
       <div class="heading"><h2>Enter Account Number</h2></div>
       <div class="table">
		<table>
			<tr>
				<td>Account Number</td>
				<td><f:input path="toAccount" /></td>
			</tr>
			<tr>
				<td><button onclick="myFunction()">Delete</button></td>

			</tr>
		</table>
		</div>

	</f:form>
</div>

		<script>
			function myFunction() {
				if (!(confirm('are you sure you want to delete?')))
					return false;
			}
			alert("succesfully deleted")
		</script>

</body>
</html>