
import controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modulos.Usuarios;

/**
 *
 * @author Carito Flores
 */
public class UsuariosSI {

    Connection conexion;

    public UsuariosSI() {
        conexion con = new conexion();
        conexion = con.getCc();

    }

    public List<Usuarios> listarUsuarios() {
        PreparedStatement ps;
        ResultSet rs;
        List<Usuarios> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, usuario, nombre,apellido,contrasenia,celular,direccion, createdBy,updatedBy,createdAt,updatedAt,correo FROM usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String password = rs.getString("contrasenia");
                String celular = rs.getString("celular");
                String direccion = rs.getString("direccion");
                String createdBy = rs.getString("createdBy");
                String updatedBy = rs.getString("updatedBy");
                String createdAt = rs.getString("createdAt");
                String updatedAt = rs.getString("updatedAt");
                    String correo = rs.getString("correo");
                Usuarios usuario = new Usuarios(id, descripcion, password, nombre, apellido, celular, direccion, createdBy, updatedBy, createdAt, updatedAt,correo);

                lista.add(usuario);

            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;

        }

    }

    public Usuarios enseñarUsuarios(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        Usuarios usuario = null;

        try {
            ps = conexion.prepareStatement("SELECT id,usuario,contrasenia, nombre,apellido,celular,direccion, createdBy,updatedBy,createdAt,updatedAt,correo FROM usuario WHERE id=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String password = rs.getString("contrasenia");
                String celular = rs.getString("celular");
                String direccion = rs.getString("direccion");
                String createdBy = rs.getString("createdBy");
                String updatedBy = rs.getString("updatedBy");
                String createdAt = rs.getString("createdAt");
                String updatedAt = rs.getString("updatedAt");
                String correo = rs.getString("correo");

                usuario = new Usuarios(id, descripcion, password, nombre, apellido, celular, direccion, createdBy, updatedBy, createdAt, updatedAt,correo);

            }
            return usuario;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;

        }

    }


    public boolean borrar(int _id) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM agenda WHERE idUsaurio=?");
            ps.setInt(1, _id);
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("DELETE FROM log_usuario WHERE idUsuario=?");
            ps.setInt(1, _id);
            ps.executeUpdate();
            
            ps = conexion.prepareStatement("DELETE FROM usuario WHERE id=?");
            ps.setInt(1, _id);
            ps.executeUpdate();
            
            
            
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;

        }

    }

}
