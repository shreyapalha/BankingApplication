<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>
       
<div class="container">    
    <f:form action="newCustomerSubmit" modelAttribute="customer">
    <div class="heading"><h2>Add Customer Detail</h2></div>
    <div class="table">
     <table>
           <tr>
              <td>Person Name</td>
              <td><f:input path="personName"/></td>
           </tr>
           <tr>
              <td>Gender</td>
              <td><f:input path="gender"/></td>
           </tr>
           <tr>
              <td>Customer Status</td>
              <td><f:input path="customerStatus"/></td>
           </tr>
           <tr>
              <td>Flat No</td>
              <td><f:input path="flatNo"/></td>
           </tr>
           <tr>
              <td>City</td>
              <td><f:input path="city"/></td>
           </tr>
           <tr>
              <td>Pin</td>
              <td><f:input path="pincode"/></td>
           </tr>
           <tr>
              <td>State</td>
              <td><f:input path="state"/></td>
           </tr>
           <tr>
              <td>Manager Id</td>
              <td><f:input path="managerId"/></td>
           </tr>
           <tr>
              <td>Branch Id</td>
              <td><f:input path="branchId"/></td>
           </tr>
           <tr>
             <td>User Name</td>
              <td><f:input path="username"/></td>
           </tr>
           <tr>
             <td>Password</td>
              <td><f:input path="password"/></td>
           </tr>
           <tr>
             <td><button onclick="myFunction()">Add Customer</button></td>
           </tr>
           
     </table>
   </div>
   </f:form>
   
</div>    
   <script>
function myFunction() {
  alert("Customer has been successfully added")
}
</script>
</body>
</html>