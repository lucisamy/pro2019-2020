/*

 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Piloto {
    //atributos propios
    private String codigo;
    private String nombre;
    private String apellido;
    private Integer numLicencia;
    
    //relación con vuelo
    private ArrayList<Vuelo>vuelos;
    
    //constructor

    public Piloto(String codigo, String nombre, String apellido, Integer numLicencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numLicencia = numLicencia;
    }
    
    //getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(Integer numLicencia) {
        this.numLicencia = numLicencia;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    
    //Métodos
    public void agregarNuevo(){}
    public void asignarVuelo(){}
    public void cancelarVuelo(){}
    public void modificar(){}
    public Piloto buscar(){
        return this;
    }
    
}
