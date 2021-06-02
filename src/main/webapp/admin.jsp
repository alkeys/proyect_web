<%-- 
    Document   : agenda
    Created on : 05-29-2021, 11:45:19 PM
    Author     : Carito Flores
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AGENDA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css_/agenda.css" rel="stylesheet">
    </head>
    <body>
        <h1>
            BIENVENIDO AL MODO ADMIN
        </h1>
        <form>
            <fieldset>
                <legend> <p><a style="color: #ffffff;" href="registro.html">
                            NUEVO REGISTRO
                        </a></p></legend>
                <table>
                    <thead>
                        <tr>
                            <th style="background-color:#000; color: white;">USUARIO</th> 
                            <th style="background-color:#000; color: white;">NOMBRE</th> 
                            <th style="background-color:#000; color: white;">APELLIDO</th> 
                            <th style="background-color:#000; color: white;">CONTRASEÑA</th>
                            <th style="background-color:#000; color: white;">CELULAR</th> 
                            <th style="background-color:#000; color: white;">DIRECCION</th> 
                            <th style="background-color:#000; color: white;">CREATEDBY</th> 
                            <th style="background-color:#000; color: white;">UPDATEDBY</th> 
                            <th style="background-color:#000; color: white;">CREATEDAT</th> 
                            <th style="background-color:#000; color: white;">UPDATEDAT</th> 
                            <th style="background-color:#000;"></th> 
                            <th style="background-color:#000;"></th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${lista}">
                            <tr>
                                <th><c:out value="${usuario.descripcion}"/></th> 
                             
                                <th><c:out value="${usuario.nombre}"/></th>
                               
                                <th><c:out value="${usuario.apellido}"/></th>
                                
                                  <th><c:out value="${usuario.password}"/></th>
                                 
                                <th><c:out value="${usuario.celular}"/></th> 
                                <th><c:out value="${usuario.direccion}"/></th>
                                <th><c:out value="${usuario.createdBy}"/></th> 
                                <th><c:out value="${usuario.updatedBy}"/></th>
                                <th><c:out value="${usuario.createdAt}"/></th> 
                                <th><c:out value="${usuario.updatedAt}"/></th>
                                <th style="background-color:#000;"><a style="color:white;" href="UsuariosController?accion=cambiar&id=<c:out value="${usuario.id}"/>">CAMBIAR DATOS</th>
                                <th style="background-color:#000;"><a style="color:white;" href="UsuariosController?accion=borrar&id=<c:out value="${usuario.id}"/>">BORRAR REGISTRO</th>

                            </c:forEach>
                            </fieldset>
                            </form>
                    </tbody>
                </table>
                </body>
                </html>
