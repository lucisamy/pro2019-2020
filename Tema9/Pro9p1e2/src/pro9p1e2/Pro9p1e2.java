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
import Vista.*;
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
    public static void mostrarVE(){
        ve = new VEventos();
        ve.setVisible(true);
    }
    public static void insertarBd(Srting nombre,){
        
    }
}
