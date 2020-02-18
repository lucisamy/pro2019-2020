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
public class Libro extends Obra{
    //atributos propios
    private String editorial;
    private int numeroPaginas;
    
    //constructor

    public Libro() {
    }

    public Libro(String editorial, int numeroPaginas) {
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro(String editorial, int numeroPaginas, String titulo, int anoEdicion) {
        super(titulo, anoEdicion);
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
    }

    
    
    //getters y setters

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public ArrayList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(ArrayList<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
    @Override
    public String toString(){
        return "Título: " + this.getTitulo() +"\n" +
               "Año de Edición: " + this.getAnoEdicion() + "\n" +
               "Editorial: " + this.getEditorial() + "\n" +
               "Número de Páginas: " + this.getNumeroPaginas();
    }
    
   
}
