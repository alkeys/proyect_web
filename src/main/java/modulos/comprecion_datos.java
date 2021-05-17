package modulos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class comprecion_datos {

    Connection cc;
    Statement miStatement;
    ResultSet miResultSet;

    public comprecion_datos(Connection cc) {
        this.cc = cc;
    }
    
    public void datos_log(int id,String ip,String agente){
        //guarda el log de inicio de secion
       java.util.Date dt=new java.util.Date();
       java.text.SimpleDateFormat sdf=new  java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String hora=sdf.format(dt);
            String Intrucion = "";
        Intrucion = "INSERT INTO `agenda`.`log_usuario` (`fechaIngreso`,`idUsuario`,`createdBy`,`createdAt`,`updatedBy`) "
                + "VALUES ('"+hora+"',"+id+",'"+ip+"','"+hora+"','"+agente+"'"+")";
        try {
            miStatement = cc.createStatement();
            miStatement.executeUpdate(Intrucion);
        } catch (SQLException e) {
        }
        
    }
    
    public String[] dame_id() {
        //retorna los id de usuarios   
        String[] id_lista;
        ArrayList<String> id_agregados = new ArrayList<>();
        try {
            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM usuario");
            String aux;

            while (miResultSet.next()) {
                id_agregados.add(miResultSet.getString("id"));
            }

            id_lista = new String[id_agregados.size()];
            for (int i = 0; i < id_lista.length; i++) {
                id_lista[i] = id_agregados.get(i);
            }
        } catch (SQLException e) {
            return null;
        }
        return id_lista;
    }

    public int cant_datos() {
        ArrayList<String> id_agregados = new ArrayList<>();
        int cant = 0;
        try {
            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM usuario");
            while (miResultSet.next()) {
                id_agregados.add(miResultSet.getString("id"));
            }
            cant = id_agregados.size();
        } catch (SQLException e) {
            return 0;
        }
        return cant;
    }

    public String[][] dame_datos_usuarios() {
        //datos para combrobar usuarios
        int cant=cant_datos();
                             //id,usuario,contraseña
        String[][] matris=new String[cant][3];
        try {
            miStatement = cc.createStatement();
            miResultSet = miStatement.executeQuery("SELECT * FROM usuario");
           int cont=0;
            while (miResultSet.next()) {
             matris[cont][0]=miResultSet.getString("id");
             matris[cont][1]=miResultSet.getString("usuario");
             matris[cont][2]=miResultSet.getString("contrasenia");
             cont++;
            }

        } catch (SQLException e) {
            return null;
        }
        return matris;
    }

    public String guardar_datos_usuarios(int id, String user, String pass, String nombre, String Apellido, String direccion, String tel,String ip,String agente) {
        //guarda los datos de la tabal de usuarios
       java.util.Date dt=new java.util.Date();
       java.text.SimpleDateFormat sdf=new  java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String hora=sdf.format(dt);
        String Intrucion = "";
        Intrucion = "INSERT usuario (id,usuario,contrasenia,nombre,Apellido,direccion,celular,createdBy,createdAt,updatedBy) "
                + "VALUES(" + id + ",'" + user + "','" + pass + "','" + nombre + "','" + Apellido + "','" + direccion + "','" + tel + "','"+ip+"','"+hora+"','"+agente+"')";
        try {
            miStatement = cc.createStatement();
            miStatement.executeUpdate(Intrucion);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "registro con exito";
    }

}
