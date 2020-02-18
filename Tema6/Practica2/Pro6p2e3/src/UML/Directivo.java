/*
Los metodos mostrar() devuelven un string con todos los datos del ´
objeto correspondiente.
Muestra el nombre del directivo que mas subordinados tiene.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Directivo extends Empleado{
    //ATRIBUTOS PROPIOS
    private String categoria;
    
    //RELACION CON EMPLEADO
    private ArrayList<Empleado>subordinados;
    
    //CONSTRUCTOR

    public Directivo(String categoria, float sueldoBruto, String nombre, int edad) {
        super(sueldoBruto, nombre, edad);
        this.categoria = categoria;
    }

    public Directivo(String categoria, ArrayList<Empleado> subordinados, float sueldoBruto, String nombre, int edad) {
        super(sueldoBruto, nombre, edad);
        this.categoria = categoria;
        this.subordinados = subordinados;
    }
    
    
    //GETTERS Y SETTERS

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Empleado> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(ArrayList<Empleado> subordinados) {
        this.subordinados = subordinados;
    }
    
    //MÉTODOS
    public void setSubordinado(Empleado e){
        subordinados.add(e);
    }
    
    @Override
    public String mostrar(){
        return this.getNombre() + ", " + this.getEdad() + " años, sueldo bruto: " + this.getSueldoBruto() + ", categoria: " + categoria;
        //podriamos añadir repetitiva para mostrar datos de todos los subordinados
    }
    
}
