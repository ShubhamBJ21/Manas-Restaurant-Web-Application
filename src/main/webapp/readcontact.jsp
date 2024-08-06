<%@page import="com.shubham.model.Contact"%>
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
<title>Read Contact</title>

<!-- Admin Template Stylesheet -->
    <link href="css/adminstyle.css" rel="stylesheet">
</head>
<body>
    <header>
        <h1>Read Contact</h1>
    </header>
    
    <nav>
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="ReadMessageServlet">Refresh</a></li>
        </ul>
    </nav>
    
    <div class="content">
        <h3><%@ include file="message.jsp" %></h3>
        <table>
            <thead>
                <tr>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>SUBJECT</th>
                    <th>MESSAGE</th>
                    <th>DATE & TIME</th>
                    <th>DELETE</th>
                </tr>
            </thead>
            <tbody>
                <%
                ArrayList<Contact> arraylist = (ArrayList<Contact>)session.getAttribute("contactdata");
                for(Contact element : arraylist){
                %>
                <tr>
                    <td><%= element.getName() %></td>
                    <td><%= element.getEmail() %></td>
                    <td><%= element.getSubject() %></td>
                    <td><%= element.getMessage() %></td>
                    <td><%= element.getDateTime() %></td>
                    <td>
                        <form action="deletecontact" method="post">
                            <input type="hidden" name="contactId" value="<%= element.getCid() %>"/>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
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
