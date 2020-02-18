/*

 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Avion {
    //variables propias
    private String aerolinea;
    private String codigo;
    private int numAsientos;
    private String compartimentos;
    
    //relación con vuelo
    private ArrayList<Vuelo>vuelos;
    
    //constructor --> obtener()?

    public Avion(String aerolinea, String codigo, int numAsientos, String compartimentos) {
        this.aerolinea = aerolinea;
        this.codigo = codigo;
        this.numAsientos = numAsientos;
        this.compartimentos = compartimentos;
    }
    //getters y setters

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public String getCompartimentos() {
        return compartimentos;
    }

    public void setCompartimentos(String compartimentos) {
        this.compartimentos = compartimentos;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    //métodos
    public void asignarVuelo(){}
    public void cancelarVuelo(){}
    public Avion obtener(){
        return this;
    }
    
}
