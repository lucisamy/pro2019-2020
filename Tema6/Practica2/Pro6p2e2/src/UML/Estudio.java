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
public class Estudio {
    
    //VARIABLES PROPIAS
    private String nombre;
    private String ciudad;
    private String direccion;
    private String dirWeb;
    private LocalDate fechaFundacion;
    private String pais;
    private String[] telefonos;
    
    //RELACIÓN CON PELÍCULA
    private ArrayList<Pelicula>listaPeliculas;
    
    //CONSTRUCTOR
    public Estudio() {
    }

    public Estudio(String nombre) {
        this.nombre = nombre;
    }

    public Estudio(String nombre, String ciudad, String direccion, String dirWeb, LocalDate fechaFundacion, String pais, String[] telefonos, ArrayList<Pelicula> listaPeliculas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dirWeb = dirWeb;
        this.fechaFundacion = fechaFundacion;
        this.pais = pais;
        this.telefonos = telefonos;
        this.listaPeliculas = listaPeliculas;
    }
    
    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
    
    //MÉTODOS
    public void modificaEstudio(){}
    public void cierraEstudio(){}
    //public Estudio despliegaEstudio(){}
    

   
    
}
