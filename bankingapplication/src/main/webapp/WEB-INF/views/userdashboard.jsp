<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/body.css">
<link rel="stylesheet" href="/bankingapplication/resource/css/styleUser.css">
</head>
<body>
<div class="nav-container">
       <div class="btn-div-nav"><button class="btn-1" onclick="location.href='logoutUser';"  type="button">Logout</button></div>
       <div class="nav-heading">
          <h2>Welcome To The Bank</h2>
       </div>

		<div class="nav-info">
		        <div>
					<% String name = (String)session.getAttribute("name");%>
					<% out.println(name);%>
				</div>	
				
				<div>
					<% String branch = (String)session.getAttribute("branch");%>
					<% out.println(branch);%>
				</div>
				
		</div>
</div>		
		
				
				
			<hr>
<div class="container-body">			
		<div>
		    <h2>My Dashboard</h2>
		</div>	
			
		<div class="btn-body">
		    <div class="btn-div"><button class="btn-1" onclick="location.href='balanceEnquiry';"  type="button">Balance Enquiry</button></div>
		    <div class="btn-div"><button class="btn-1" onclick="location.href='miniStatement';"  type="button">Mini Statement</button></div>
		    <div class="btn-div"><button class="btn-1" onclick="location.href='customisedStatement';"  type="button">Customised Statement</button></div>
		   
		
		</div>	
</div>			
			
</body>
</html>