/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Artista {
    //Atributos propios
    private String nombre;
    private LocalDate fechaNacimiento;
    
    //relación con Obra
    private ArrayList<Obra>listaObras;
    
    //relación con Película
    private ArrayList<Pelicula>listaPeliculas;
    
    //constructor

    public Artista() {
    }

    public Artista(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Obra> getListaObras() {
        return listaObras;
    }

    public void setListaObras(ArrayList<Obra> listaObras) {
        this.listaObras = listaObras;
    }
    public void setObra(Obra o){
        
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
    
}
