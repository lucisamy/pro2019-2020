/*

 */
package UML;

/**
 *
 * @author Lucía
 */
public class Asiento {
    //atributos propios
    private int numero;
    private Boolean estado;
    private String compartimento;
    
    //relación con Vuelo
    private Vuelo vuelo;
    //relación con Pasajero
    private Pasajero pasajero;

    //constructor
    public Asiento(int numero, Boolean estado, String compartimento) {
        this.numero = numero;
        this.estado = estado;
        this.compartimento = compartimento;
    }
    
    //getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(String compartimento) {
        this.compartimento = compartimento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    //Métodos
    public void reservar(){}
    public void comprar(){}
    public boolean mostrarDisponibilidad(){
        return true;
    }
    public void desbloquear(){}
    
}
