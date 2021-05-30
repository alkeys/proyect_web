<%-- 
    Document   : agenda
    Created on : 16 may 2021, 20:30:10
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page import="modulos.fechas_validas"%>
<%
//////////////////////////////////////////////////
    if (request.getParameter("user") != null) {
        session.setAttribute("id", request.getAttribute("id_user"));
    }
///////////////////////////////////////////
    fechas_validas poo = new fechas_validas();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda</title>
    </head>
    <body>
    <center>
        <h1>hola <%
            String id_strin = String.valueOf(session.getAttribute("id"));
            int id_pro = Integer.parseInt(id_strin);
            out.print(poo.dame_nombre_user(id_pro)); %> </h1>
    </center>
    <br>
    <jsp:include page="registro_agenda.html"></jsp:include>
        <br><!-- comment -->
        <center>

            <h3>fechas que se han registrado datos</h3>
            <h4><%
                 String[] vector_fechas=poo.dame_fechas(id_pro);
                out.print("<ol  type = \"A\">");
                for (String vector_fecha : vector_fechas) {
                   out.print("<label>"+"<li>"+vector_fecha+"</lib>"+"</label>"+"<br>");
                }
                out.print("</ol>");     
            %></h4>

    </center>
    <br>
    <br>
    <%-- 
area de cuadro de selcionar fecha
--%>
    <jsp:include page="selecion_fecha.html"></jsp:include>
        <center>
            <h4><%//para ver los datos xD
                String fecha = request.getParameter("fecha");
                if(fecha!=null){
                String[] vector_datos=poo.dame_dato_agenda(fecha, id_pro);
                out.print("<ol  type = \"A\">");
              for (String vector_dato : vector_datos) {
                       out.print("<label>"+"<li>"+vector_dato+"</lib>"+"</label>"+"<br>");
                  }
                out.print("</ol>"); 
                fecha="";
                }
            %></h4>
    </center>
    
    <center>

        <%
            String pass = String.valueOf(request.getParameter("valido_ward"));
            if (pass.equals("guardar")) {
                //programar boton de guaradra aqui XDXDXD 
                String texto = request.getParameter("texto_agenda");
                String id_s = String.valueOf(session.getAttribute("id"));
                int id_p = Integer.parseInt(id_s);
                String ip = request.getRemoteAddr();//obtiene la ip
                String agente = request.getHeader("user-agent");
                fecha = request.getParameter("fecha_registro");
                out.print(poo.guardar(texto, id_p, ip, agente, fecha));
               response.sendRedirect("agenda.jsp");
            }

        %>
    </center>
    <br><br>
    
    
    
    <center>
        <%-- area de cuadro de borrado de datos
--%>            <jsp:include page="borrar.html"></jsp:include>
            <%
                String activo = String.valueOf(request.getParameter("valido_borrar_agenda"));
                if (activo.equals("borrar")) {
                fecha=String.valueOf(request.getParameter("fecha_borrar"));    
              out.print(poo.borrar(id_pro,fecha));
             response.sendRedirect("agenda.jsp");
            }

           %>
    </center>
    <br>
    <center>
    <jsp:include page="limpiar.html"></jsp:include>"
   </center>
        <br><br>
    <center>
        <%-- area de boton de salir
--%>
        <jsp:include page="salir.html"></jsp:include>
        <%    if (request.getParameter("adios") != null) {
                session.invalidate();
                response.sendRedirect("index.html");
            }

        %>
    </center>

</body>
</html>
