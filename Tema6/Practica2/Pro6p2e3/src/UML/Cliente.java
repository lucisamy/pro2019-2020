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
public class Cliente extends Persona{
    //ATRIBUTOS PROPIOS
    private String telefono;
    
    //CONSTRUCTOR

    public Cliente(String telefono, String nombre, int edad) {
        super(nombre, edad);
        this.telefono = telefono;
    }
    //GETTERS Y SETTERS

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //MÉTODOS
    
    @Override
    public String mostrar(){
        return this.getNombre() + ", " + this.getEdad() + "años, tel: " + telefono;
    }
}
