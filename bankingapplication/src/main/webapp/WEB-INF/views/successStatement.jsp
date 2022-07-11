<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.xoriant.bankingapplication.model.User"%>
<%@ page import="com.xoriant.bankingapplication.model.Transactions"%>
<%@ page import="com.xoriant.bankingapplication.model.TransactionStatus"%>
<%@ page import="com.xoriant.bankingapplication.model.Customer"%>
<%@ page import="com.xoriant.bankingapplication.model.Account"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">

<style>
table.GeneratedTable {
	width: 100%;
	border-collapse: collapse;
	border-width: 2px;
	border-color: #ffcc00;
	border-style: solid;
	color: #000000;
}

table.GeneratedTable td, table.GeneratedTable th {
	border-width: 2px;
	border-color: black;
	border-style: solid;
	padding: 3px;
}

table.GeneratedTable thead {
	background-color: black;
}
</style>

</head>
<body>
<h2>All Transaction</h2>

	<%
	@SuppressWarnings("unchecked")
	   List<Transactions> transaction = (List<Transactions>) request.getAttribute("tranc");
	%>
	<%
	for (Transactions t : transaction) {
		int trancId = t.getTransactionId();
	%>
	<table  class="GeneratedTable">
		<tbody>

			<tr>
				<td>Transaction Id</td>
				<td>
					<%
					out.println(trancId);
					%>
				</td>
			</tr>
			<tr>
				<td>Transaction Status</td>
				<td>
					<%
					TransactionStatus trx = t.getTransactionStatus();
					out.println(trx);
					%>
				</td>
			</tr>
			<tr>
				<td>From Account</td>
				<td>
					<%
					Account fromAccountObj = t.getFromAccount();
					Account toAccountObj = t.getToAccount();

					long fromAccountNumber = fromAccountObj.getAccountNumber();

					out.println(fromAccountNumber);
					%>
				</td>
			</tr>
			<tr>
				<td>To Account</td>
				<td>
					<%
					long toAccountNumber = toAccountObj.getAccountNumber();
					out.println(toAccountNumber);
					%>
				</td>
			</tr>
			<%
			Customer fromAccountCustomer = fromAccountObj.getCustomer();
			Customer toAccountCustomer = toAccountObj.getCustomer();
			%>
			<tr>
				<td>From Person Name</td>
				<td>
					<%
					String fromPerson = fromAccountCustomer.getPersonName();
					out.println(fromPerson);
					%>
				</td>
			</tr>
			<tr>
				<td>To Person Name</td>
				<td>
					<%
					String toPerson = toAccountCustomer.getPersonName();
					out.println(toPerson);
					%>
				</td>
			</tr>
		</tbody>
	</table>
	<%
	}
	%>
</body>
</html>