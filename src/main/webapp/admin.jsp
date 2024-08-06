<% String check = (String) session.getAttribute("adminlogin");
   if(check == null){
	   response.sendRedirect("adminlogin.jsp");
	   return;
   }
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Panel</title>

 <!-- Admin Template Stylesheet -->
    <link href="css/adminstyle.css" rel="stylesheet">
</head>
<body>
    <header>
        <h1>Admin Panel</h1>
         <h3> <%@ include file="message.jsp" %> </h3>
    </header>
    
    <!-- navigation bar -->
    <%@include file="adminnav.jsp" %>
    
    <div class="content">
        <h2>Welcome to the Admin Panel</h2>
        <p>This is the main content area where you can manage your admin tasks.</p>
    </div>
    <footer>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>
