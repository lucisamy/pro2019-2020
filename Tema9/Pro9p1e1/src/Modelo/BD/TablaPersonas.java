/*
En esta clase se coloca todo el código para manejar la tabla personas en la base de datos
 */
package Modelo.BD;

import UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class TablaPersonas {
    private Connection con;

    public TablaPersonas(Connection con) {
        this.con = con;
    }
    
    public void insertarPersona(Persona p){
        try {
            String plantilla = "INSERT INTO PERSONAS VALUES(?,?,?,?);";
            //unimos la conexión con sentencia sql
            PreparedStatement ps = con.prepareStatement(plantilla);
            //asignamos valor a los parámetros (las columnas)
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setString(3, p.getProfesion());
            ps.setString(4, p.getTel());
            //ejecutamos sentencia sql (DML)
            int n = ps.executeUpdate();//nos devuelve filas afectadas
            ps.close();
            if(n!=1)
                throw new Exception("Problemas en la insert");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public Persona seleccionarPersona(String nombre){
        try{
            String plantilla = "SELECT * FROM PERSONAS WHERE NOMBRE = ?;";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            //ejecutamos consulta sql
            ResultSet resultado = ps.executeQuery();
            /*suponemos que en esta base de datos se ussará nombre como clave,
                por tanto debería haber una sola persona con ese nombre*/
            if(resultado.next()){//método next se posiciona en la primera o sgte fila, devuelve true si ha encontrado fila.
                //crear objeto y meterle los datos que ha devuelto la consulta
                Persona p = new Persona(resultado.getString("nombre"),
                                        resultado.getInt("edad"),
                                        resultado.getString("profesion"),
                                        resultado.getString("telefono"));
                //devolvemos el objeto ya con todos los datos
                return p;
            }
            else
                //no hay nadie con ese nombre
                return null;
                
        }
        catch(Exception e){
            return null;
        }
    }
    public ArrayList<Persona> seleccionarTodos(){
        try {
            ArrayList<Persona>listaPersonas = new ArrayList();
            //Preparamos sentencia sql con plantilla
            String plantilla = "SELECT * FROM PERSONAS;";
            //enlazamos sentencia con objeto conexión.
            //se podría usar Statement pero es más seguro con preparedStatement
            PreparedStatement ps = con.prepareStatement(plantilla);
            //ejecutamos consulta
            ResultSet resultado = ps.executeQuery();
            //como sabemos que nos devuelve muchas filas usamos repetitiva
            while(resultado.next())//mientras haya sgte fila
            {    //crear objeto y lo llenamos con el contenido de las columnas
                Persona p = new Persona(resultado.getString("nombre"),
                                        resultado.getInt("edad"),
                                        resultado.getString("profesion"),
                                        resultado.getString("telefono"));
                //añadimos objeto al Arraylist
                listaPersonas.add(p);
            }
            return listaPersonas;
        } catch (Exception e) {
            return null;
        }
    }
}
