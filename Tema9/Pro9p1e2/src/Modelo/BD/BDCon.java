/*

 */
package Modelo.BD;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lucía
 */
public class BDCon {
    
    Connection con;

    public BDCon() {}
    
    public void conectar(){
        try{
            //Indicar Driver
            Class.forName("com.mysql.jdbc.Driver");
            //Indicar datos para la conexión: bd,url,login,password
            String bd = "bdeventos";
            String url = "jdbc:mysql://localhost:3307/"+bd;
            String login = "root";
            String password = "usbw";
            //obtener conexión
            con = DriverManager.getConnection(url,login,password);
            
            //comprobamos que la conexión fue correcta y sino lanzamos excepción.
            if(con ==null)
                throw new Exception();
        }
        catch(Exception e){
            System.out.println("Problemas al conectarse a la BD");
        }
        
    }
    public void desconectar(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Problemas con la desconexión de la BD");
        }
        
    }
    public Connection getCon(){
        return con;
    }
}
