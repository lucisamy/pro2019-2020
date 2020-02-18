/*
En este ultimo ejercicio hay que codificar el modelo y crear los objetos ´
necesarios para guardar los datos de un vuelo.
 */
package pro6p2e4;

import UML.*;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pro6p2e4 {

    /**
     * @param args the command line arguments
     */
    //arrays y arraylists como variable global
    static ArrayList<Ciudad>listaCiudades=new ArrayList();
    static Avion[] listaAviones = new Avion [3];
    static Piloto[] listaPilotos = new Piloto [3];
    static ArrayList<Pasajero>listaPasajeros = new ArrayList();
    static ArrayList<Asiento>listaAsientos = new ArrayList();
    static ArrayList<Vuelo>vuelos=new ArrayList();
    
    public static void main(String[] args) {
        crearCiudades();
        crearAviones();
        crearPilotos();
        crearPasajeros();
        crearAsientos();
        relacionarPasajeroAsiento();
        crearVuelos();
    }
    public static void crearCiudades(){
        Ciudad ciudad = new Ciudad("1","Vitoria");
        listaCiudades.add(ciudad);
        ciudad = new Ciudad("2","Madrid");
        listaCiudades.add(ciudad);
        ciudad = new Ciudad("3","Bilabo");
        listaCiudades.add(ciudad);
    }    
    public static void crearAviones(){
        listaAviones[0] = new Avion("a1","01",300,"cccc");
        listaAviones[1] = new Avion("a1","02",250,"cccc");
        listaAviones[2] = new Avion("a2","03",500,"cccc");
    }
    public static void crearPilotos(){
        listaPilotos[0]= new Piloto("p1","pepe","martinez",12345);
        listaPilotos[1]= new Piloto("p2","juan","perez",12346);
        listaPilotos[2]= new Piloto("p3","daniel","torrez",54621);
    }
    public static void crearPasajeros(){
        Pasajero p = new Pasajero("7596425f","p1","aaaaaaa","hombre",25);
        listaPasajeros.add(p);
        p = new Pasajero("7894542g","p2","ddddddd","mujer",28);
        listaPasajeros.add(p);
        p = new Pasajero("7526482j","p3","ffffff","mujer",50);
        listaPasajeros.add(p);
    }
    public static void crearAsientos(){
        Asiento a = new Asiento(1,true,"cccc");
        listaAsientos.add(a);
        a = new Asiento(2,false,"dddddd");
        listaAsientos.add(a);
        a = new Asiento(3,true,"gggggggg");
        listaAsientos.add(a);
        a = new Asiento(4,true,"kkkkkk");
    }
    public static void relacionarPasajeroAsiento(){
        
    }
    public static void crearVuelos(){
        //vuelo solo con atributos propios. 
        //para colocar fecha primero creamos un formato
        
        Vuelo v = new Vuelo(12345,"12:00","08:00","madrid","roma");
        
    }
}
