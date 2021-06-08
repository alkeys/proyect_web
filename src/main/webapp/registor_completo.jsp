<%-- 
    Document   : registor_completo
    Created on : 16 may 2021, 17:22:32
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Regístro Completo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, charset=UTF-8">
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
        <!-- Pop-Up -->
        <link rel="stylesheet" href="estilos.css">
        <!-- Fuente -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600|Open+Sans" rel="stylesheet"> 
    </head>
    <body class="bg-gradient-to-r from-black to-red-900 container mx-auto mt-5 text-center text-white">
        <%!String datos;%>
    <center>
        <table border="100" width="600" cellspacing="15">
            <thead>
                <tr>
                    <th><label>Credenciales</label></th>
                </tr>
            </thead>
            <thead>
                <tr>
                    <td><label>Usuario</label></td>
                    <td><% datos = request.getParameter("user");
                        out.print(datos);
                        %></td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><label>Contraseña:</label></td>
                    <td><% datos = request.getParameter("password");
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>Nombre del usuario:</label></td>
                    <td><% datos = request.getParameter("nombre");
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>Apellido del usuario:</label></td>
                    <td><% datos = request.getParameter("Apellido");
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>Direcci&oacute;n:</label></td>
                    <td><%  datos = request.getParameter("direccion");
                        out.print(datos);%></td>
                </tr>
                <tr>
                    <td><label>Correo</label></td>
                        <td><% datos = request.getParameter("email");
                        out.print(datos);%> </td>
                </tr>
                <tr>
                    <td><label>Tel&eacute;fono:</label></td>
                        <td><% datos = request.getParameter("tel");
                        out.print(datos);%> </td>
                </tr>
                <tr>
                    <td><label>ID de usuario:</label></td>
                    <td><% datos = String.valueOf(request.getAttribute("id_us"));
                        out.print(datos);%></td>
                </tr>
            </tbody>
        </table>
        <div>
            <a href="index.html">
                <input class="capitalize rounded-lg shadow-md transform motion-safe:hover:scale-110 py-2 px-4 bg-gradient-to-r from-green-400 to-blue-500 hover:from-pink-500 hover:to-yellow-500" type="button" value="volver">
            </a>
        </div>
    </center>
</body>
</html>
