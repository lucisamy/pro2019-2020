/*
Los metodos mostrar() devuelven un string con todos los datos del ´
objeto correspondiente.
Muestra el nombre del directivo que mas subordinados tiene.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Persona {
    //VARIABLES PROPIAS
    private String nombre;
    private int edad;
    
    //Constructor
    public Persona() {
    }
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    //SETTERS Y GETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String mostrar(){
        return nombre + ", " + edad + " años";
        //return this.getNombre() + ", " + this.getEdad() + " años";
    }

    
    
}
