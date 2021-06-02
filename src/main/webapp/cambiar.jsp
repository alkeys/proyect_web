<%-- 
    Document   : cambiar
    Created on : 05-30-2021, 12:47:07 AM
    Author     : Carito Flores
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/style.css" rel="stylesheet">
        <title>CAMBIAR DATOS</title>
    </head>
    <body>
        </fieldset>
    </form>
    </body>
        <h1>CAMBIAR DATOS</h1>
         <form name="cambiar" action="UsuariosController?accion=actualizar" method="POST">
        <fieldset>
            <legend>DATOS</legend>
            <label><input id="id" type="hidden" name="id" value="<c:out value="${usuario.id}"/>"></label>
            <label>USUARIO<input type="text" id="text"placeholder="Digite su descripción" name="descripcion" value="<c:out value="${usuario.descripcion}"/>"></label>
            <label>Nombre<input type="text" id="text" placeholder="Digite su nombre" name="nombre" value="<c:out value="${usuario.nombre}"/>"></label>
            <label>Apellido<input type="text" id="text" placeholder="Digite su apellido" name="apellido" value="<c:out value="${usuario.apellido}"/>"></label>
            <label>CONTRASEÑA<input type="text" id="text" placeholder="Digite su contraseña" name="password" value="<c:out value="${usuario.password}"/>"></label>
            <label>Celular<input type="text" id="text" placeholder="Digite su celular" name="celular" value="<c:out value="${usuario.celular}"/>"></label>
            <label>Dirección<input type="text" id="text" placeholder="Digite su dirección" name="direccion" value="<c:out value="${usuario.direccion}"/>"></label>
            <label>CreatedBy<input type="text" id="text" placeholder="createdBy" name="createdBy" value="<c:out value="${usuario.createdBy}"/>"></label>
            <label>UpdatedBy<input type="text" id="text" placeholder="updatedBy" name="updatedBy" value="<c:out value="${usuario.updatedBy}"/>"></label>
            <label>CreatedAt<input type="text" id="text" placeholder="createdAt" name="createdAt" value="<c:out value="${usuario.createdAt}"/>"></label>
            <label>UpdatedAt<input type="text" id="text" placeholder="updatedAt" name="updatedAt" value="<c:out value="${usuario.updatedAt}"/>"></label>
            <label>correo<input type="text" id="text" placeholder="updatedAt" name="email" value="<c:out value="${usuario.correo}"/>"></label>
            <div id="div3">
                <input type="submit" value="GUARDAR" id="enviar1">
            </div>
</html>

