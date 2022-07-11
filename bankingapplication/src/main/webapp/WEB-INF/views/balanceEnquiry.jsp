<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/styleLogin.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
</head>
<body>
<div class="container">
    <f:form action="successEnquire" modelAttribute="balanceCommand">
   <div class="table">
     <div class="heading"><h2>Enter Your Account Number</h2></div>
     <div>
     <table>
           <tr>
              <td>Account Number</td>
              <td><f:input path="toAccount" /></td>
           </tr>
           <tr>
              <td><input  type="submit" value="Enquire" /></td>    
           </tr>
     </table>
     </div>
   </div>
   </f:form>
   
 </div>  
    
</body>
</html>