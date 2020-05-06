/*
De cada uno de ellos se quiere guardar el nombre, el lugar donde se
desarrollara, la fecha, la hora de inicio y la de fin, y el número de 
personas que pueden asistir. En cuanto al lugar, solo se trabaja con el 
Artium, el Buesa Arena, el Iradier Arena, Mendizorroza y el Teatro
Principal.
 */
package Modelo.UML;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Evento {
    String nombre;
    String lugar;
    LocalDate fecha;
    LocalTime horaInicio;
    LocalTime horaFin;
    int aforo;

    //de la relación con Persona
    ArrayList<Persona>listaAsistentes;
    public Evento() {
    }

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int aforo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aforo = aforo;
        this.listaAsistentes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public ArrayList<Persona> getListaAsistentes() {
        return listaAsistentes;
    }

    public void setListaAsistentes(ArrayList<Persona> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }
    
    public void setAsistente(Persona p){
        listaAsistentes.add(p);
    }
    
}
