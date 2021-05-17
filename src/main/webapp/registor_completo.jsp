<%-- 
    Document   : registor_completo
    Created on : 16 may 2021, 17:22:32
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!String datos;%>
    <center>
         <table border="100" width="30" cellspacing="15">
            <thead>
                <tr>
                    <th><label>nombre de usuario</label></th>
                    <th><% datos=request.getParameter("user"); 
                        out.print(datos);
                        %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><label>contraseña:</label></td>
                    <td><% datos=request.getParameter("password"); 
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>nombre del usuario:</label></td>
                    <td><% datos = request.getParameter("nombre"); 
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>apellido:</label></td>
                    <td><% datos = request.getParameter("Apellido"); 
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>direcion:</label></td>
                    <td><%  datos= request.getParameter("direccion");
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>telefono:</label></td>
                    <td><% datos= request.getParameter("tel");
                    out.print(datos);%> </td>
                </tr>
                <tr>
                    <td><label>id de usuario:</label></td>
                    <td><% datos=String.valueOf(request.getAttribute("id_us"));
                        out.print(datos);%></td>
                </tr>
            </tbody>
        </table>
   <a href="index.html">
    <input type="button" value="volver">
    </a>
    </center>
    </body>
</html>
