/*

 */
package UML;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Vuelo {
    //atributos propios
    private int numVuelo;
    private  String horaSalida;
    private String horaLlegada;
    private String lugarOrigen;
    private String lugarDestino;
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private String tipo;
    //relacion con ciudad
    private Ciudad ciudad;
    //relacion con avión
    private Avion avion;
    //relación con piloto
    private Piloto piloto;
    //relación con asiento
    private ArrayList<Asiento>asientos;
    //relación con pasajero
    private ArrayList<Pasajero>pasajeros;
    
    //constructor con los atributos propios
    public Vuelo(int numVuelo, String horaSalida, String horaLlegada, String lugarDestino, LocalDate fechaSalida, LocalDate fechaRegreso, String tipo) {
        this.numVuelo = numVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.lugarDestino = lugarDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.tipo = tipo;
    }
    //constructor con todos los atributos

    public Vuelo(int numVuelo, String horaSalida, String horaLlegada, String lugarOrigen, String lugarDestino, LocalDate fechaSalida, LocalDate fechaRegreso, String tipo, Ciudad ciudad, Avion avion, Piloto piloto, ArrayList<Asiento> asientos, ArrayList<Pasajero> pasajeros) {
        this.numVuelo = numVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.lugarOrigen = lugarOrigen;
        this.lugarDestino = lugarDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.avion = avion;
        this.piloto = piloto;
        this.asientos = asientos;
        this.pasajeros = pasajeros;
    }
    
    
    //getters y setters
    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(LocalDate fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }
    //métodos
    public void rezervar(){}
    public void modificar(){}
    public void eliminar(){}
    public Vuelo buscar(){
        return this;
    }
}
