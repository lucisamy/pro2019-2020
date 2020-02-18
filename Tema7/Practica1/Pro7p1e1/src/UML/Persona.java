/*
De cada persona queremos guardar su dni, nombre y apellidos, direccion´
completa y su numero de telefono. 
Una persona puede disponer de varios vehıculos. Un veh´ıculo pertenece
solo a una persona. 
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Persona {
    //variables propias
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    
    //de la relación
    private ArrayList<Vehiculo> vehículos;
    //constrcutor

    public Persona(String dni, String nombre, String apellidos, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona(String dni, String nombre, String apellidos, String direccion, String telefono, ArrayList<Vehiculo> vehículos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.vehículos = vehículos;
    }
    
    //getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Vehiculo> getVehículos() {
        return vehículos;
    }

    public void setVehículos(ArrayList<Vehiculo> vehículos) {
        this.vehículos = vehículos;
    }
    
    
}
