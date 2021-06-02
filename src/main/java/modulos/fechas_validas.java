package modulos;

import controlador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class fechas_validas {

    Connection cc;
    Statement miStatement;
    ResultSet miResultSet;

    public fechas_validas() {
        conexion cc = new conexion();
        this.cc = cc.getCc();
    }

    public String[] dame_fechas(int id_usuario) {
        ArrayList<String> fechas = new ArrayList<>();
        try {

            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM `agenda` WHERE idUsaurio='" + id_usuario + "'");
            while (miResultSet.next()) {
                fechas.add(miResultSet.getString("fecha"));
            }
        } catch (SQLException e) {
            return null;
        }
        String[] fechas_vector = new String[fechas.size()];
        for (int i = 0; i < fechas_vector.length; i++) {
            fechas_vector[i] = fechas.get(i);
        }
        fechas=null;
        return fechas_vector;
    }

    public String[] dame_dato_agenda(String fecha, int id) {
        ArrayList<String> datos_temp=new ArrayList<>();
        try {
            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM `agenda` WHERE idUsaurio='" + id + "' AND " + "fecha='" + fecha + "'");
            while (miResultSet.next()) {
                datos_temp.add(miResultSet.getString("descripcion"));
            }
        } catch (SQLException e) {
            return null;
        }
     String[] datos=new String[datos_temp.size()];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=datos_temp.get(i);
        }
      datos_temp=null;
      return datos;
    }

    public String dame_nombre_user(int id) {
        String nombre = null;
        try {

            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM `usuario` WHERE id='" + id + "'");
            while (miResultSet.next()) {
                nombre = miResultSet.getString("usuario");
            }
        } catch (SQLException e) {
            return e.getMessage();
        }

        return nombre;
    }

    public String guardar(String dato_agenda, int id, String ip, String agente, String fecha) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hora = sdf.format(dt);
        String Intrucion = "";
        Intrucion = "INSERT agenda (`descripcion`,`fecha`,`createdBy`,`updatedBy`,`updatedAt`,`idUsaurio`,`createdAt`) "
                + "VALUES ('" + dato_agenda + "','" + fecha + "','" + ip + "','" +agente + "','" + hora + "','"+id+"','"+hora+"')";
        try {
            miStatement = cc.createStatement();
            miStatement.executeUpdate(Intrucion);
        } catch (SQLException e) {
            return e.getMessage();
        }

        return "guardado con exito";
    }
   
    public String borrar(int id,String fecha){
        try {
        String Intrucion="DELETE FROM agenda WHERE idUsaurio='"+id+"' AND fecha='"+fecha+"'";
        miStatement = cc.createStatement();
        miStatement.executeUpdate(Intrucion);
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "borrado con exito";
    }
    
    public void datos_log(int id,String ip,String agente){
        //guarda el log de inicio de secion
       java.util.Date dt=new java.util.Date();
       java.text.SimpleDateFormat sdf=new  java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String hora=sdf.format(dt);
            String Intrucion = "";
        Intrucion = "INSERT INTO `agenda`.`log_usuario` (`fechaSalida`,`idUsuario`,`createdBy`,`createdAt`,`updatedBy`) "
                + "VALUES ('"+hora+"',"+id+",'"+ip+"','"+hora+"','"+agente+"'"+")";
        try {
            miStatement = cc.createStatement();
            miStatement.executeUpdate(Intrucion);
        } catch (SQLException e) {
        }
        
    }
    
    
}
