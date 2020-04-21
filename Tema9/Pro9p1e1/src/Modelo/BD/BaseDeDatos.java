/*
En esta clase se definen las características de la base de datos y los métodos
para acceder a ella, loguearse y desconectarse
 */
package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class BaseDeDatos {
    
    private Connection con;
    
    public BaseDeDatos(){}
    
    public void conectar(){
        try{
            //identificamos el driver de la base de datos, en este caso sql
            Class.forName("com.mysql.jdbc.Driver");
            //datos para la conección: bd,url,login,contraseña..
            String bd="programbd";
            String url="jdbc:mysql://localhost:3307/"+bd;
            String login ="root";
            String password = "usbw";
            //obtenemos conexión:
            con = DriverManager.getConnection(url,login,password);
            if(con==null)
                throw new Exception("Problemas con la conexión");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void desconectar(){
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas cerrando la conexión");
        }
    }
    public Connection getCon(){
        return con;
    }
}
