
import controlador.conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modulos.Usuarios;
import modulos.comprecion_datos;

/**
 *
 * @author Carito Flores
 */
public class UsuariosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuariosSI usuariosSI = new UsuariosSI();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("admin.jsp");
            List<Usuarios> listaUsuarios = usuariosSI.listarUsuarios();
            request.setAttribute("lista", listaUsuarios);
        } else if ("insertar".equals(accion)) {

        } else if ("cambiar".equals(accion)) {
            dispatcher = request.getRequestDispatcher("cambiar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Usuarios usuario = usuariosSI.enseñarUsuarios(id);
            request.setAttribute("usuario", usuario);

        } else if ("actualizar".equals(accion)) {
            try {
                conexion cc = new conexion();
                Connection miConnection = cc.getCc();
                Statement miStatement = miConnection.createStatement();
                String Intrucion = "UPDATE usuario SET "
                        + "nombre=?,"
                        + "apellido=?"
                        + ",celular=?"
                        + ",usuario=?"
                        + ",contrasenia=?"
                        + ",direccion=?"
                        + ",createdBy=?"
                        + ",updatedBy=?"
                        + ",createdAt=?"
                        + ",updatedAt=?"
                        + ",correo=?"
                        + " WHERE id=? ";
                PreparedStatement miPreparedStatement = miConnection.prepareStatement(Intrucion);
                miPreparedStatement.setString(1, request.getParameter("nombre"));
                miPreparedStatement.setString(2, request.getParameter("apellido"));
                miPreparedStatement.setString(3, request.getParameter("celular"));
                miPreparedStatement.setString(4, request.getParameter("descripcion"));
                miPreparedStatement.setString(5, request.getParameter("password"));
                miPreparedStatement.setString(6, request.getParameter("direccion"));
                miPreparedStatement.setString(7, request.getParameter("createdBy"));
                miPreparedStatement.setString(8, request.getParameter("updatedBy"));
                miPreparedStatement.setString(9, request.getParameter("createdAt"));
                miPreparedStatement.setString(10, request.getParameter("updatedAt"));
                miPreparedStatement.setString(11, request.getParameter("email"));
                String id_aux=request.getParameter("id");
                int id_temp=Integer.parseInt(id_aux);
                miPreparedStatement.setInt(12,id_temp );
                miPreparedStatement.executeUpdate();
            } catch (SQLException e) {
            }

            dispatcher = request.getRequestDispatcher("admin.jsp");
            List<Usuarios> listaUsuarios = usuariosSI.listarUsuarios();
            request.setAttribute("lista", listaUsuarios);

        } else if ("borrar".equals(accion)) {
            String id_aux=request.getParameter("id");
            int id = Integer.parseInt(id_aux);
            usuariosSI.borrar(id);
            dispatcher = request.getRequestDispatcher("admin.jsp");
            List<Usuarios> listaCosas = usuariosSI.listarUsuarios();
            request.setAttribute("lista", listaCosas);
        } else {
            dispatcher = request.getRequestDispatcher("admin.jsp");
            List<Usuarios> listaCosas = usuariosSI.listarUsuarios();
            request.setAttribute("lista", listaCosas);
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
