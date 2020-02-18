/*
    Ej9:El usuario nos va a proporcionar a traves del teclado el numero de 
        unidades que se vende de los distintos productos con los que trabaja
        una empresa. Esta empresa trabaja con 10 productos distintos cuyos
        codigos son: 10, 23, 30, 47, 55, 65,135,256, 526, 663. El usuario cada 
        vez que se realice una venta nos proporcionara el codigo del producto 
        (hay que comprobar que es valido) y el numero de unidades vendidas 
        de ese producto. Al final del dıa, es decir, cuando el usuario nos
        diga que no desea continuar, tenemos que visualizar el numero total 
        de unidades vendidas de cada producto y el codigo del producto, 
        ordenado de menor a mayor por numero de unidades vendidas.
 */
package pro4p1e9;

import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro4p1e9 {

    /**
     * @param args the command line arguments
     */
    //VARIABLES GLOBALES
    static boolean error=true;
    public static void main(String[] args) {
        //arrays
        int [] productos = {10,23,30,47,55,65,135,256,526,663};
        int [] totalUnidades = new int [10];
        do{
            int codProducto = pedirNumero("el código del producto");
            anotarUnidades(codProducto,productos,totalUnidades);
        }
        while(error|JOptionPane.showConfirmDialog(null, "quieres continuar?")==0);
        //ordenar por unidades vendidas
        ordenarPorUnidades(totalUnidades,productos);
        //mostrar Total Ventas
        mostrarTotalVentas(totalUnidades,productos);
        
    }
    public static int pedirNumero(String mensaje){
        int n=0;
        do{
            try{
                n = Integer.parseInt(JOptionPane.showInputDialog("Teclea " + mensaje));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=true; 
            }
        }
        while(error);
        return n;
    }
    public static void anotarUnidades(int codProducto,int[]productos,int[]totalUnidades){
        //validar producto: recorrer array buscando ese codigo, si está anotar unidades.
        try{
            int x;
            int unidades;
            for(x=0;x<productos.length&&productos[x]!=codProducto;x++){}
            if(x<productos.length)
            {    //encontró el producto
                unidades = pedirNumero("las unidades vendidas");
                totalUnidades[x]+=unidades;
            }
            else
                //no encontró el producto
                throw new ProductoErroneoException();
        }
        catch(ProductoErroneoException e){
            JOptionPane.showMessageDialog(null, "Producto no válido, No existe este producto");
            error=true;
        }
    }
    public static void ordenarPorUnidades(int [] totalUnidades,int [] productos){
        //   ordenado de menor a mayor por numero de unidades vendidas.
        //buscamos el mayor para ponerlo al final
        int mayor=0;
        for(int y=1;y<productos.length;y++){
            for(int x=1;x<totalUnidades.length;x++){
                if(totalUnidades[x]<totalUnidades[x-1]){
                    mayor = totalUnidades[x-1];
                    totalUnidades[x-1]=totalUnidades[x];
                    totalUnidades[x]= mayor;
                    mayor = productos[y-1];
                    productos[y-1]=productos[y];
                    productos[y]=mayor;
                }
            }
        }
    }
    public static void mostrarTotalVentas(int [] totalUnidades,int [] productos){
        String texto = "TOTAL VENTAS:\n";
        for(int x=0;x<productos.length;x++){
            texto+=productos[x]+": "+ totalUnidades[x] +"\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }
}
