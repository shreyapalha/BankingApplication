<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini statement Form</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>

<div class="container">
	<f:form action="successStatement" modelAttribute="miniStatementCommand">
     <div class="heading"><h2>Mini statement Form</h2></div>
     <div class="table">
		<table>
			<tr>
				<td>Account Number</td>
				<td><f:input path="accountNo" /></td>
			</tr>
			<tr>
				<td><button>Send</button></td>

			</tr>
		</table>
      </div>
	</f:form>
</div>
</body>
</html>