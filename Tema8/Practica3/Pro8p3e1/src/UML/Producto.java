/*
De cada producto nos interesa guardar su nombre, el nº de unidades disponibles
y el precio unitario.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Producto {
    String nombre;
    int unidades;
    float precioUnitario;
    //relación con proveedor
    ArrayList<Proveedor>listaProveedores;
    //relación con Clientes: voy guardando todos los clientes que compran este producto.
    ArrayList<Cliente>listaClientes;
    
    public Producto(String nombre, int unidades, float precioUnitario) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
    }

    public Producto(String nombre, int unidades, float precioUnitario, ArrayList<Proveedor> listaProveedores) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
        this.listaProveedores = listaProveedores;
    }
    
    public Producto(String nombre, int unidades, float precioUnitario, ArrayList<Proveedor> listaProveedores, ArrayList<Cliente> listaClientes) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
        this.listaProveedores = listaProveedores;
        this.listaClientes = listaClientes;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public ArrayList<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    
    
}
