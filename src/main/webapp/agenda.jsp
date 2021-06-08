<%-- 
    Document   : agenda
    Created on : 16 may 2021, 20:30:10
    Author     : alexa
--%>

<%@page contentType="text/html; charset=UTF-8" %>
<%@page session="true"%>
<%@page import="modulos.fechas_validas"%>
<%
//////////////////////////////////////////////////
    request.setCharacterEncoding("UTF-8");
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
        <title>Agenda</title>
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
        <div class="grid grid-cols-1 sm:grid-cols-4">
            <div class="text-left border-2 border-green-500 rounded-md">
                <div class="col-span-1 sm:col-span-4">
                    <h1 class="text-dark py-2 px-4 font-semibold">Bienvenido, usuario</h1>
                    <h1 class="text-dark py-2 px-4 font-bold">
                        <%
                            String id_strin = String.valueOf(session.getAttribute("id"));
                            int id_pro = Integer.parseInt(id_strin);
                            out.print(poo.dame_nombre_user(id_pro)); %>
                    </h1>
                </div>
                <div class="py-4 px-4">
                    <%-- area de boton de salir
                    --%>
                    <jsp:include page="salir.html" ></jsp:include>
                    
                    <%
                 if (request.getParameter("adios") != null) {
                String ip, agente;
                ip = request.getRemoteAddr();
                agente = request.getHeader("user-agent");
                poo.datos_log(id_pro, ip, agente);
                session.invalidate();
                response.sendRedirect("index.html");
                        }
                    %>
                </div>
            </div>

            <div class="border-2 border-green-500 rounded-md col-span-1 sm:col-span-2">
                <div class="col-span-1 sm:col-span-4">
                    <jsp:include page="registro_agenda.html"></jsp:include>
                    </div>

                    <br>

                    <div class="grid col-span-1 sm:grid-cols-4 gap-4 my-2">
                        <div class="col-span-1 sm:col-span-2 border-2 border-green-500 rounded-br-lg rounded-tl-lg">
                            <h3 class="italic font-normal">Fechas que se han registrado datos</h3>
                            <h4 class="font-light">
                            <%
                                String[] vector_fechas = poo.dame_fechas(id_pro);
                                out.print("<ol  type = \"A\">");
                                for (String vector_fecha : vector_fechas) {
                                    out.print("<label>" + "<li>" + vector_fecha + "</lib>" + "</label>" + "<br>");
                                }
                                out.print("</ol>");
                            %>
                        </h4>
                    </div>

                    <div class="col-span-1 sm:col-span-2">
                        <%-- 
                        area de cuadro de selcionar fecha
                        --%>
                        <jsp:include page="selecion_fecha.html"></jsp:include>
                            <div class="col-span-1 sm:col-span-2 border-2 border-green-500 rounded-br-lg rounded-tl-lg">
                                <center>
                                    <h4 class="font-semibold">
                                    <%//para ver los datos xD
                                        String fecha = request.getParameter("fecha");
                                        if (fecha != null) {
                                            String[] vector_datos = poo.dame_dato_agenda(fecha, id_pro);
                                            out.print("<ol  type = \"A\">");
                                            for (String vector_dato : vector_datos) {
                                                out.print("<label>" + "<li>" + vector_dato + "</lib>" + "</label>" + "<br>");
                                            }
                                            out.print("</ol>");
                                            fecha = "";
                                        }
                                    %>
                                </h4>
                            </center>
                        </div>
                    </div>
                </div>
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
                    --%>  <jsp:include page="borrar.html"></jsp:include>
                    
                    <%    String activo = String.valueOf(request.getParameter("valido_borrar_agenda"));
                        if (activo.equals("borrar")) {
                            fecha = String.valueOf(request.getParameter("fecha_borrar"));
                            out.print(poo.borrar(id_pro, fecha));
                            response.sendRedirect("agenda.jsp");
                        }

                    %>
                </center>
            </div>
            <div class="border-2 border-green-500 rounded-md">
                <jsp:include page="limpiar.html"></jsp:include>
                <br>
                <div>
                    <center>
                        <a href="play_spotify.html" target="_blank"><input type="image" src="boton_a_playlist.jpg" width="300" height="380"></a>
                    </center>
                </div>
                <div>

                </div>
                <br>
                <div>
                    <button id="btn-abrir-popup" class="btn-abrir-popup rounded-lg shadow-md transform motion-safe:hover:scale-110 py-2 px-4 bg-gradient-to-r from-green-400 to-blue-500 hover:from-pink-500 hover:to-yellow-500">Informaci&oacute;n Importante</button>

                <div class="overlay" id="overlay">
                    <div class="popup bg-gradient-to-r from-green-400 to-blue-500" id="popup">
                        <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 inline-block" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 15l-2 5L9 9l11 4-5 2zm0 0l5 5M7.188 2.239l.777 2.897M5.136 7.965l-2.898-.777M13.95 4.05l-2.122 2.122m-5.657 5.656l-2.12 2.122" />
                            </svg>
                        </a>
                        <h3>¡Hola!</h3>
                        <p>Este proyecto se ha realizado</p>
                        <p>con mucho esfuerzo, sudor y sangre (?).</p>
                        <p>Aquí hay unos enlaces con</p>
                        <p>las herramientas e información</p>
                        <p>que se utilizó.</p>
                        <br>
                        <form action="">
                            <div class="contenedor-inputs">
                                <font color="white">Materialize CSS
                                <a href="https://materializecss.com/">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 inline-block" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                                    </svg>
                                </a>
                                </font>
                                <br>
                                <font color="white">Tailwind CSS
                                <a href="https://tailwindcss.com/">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 inline-block" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                                    </svg>
                                </a>
                                </font>
                                <br>
                                <font color="white">Bootstrap
                                <a href="https://getbootstrap.com/">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 inline-block" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                                    </svg>
                                </a>
                                </font>
                                <br>
                            </div>
                            <br>
                            <font color="white">Link al repositorio en GitHub
                            <a href="https://github.com/alkeys/proyect_web">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 inline-block" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7v8a2 2 0 002 2h6M8 7V5a2 2 0 012-2h4.586a1 1 0 01.707.293l4.414 4.414a1 1 0 01.293.707V15a2 2 0 01-2 2h-2M8 7H6a2 2 0 00-2 2v10a2 2 0 002 2h8a2 2 0 002-2v-2" />
                                </svg>
                            </a>
                            </font>
                        </form>
                    </div>
                </div>
                </div>
            </div>

            <script src="popup.js"></script>
        </div>
    </body>
</html>
