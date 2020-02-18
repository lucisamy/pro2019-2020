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
public class Empresa {
    //ATRIBUTOS PROPIOS
    private String nombre;
    
    //RELACIONES CON EMPLEADOS Y CLIENTES
    private ArrayList<Empleado> empleados;
    private ArrayList<Cliente> clientes;
    
    //CONSTRUCTOR

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public Empresa(String nombre, ArrayList<Empleado> empleados, ArrayList<Cliente> clientes) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.clientes = clientes;
    }
    
    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    //MÉTODOS
    public void setEmpleado(Empleado e){
        empleados.add(e);
    }
    public Empleado getEmpleado(int x){
        return empleados.get(x);
    }
    public void setCliente(Cliente c){
        clientes.add(c);
    }
    public Cliente getCliente(int x){
        return clientes.get(x);
    }
}
