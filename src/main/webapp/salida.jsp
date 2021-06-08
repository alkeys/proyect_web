<%-- 
    Document   : salir
    Created on : 2 jun 2021, 10:31:32
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
         session.invalidate();
         response.sendRedirect("index.html");
        %>
    </body>
</html>
