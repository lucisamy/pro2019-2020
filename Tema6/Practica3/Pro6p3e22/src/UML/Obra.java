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
public class Obra {
    //Atributos propios
    private String titulo;
    private int anoEdicion;
    
    //relacion con artista
    ArrayList<Artista>listaArtistas=new ArrayList();
    
    //constructor

    public Obra() {
    }

    public Obra(String titulo, int anoEdicion) {
        this.titulo = titulo;
        this.anoEdicion = anoEdicion;
    }
    
    //getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoEdicion() {
        return anoEdicion;
    }

    public void setAnoEdicion(int anoEdicion) {
        this.anoEdicion = anoEdicion;
    }

    public ArrayList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
    public void setArtista(Artista a){
        listaArtistas.add(a);
    }

}
