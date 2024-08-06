<!DOCTYPE html>
<%@page import="com.shubham.model.ServiceModule"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Update Service Page</title>
<link href="css/addservicestyle.css" rel="stylesheet">
</head>
<body>

    <% String check = (String) session.getAttribute("adminlogin");
       if(check == null){
           response.sendRedirect("adminlogin.jsp");
           return;
       }
    %>
    <header>
        <h1>Add Service</h1>
        <h3><%@ include file="message.jsp"%></h3>
    </header>

    <!-- navigation bar -->
    <%@include file="adminnav.jsp"%>

    <% 
         int index = Integer.parseInt(request.getParameter("index"));
         ArrayList<ServiceModule> arraylist = (ArrayList<ServiceModule>)session.getAttribute("servicedata");
         ServiceModule serviceModule = arraylist.get(index);
       %>

    <div class="update-service-container">
        <form action="updateservice" method="post">
            <label>ICON</label> 
            <input type="text" name="icon" value="<%= serviceModule.getIconName()%>">
            
            <label>TITLE</label>
            <input type="text" name="title" value="<%= serviceModule.getTitle() %>">
            
            <label>DESCRIPTION</label>
            <textarea rows="5" cols="20" name="description"> <%= serviceModule.getDescription()%> </textarea>

            <button>Update Services</button>
        </form>
    </div>
</body>
</html>
