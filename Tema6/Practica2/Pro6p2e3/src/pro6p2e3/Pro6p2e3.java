/*
EJ3:Los metodos mostrar() devuelven un string con todos los datos del ´
    objeto correspondiente.
    Muestra el nombre del directivo que mas subordinados tiene.
 */
package pro6p2e3;

import UML.*;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pro6p2e3 {

    /**
     * @param args the command line arguments
     */
    //ARRAYLISTS COMO VARIABLE GLOBAL
    static ArrayList<Directivo>directivos;
    static ArrayList<Empleado>empleados;
    
    public static void main(String[] args) {
        //primero nos inventamos datos o los pedimos como dato de entrada para inicializar todas las clases necesarias que nos piden.
        crearDirectivos();
        crearEmpleados();
        asignarSubordinados();
        mostrarDirectivo();
    }
    public static void crearDirectivos(){
        Directivo directivo = new Directivo("cat1",1000,"directivo1",30);
        directivos.add(directivo);
        directivo = new Directivo("cat2",1000,"directivo2",50);
        directivos.add(directivo);
        directivo = new Directivo("cat3",1100,"directivo3",45);
        directivos.add(directivo);
    }
    public static void crearEmpleados(){
        Empleado emp = new Empleado(1000,"emp1",25);
        empleados.add(emp);
        emp = new Empleado (950,"emp2",28);
        empleados.add(emp);
        //los directivos tambien son empleados
        //añadir un arraylist a otro
        empleados.addAll(directivos);
    }
    public static void asignarSubordinados(){
        //subordinados del directivo1: emp1 y emp2
        directivos.get(0).setSubordinado(empleados.get(0));
        directivos.get(0).setSubordinado(empleados.get(1));
        //subordinados del directivo 2: emp1
        directivos.get(1).setSubordinado(empleados.get(0));
        //y si no tuviera subordinados este directivo??
        //Subordinados del directivo3: emp1,emp2,dir1,dir2
        directivos.get(2).setSubordinado(empleados.get(0));
        directivos.get(2).setSubordinado(empleados.get(1));
        directivos.get(2).setSubordinado(empleados.get(2));
        directivos.get(2).setSubordinado(empleados.get(3));
    }
    public static void mostrarDirectivo(){
        //para saber el directivo con mas subordinados debo revisar a todos los directivos su arrayist de subordinados y comparar tamaño con un maximo.
        int maximo = 0;
        for(int x=0;x<directivos.size();x++){
            if(directivos.get(x).getSubordinados().size()>maximo)
                
        }
    }
}
