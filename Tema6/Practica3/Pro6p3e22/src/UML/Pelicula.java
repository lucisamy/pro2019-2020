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
public class Pelicula extends Obra{
    
    //atributos propios
    private String productora;
    private int duracion;
    
    //constructor

    public Pelicula() {
    }

    public Pelicula(String productora, int duracion) {
        this.productora = productora;
        this.duracion = duracion;
    }

    public Pelicula(String productora, int duracion, String titulo, int anoEdicion) {
        super(titulo, anoEdicion);
        this.productora = productora;
        this.duracion = duracion;
    }
    
    //getters y setters

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
    
    
}
