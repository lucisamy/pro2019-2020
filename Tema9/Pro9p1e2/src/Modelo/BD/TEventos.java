/*
En esta clase se colocará el código necesario para interactuar con la tabla
    "eventos" de la BD
se considera el nombre del evento como clave primaria
 */
package Modelo.BD;

import Modelo.UML.Evento;
import java.sql.*;
import pro9p1e2.Pro9p1e2;

/**
 *
 * @author Lucía
 */
public class TEventos {
    
    Connection con;
    
    //Constructor de tabla con conexión

    public TEventos(Connection con) {
        this.con = con;
    }
      
    public void insertar(Evento ev){
        try{
            //preparamos la sentencia SQL
            String plantilla = "INSERT INTO EVENTOS VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(plantilla);
            //asignamos valores a los parámetros
            ps.setString(1,ev.getNombre().toUpperCase());
            ps.setString(2, ev.getLugar());
            ps.setDate(3, Pro9p1e2.convertirFechaSQL(ev.getFecha()));//transformar de localdate a sql date o usar date en la clase "Evento"??
            ps.setTime(4, Pro9p1e2.convertirHoraSQL(ev.getHoraInicio()));//transformar de Localtime a sql time
            ps.setTime(5, Pro9p1e2.convertirHoraSQL(ev.getHoraFin()));
            ps.setInt(6, ev.getAforo());
            //ejecutamos la sentencia SQL
            int n = ps.executeUpdate();
            //
            ps.close();
            //comprobamos si la insert se ha hecho correctamente o lanzamos excepción
            if(n!=1)
                throw new Exception();
        }
        catch(Exception e){
            System.out.println("Problemas en la insert");
        }
    }
    public Evento seleccionar(String nombre){
        try{
            String plantilla = "SELECT * FROM EVENTOS WHERE NOMBRE = ?;";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            //ejecutamos la consulta
            ResultSet resultado = ps.executeQuery();
            //se supone que como es clave primaria nombre no debería haber más de 1 fila
            //preguntamos si ha encontrado ese evento
            if(resultado.next()){
                //creamos objeto evento con los datos obtenidos
                Evento e = new Evento(nombre,resultado.getString("lugar"),
                                      resultado.getDate("fecha"),
                                      resultado.getTime("horaInicio"),
                                      resultado.getTime("horaFin"),
                                      resultado.getInt("aforo"));
                return e;
            }
            else
                throw new Exception("No se encontró el evento");
        }
        catch(Exception e){
            System.out.println("Problemas con la select " + e.getMessage());
        }
    }
    public void eliminar(String nombre){
        try{
            //preparamos la sentencia SQL
            String plantilla = "DELETE FROM EVENTOS WHERE NOMBRE = ?;";
            PreparedStatement ps = con.prepareStatement(plantilla);
            //asignamos valores a los parámetros
            ps.setString(1, nombre.toUpperCase());//en la bd todos los nombres estarán en mayúsculas.
            //ejecutamos la sentencia SQL
            int n = ps.executeUpdate();
            //
            ps.close();
            //comprobamos si la delete se ha hecho correctamente o lanzamos excepción
            if(n!=1)
                throw new Exception();
        }
        catch(Exception e){
            System.out.println("Problemas en el delete");
        }
    }
    public void modificar(){
        
    }
}
