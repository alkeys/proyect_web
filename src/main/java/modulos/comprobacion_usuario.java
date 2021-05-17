
package modulos;
import controlador.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author alexa
 */
public class comprobacion_usuario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user,pass,id_consulta;
        conexion cc=new conexion();
        comprecion_datos cop=new comprecion_datos(cc.getCc());
       user=request.getParameter("user");
       pass=request.getParameter("pass");
       id_consulta=request.getParameter("id");
       String[][] consulta=cop.dame_datos_usuarios();
       boolean verda=false;
       String tipo_error="";
       int id = 0;
       for (int i = 0; i < consulta.length; i++) {
            //el primer dato dela matris es el id
            if(id_consulta.equals(consulta[i][0])){
                //segundo dato es usuario
                if(user.equals(consulta[i][1])){
                    //3 dato contraseña
                    if(pass.equals(consulta[i][2])){
                        verda=true;
                        id=Integer.parseInt(consulta[i][0]);
                        break;
                    }else{
                        verda=false;
                        tipo_error="error de contraseña";
                    }
                }else{
                    tipo_error="usuario incorrecto";
                    verda=false;
                }
            }else{
                tipo_error="id invalido";
                verda=false;
            }
        }
       if(verda){
           String ip=request.getRemoteAddr();//obtiene la ip
           String agente=request.getHeader("user-agent");
           cop.datos_log(id,ip,agente);
           request.getRequestDispatcher("agenda.jsp").forward(request, response);
       }else{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet comprobacion_usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error " + tipo_error+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
       }
       

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
