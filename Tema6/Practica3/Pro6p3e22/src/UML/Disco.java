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
public class Disco extends Obra{
    //atributos propios
    private String discografica;
    private String numeroCanciones;
    
    //constructor

    public Disco() {
    }

    public Disco(String discografica, String numeroCanciones) {
        this.discografica = discografica;
        this.numeroCanciones = numeroCanciones;
    }

    public Disco(String discografica, String numeroCanciones, String titulo, int anoEdicion) {
        super(titulo, anoEdicion);
        this.discografica = discografica;
        this.numeroCanciones = numeroCanciones;
    }
    
    //getters y setters

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(String numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public ArrayList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
    
}
