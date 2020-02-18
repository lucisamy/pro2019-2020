/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pelicula {
    
    //VARIABLES PROPIAS
    private String titulo;
    private char[] año;
    private float duracion;
    private String tipo;
    
    //RELACION CON ESTUDIO
    private ArrayList<Estudio>listaEstudios;
    
    //CONSTRUCTORES
    public Pelicula() {
    }
    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public Pelicula(String titulo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.listaEstudios = listaEstudios;
    }
    
    public Pelicula(String titulo, char[] año, float duracion, String tipo, ArrayList<Estudio> listaEstudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        this.listaEstudios = listaEstudios;
    }
    
    //GETTERS Y SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public char[] getAño() {
        return año;
    }

    public void setAño(char[] año) {
        this.año = año;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    public void setListaEstudios(ArrayList<Estudio> listaEstudios) {
        this.listaEstudios = listaEstudios;
    }

    //MÉTODOS
    public void modificaPelicula(){}
    public void despliegaPelicula(){}
    public void eliminaPelicula(){}
  
}
