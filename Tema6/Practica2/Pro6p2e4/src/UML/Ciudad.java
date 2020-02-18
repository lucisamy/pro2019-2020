/*

 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Ciudad {
    //variables propias
    
    private String codigoCiudad;
    private String nombre;
    
    //relación con Vuelo
    private ArrayList<Vuelo>vuelos;
    
    //constructor : agregar_nuevo()???

    public Ciudad(String codigoCiudad, String nombre) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
    }
    
    //getters y setters

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    //métodos
    public void agregarNuevo(){}
    public Ciudad obtener(){
        return this; //que sentido tiene esto?
    }
}
