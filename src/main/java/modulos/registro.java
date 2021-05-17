package modulos;

import controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexa
 */
public class registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        conexion conetion = new conexion();
        comprecion_datos cnp = new comprecion_datos(conetion.getCc());
        int id;
        id = dame_id_nuevo(cnp.dame_id());
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String Apellido = request.getParameter("Apellido");
        String direccion = request.getParameter("direccion");
        String tel= request.getParameter("tel");

        cnp.guardar_datos_usuarios(id, user, pass, nombre, Apellido, direccion, tel);
         request.setAttribute("id_us", id);
        request.getRequestDispatcher("registor_completo.jsp").forward(request, response);
        
        
        /*        try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet registro</title>");
        out.println("</head>");
        out.println("<body style=\"color:rgb(196, 10, 233);\">");
        out.println("<h1> se registro el usuario</h1><br>" );
        out.print("<h1> nombre de usuario: "+user+"</h1><br>");
        out.print("<h1>contraseña: "+pass+"</h1><br>");
        out.print("<h1>nombre: "+nombre+"</h1><br>");
        out.print("<h1> apellido: "+Apellido+"</h1><br>");
        out.print("<h1> direcion: "+ direccion+"</h1><br>");
        out.print("<h1> telefono: "+ tel+"</h1><br>");
        out.print("<h1> id de usuario: "+id+"</h1><br>");
        out.println("</body>");
        out.println("</html>");
        }*/
    }
    
    public int dame_id_nuevo(String[] vector) {
        //generador de ides XDD
        int[] vector_numerico = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vector_numerico[i] = Integer.parseInt(vector[i]);
        }
        boolean verda = false;
        int id_generado;
        do {
            id_generado = (int) (Math.random() * 100);
            for (int i = 0; i < vector_numerico.length; i++) {
                if (vector_numerico[i] == id_generado) {
                    verda = false;
                    break;
                } else {
                    verda = true;
                }
            }
        } while (verda != true);

        return id_generado;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
