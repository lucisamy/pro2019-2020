/*
Vamos a implementar un proyecto para contabilizar las compras y ventas
de los productos en un almacen.
De cada producto nos interesa guardar su nombre, el nº de unidades disponibles
y el precio unitario.

Los productos se compran a proveedores y se venden a clientes.
Vamos a suponer que los proveedores son siempre los mismos 
y que los conocemos de antemano, es decir, debemos inventarnos unos productos
con sus proveedores.

Cuando vendemos, el precio de venta se calcula como el doble de lo
que a nosotros nos ha costado. 
Tambien hay que tener en cuenta que a los clientes se les puede aplicar
un descuento por volumen (2 porciento) y/o por pronto pago (3 por ciento).

Cuando nos hagan clic en el boton cancelar, mostraremos un cuadro de dialogo
creado por nosotros preguntado al usuario que quiere hacer 
(Acabar la ejecucion, limpiar la pantalla o mostrar los datos de los productos,
proveedores y clientes).
 */
package pro8p3e1;

import UML.*;
import Vista.*;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pro8p3e1 {

    /**
     * @param args the command line arguments
     */
    //ArrayLists (Base de datos)
    static ArrayList<Producto>almacen;
    static ArrayList<Proveedor>proveedores;
    static ArrayList<Cliente>listaClientes;
    //Vista
    
    public static void main(String[] args) {
        generarProductos();
        VPrincipal vp = new VPrincipal();
        vp.setVisible(true);
    }
    public static void generarProductos(){
        almacen = new ArrayList();
        //arraylists propios del producto:
        ArrayList<Proveedor>provsDeProd = new ArrayList();
        //ArrayList<Cliente>clientesProductos = new ArrayList();
        
        //Producto 1
        //sus proveedores
        provsDeProd = new ArrayList();
        provsDeProd.add(new Proveedor("Proveedor 1"));
        
        almacen.add(new Producto("Manzanas",10,1,provsDeProd));
                
        //Producto 2
        //sus proveedores
        provsDeProd = new ArrayList();
        provsDeProd.add(new Proveedor("Proveedor 1"));
        provsDeProd.add(new Proveedor("Proveedor 2"));
 
        almacen.add(new Producto("Patatas",20,2.5f,provsDeProd));
        
        //Producto 3
        //sus proveedores
        provsDeProd = new ArrayList();
        provsDeProd.add(new Proveedor("Proveedor 2"));
        provsDeProd.add(new Proveedor("Proveedor 3"));
        almacen.add(new Producto("Naranjas",18,0.5f,provsDeProd));
        
        //Producto 4
        provsDeProd = new ArrayList();
        provsDeProd.add(new Proveedor("Proveedor 1"));
        provsDeProd.add(new Proveedor("Proveedor 3"));
        
        almacen.add(new Producto("Tomatas",30,0.7f,provsDeProd));
    }
    public static boolean comprobarProducto(String prod){
        int x;
        for(x=0;x<almacen.size()&&!almacen.get(x).getNombre().equalsIgnoreCase(prod);x++){}
        if(x<almacen.size()) // encontró el producto
            return true;
        else
            return false;
    }
    public static int comprobarStock(String prod){
        
    }
}
