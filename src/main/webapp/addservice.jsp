<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Service</title>

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
        <h3><%@ include file="message.jsp" %></h3>
    </header>
    
     <!-- navigation bar -->
    <%@include file="adminnav.jsp" %>
    
    <div class="update-service-container"> 
      <form action="ServiceModuleServlet" method="post">
        <input type="text" name="iconname" placeholder="Enter Icon Name">
        <input type="text" name="title" placeholder="Enter Title"> 
        <input type="text" name="description" placeholder="Enter Description Between 10 to 50 Characters" id="description">
        <button>Add Service</button>
    </form>
    </div>
</body>
</html>
