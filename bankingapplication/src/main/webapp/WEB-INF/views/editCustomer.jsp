<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
	<f:form action="successCustomer" modelAttribute="editCustomerCommand">
	<div class="heading"><h2>Edit Customer Detail</h2></div>
	<div class="table">
		<table>
			<tr>
				<td>person Id</td>
				<td><f:input path="personId" /></td>
			</tr>
			<tr>
				<td>Branch Id</td>
				<td><f:input path="branchId" /></td>
			</tr>
			<tr>
				<td>Address Id</td>
				<td><f:input path="addressId" /></td>
			</tr>
			<tr>
				<td>Account Number</td>
				<td><f:input path="accountNumber" /></td>
			</tr>
			<tr>
				<td>Person Name</td>
				<td><f:input path="personName" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><f:input path="gender" /></td>
			</tr>
			<tr>
				<td>Customer Status</td>
				<td><f:input path="customerStatus" /></td>
			</tr>
			<tr>
				<td>Flat Number</td>
				<td><f:input path="flatNo" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><f:input path="city" /></td>
			</tr>
			
			<tr>
				<td>pincode</td>
				<td><f:input path="pincode" /></td>
			</tr>
			<tr>
				<td>Account Type</td>
				<td><f:input path="accountType" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><f:input path="state" /></td>
			</tr>
			<tr>
				<td>Branch Name</td>
				<td><f:input path="branchName" /></td>
			</tr>
			<tr>
				<td>IFSC</td>
				<td><f:input path="IFSC" /></td>
			</tr>
			<tr>
				<td><button onclick="myFunction()">Edit Customer</button></td>
			</tr>
		</table>
	  </div>	
		
	</f:form>
</div>
<script>
    
		function myFunction() {
		  alert("Customer has been successfully updated")
		}
		
    </script>	
	
</body>