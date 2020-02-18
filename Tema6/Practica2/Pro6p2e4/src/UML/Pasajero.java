/*

 */
package UML;

/**
 *
 * @author Lucía
 */
public class Pasajero {
    //atributos propios
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    
    //relación con Vuelo
    private Vuelo vuelo;
    //relación con asiento
    private Asiento asiento;
    
    //constructor
    public Pasajero(String cedula, String nombre, String apellido, String sexo, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
    }
    
    //getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    //Métodos
    public void agregarNuevo(){}
    public void modififcar(){}
    public void asignarVuelo(){}
    public Pasajero buscar(){
        return this;
    }
    
}
