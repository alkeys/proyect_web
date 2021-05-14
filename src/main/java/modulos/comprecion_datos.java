package modulos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class comprecion_datos {

    Connection cc;
    Statement miStatement;
    ResultSet miResultSet;

    public comprecion_datos(Connection cc) {
        this.cc = cc;
    }

    public String[] dame_id() {
        //retorna los id de usuarios   
        String[] id_lista;
        ArrayList<String> id_agregados=new ArrayList<>();
        try {
            miStatement =cc.createStatement();
            miResultSet=miStatement.executeQuery("SELECT * FROM usuario");
            String aux;
          
            while (miResultSet.next()) { 
                id_agregados.add(miResultSet.getString("id"));
            }
            
            id_lista=new String[id_agregados.size()];
            for (int i = 0; i < id_lista.length; i++) {
                id_lista[i]=id_agregados.get(i);
            }
        } catch (SQLException e) {
        return null;
        }
        return id_lista;
    }

    
    public String guardar_datos_usuarios(int id,String user,String pass, String nombre,String Apellido,String direccion, String tel){
       //guarda los datos de la tabal de usuarios
        String Intrucion="";
         Intrucion="INSERT usuario (id,usuario,contrasenia,nombre,Apellido,direccion,celular) "
                 + "VALUES("+id+",'"+user+"','"+pass+"','"+nombre+"','"+Apellido+"','"+direccion+"','"+tel+"'"+")";
         try {
             miStatement =cc.createStatement();
            miStatement.executeUpdate(Intrucion);
        } catch (Exception e) {
        return e.getMessage();
        }
    return "registro con exito";
    }
    
}
