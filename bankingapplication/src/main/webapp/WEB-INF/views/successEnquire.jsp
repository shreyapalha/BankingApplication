<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success !!</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/noForm.css">
</head>
<body>

     <%
    double bal=(double)request.getAttribute("balance");
     %>

   <h1>Your balance is <%=bal%></h1>
   <a href="managerdashboard">Go back to your Dashboard</a>

   

</body>
</html>