<%@page import="com.shubham.model.ServiceModule"%>
<%@page import="java.util.ArrayList"%>
<% 
    String check = (String) session.getAttribute("adminlogin");
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
<title>Read Service</title>

<!-- Admin Template Stylesheet -->
<link href="css/adminstyle.css" rel="stylesheet">
</head>
<body>
    <header>
        <h1>Read Services</h1>
        <h3>Manage your services effectively</h3>
    </header>
    
    <nav>
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="ReadUpdateDeleteServlet">Refresh</a></li>
        </ul>
    </nav>
    
    <div class="content">
        <h3><%@ include file="message.jsp" %></h3>
        <table>
            <thead>
                <tr>
                    <th>ICON Name</th>
                    <th>TITLE</th>
                    <th>DESCRIPTION</th>
                    <th>DATE & TIME</th>
                    <th>UPDATE</th>
                    <th>DELETE</th>
                </tr>
            </thead>
            <tbody>
                <%
                ArrayList<ServiceModule> arraylist = (ArrayList<ServiceModule>)session.getAttribute("servicedata");
                int index = 0;
                for(ServiceModule element : arraylist){
                %>
                <tr>
                    <td><%= element.getIconName() %></td>
                    <td><%= element.getTitle() %></td>
                    <td><%= element.getDescription() %></td>
                    <td><%= element.getDateTime() %></td>
                    <td>
                        <form action="updateservice.jsp?index=<%= index %>" method="post" style="display: inline;">
                            <input type="hidden" name="serviceId" value="<%= element.getServiceId() %>"/>
                            <button type="submit" class="update">Update</button>
                        </form>
                    </td>
                    <td>
                        <form action="DeleteService" method="post" style="display: inline;">
                            <input type="hidden" name="serviceId" value="<%= element.getServiceId() %>"/>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                index++;
                }
                %>
            </tbody>
        </table>
    </div>
    <footer>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>
