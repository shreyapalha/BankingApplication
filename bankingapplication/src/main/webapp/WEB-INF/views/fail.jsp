<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Failure Page</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/noForm.css">

</head>
<body>
<%
  String name=(String)request.getAttribute("err");
%>
<h1><%=name%></h1>

</body>
</html>