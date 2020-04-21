/*
Nuestro primer ejercicio sera una aplicación básica (sin validaciones) 
en la que nos conectaremos a una base de datos donde tendremos
una unica tabla para guardar los datos de un conjunto de personas y 
mediante nuestro proyecto vamos a acceder a ella para poder dar de
alta y consultar datos. En la aplicacion tendremos un especie de menú
principal con estas opciones.
 */
package pro9p1e1;

import Modelo.BD.*;
import UML.Persona;
import Vista.*;

/**
 *
 * @author Lucía
 */
public class Pro9p1e1 {

    /**
     * @param args the command line arguments
     */
    //Base de datos
    static BaseDeDatos bd;
    static TablaPersonas tp;
    
    //Vista
    static VPrincipal vmenu;
    static VPersonas vp;
    
    static Persona p;
    
    public static void main(String[] args) {
        //Abrimos conexión con base de datos
        bd = new BaseDeDatos();
        bd.conectar();
        //le paso a la tabla personas la conexión a usar
        tp = new TablaPersonas(bd.getCon());
        
        //Mostrar Ventana principal
        vmenu = new VPrincipal();
        vmenu.setVisible(true);  
    }
    public static void registrarPersona(){
        mostrarVp(1);
    }
    public static void mostrarVp(int n){
        vmenu.setVisible(false);
        vp = new VPersonas(n);
        vp.setVisible(true);   
    }
    public static void insertarP(String nombre,int edad,String prof,String tel){
        p = new Persona(nombre,edad,prof,tel);
        tp.insertarPersona(p);
    }
}
