<%
   String message = (String) session.getAttribute("msg");

   if (message != null) {
	   if(message.contains("SUCCESSFULLY") || message.contains("VALID")){
%>
        <span style="color:green"><%= message %></span>
<%     }
	   else{
%>
       <span style="color:red"><%= message %></span>
<%
    }
       // Remove message from session once it is printed
       session.removeAttribute("msg");
   }
%>
