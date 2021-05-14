package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
        Connection cc;
    public conexion() {
        String user = "root";
        String pass = "UesOcc";
        try {
       Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/agenda";
            cc = DriverManager.getConnection(url, user, pass);
        } catch ( ClassNotFoundException | SQLException e) {
        
        }
    
    }
    
    public Connection getCc() {
        return cc;
    }

    
}
