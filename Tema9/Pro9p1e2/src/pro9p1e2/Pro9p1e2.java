/*
Desarrolla un proyecto que te permita guardar informacion sobre los 
acontecimientos o eventos organizados por una empresa.
De cada uno de ellos se quiere guardar el nombre, el lugar donde se
desarrollara, la fecha, la hora de inicio y la de fin, y el número de 
personas que pueden asistir. En cuanto al lugar, solo se trabaja con el 
Artium, el Buesa Arena, el Iradier Arena, Mendizorroza y el Teatro
Principal.
Este proyecto estara formado por una primera ventana con un menú y
una barra de herramientas. La opcion de guardar eventos es la primera 
de ellas
 */
package pro9p1e2;
import Modelo.BD.*;
import Modelo.UML.Evento;
import Vista.*;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author Lucía
 */
public class Pro9p1e2 {

    /**
     * @param args the command line arguments
     */
    //BASE DE DATOS
    static BDCon bd;
    static TEventos te;
    //VISTA
    static VPrincipal  vp;
    static VEventos ve;
    public static void main(String[] args) {
        //abrir la conexión con la base de datos
        bd = new BDCon();
        bd.conectar();
        //crear objeto tabla y pasar conexión
        te = new TEventos(bd.getCon());
        //inicializar primera ventana
        vp = new VPrincipal();
        vp.setVisible(true);
    }
    public static void mostrarVE(int n){
        ve = new VEventos(n);
        ve.setVisible(true);
    }
    public static boolean insertarBd(String nombre,String lugar,LocalDate fecha,LocalTime horaInicio,LocalTime horaFin,int aforo){
        //resto de validaciones: comprobar que no existe ya un evento con el mismo nombre haciendo una consulta a la BD
        Evento e = te.seleccionar(nombre);
        if (e!=null)
            return false; //le decimos a la ventana que ha habido un error y que no ha podido crearse el evento.
        else
            //crear y llenar objeto
            e = new Evento(nombre,lugar,fecha,horaInicio,horaFin,aforo);
            //hacemos el insert
            te.insertar(e);
            return true; //notificamos a la ventana que se ha insertado correctamente el evento.
    }
    public static java.sql.Date convertirFechaSQL(LocalDate fechaLocalDate){
        
        return null;
    }
    public static java.sql.Time convertirHoraSQL(LocalTime horaLocalTime){
        
        return null;
    }
    public static boolean buscarEvento(String nombre){
        //este método hace una búsqueda en la base de datos y devuelve true si el evento existe y false si no.
        Evento e = te.seleccionar(nombre);
        if (e!=null)
             return true; //el evento existe
        else
            return false; //el evento no existe
    }
    public static void eliminarEvento(String nombre){
        te.eliminar(nombre);
    }
}
