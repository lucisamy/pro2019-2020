/*
EJ9:Desarrolla un proyecto que te permita visualizar las facturas que los
    clientes tienen que pagar por comprar en un almacen unos productos. 
    
    Como datos de entrada tendremos que solicitar el nombre del cliente y
    por cada uno de los productos que adquiera, cantidad, precio unitario
    y porcentaje de IVA que se le aplica (Normal 21 %, reducido 10 % y
    supereducido 4 %)
    Con estos datos nuestro proyecto visualizará en un cuadro de diálogo
    la factura que el cliente debe abonar.
    
    Ejemplo para un cliente:
    Pepe Rodriguez
    3 unidades a un precio de 100 euros 4 % de iva
    2 unidades a un precio de 50.5 euros 4 % de iva
    5 unidades a un precio de 20 euros 10 % de iva.
    
    Factura que debemos visualizar:
    NOMBRE: Pepe Rodriguez
    LINEAS DE DETALLE:
    3 x 100 = 300
    2 x 50.5 = 101
    5 x 20 = 100
    TOTAL SIN IVA 501
    4 % de 401 = 16.04
    10 % de 100 = 10
    TOTAL IVA 26.04
    TOTAL CON IVA 527.04

 */
package pro3p3e9;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e9 {

    /**
     * @param args the command line arguments
     */
    
    //VARIABLES GLOBALES:
    //para las repetitivas de las validaciones usaremos en todas las funciones la variable booleana error
    static boolean error;
    //datos del producto que usaremos en distintas funciones
    static int unidades=0,iva;
    static double precio=0;
    
    public static void main(String[] args) {
        //se piden y se validan los Datos de entrada
        datosEntrada();
        
    }
    public static void datosEntrada(){
        try{
            pedirNombre();
            //String lineaDetalle = "LINEAS DE DETALLE:\n"; esto se agregará en el superString final
            String lineaDetalle="";
            int respuesta;
            do{
                pedirProducto(); 
                //guardar info producto
                double total = calcularTotal();
                lineaDetalle = lineaDetalle + unidades + " x " + precio + " = " + total + "\n";
                int totalSinIVA = 0;
                totalSinIVA += total;
                respuesta = JOptionPane.showConfirmDialog(null, " más productos?");
            }
            while(respuesta==0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas");
        }
        
    }
    public static void pedirNombre()throws Exception{
        do{
            try{
                String nombre = JOptionPane.showInputDialog("Escribe nombre del cliente");
                if(nombre.isEmpty())
                    throw new CampoVacioException();
                else
                    //recorremos la cadena en busca de números
                    for(int x=0;nombre.charAt(x)<nombre.length()-1;x++){
                        if(!Character.isLetter(nombre.charAt(x))&& nombre.charAt(x)!= ' ' && nombre.charAt(x)!= '´')
                            throw new NombreNoValidoException();
                    }
                error=false;
            }
            catch(CampoVacioException e){
                JOptionPane.showMessageDialog(null, "No puedes dejar este campo vacío.");
                error=true;
            }
            catch(NombreNoValidoException e){
                JOptionPane.showMessageDialog(null, "este campo no puede contener números, ni carácteres extraños exceptuando el espacio y el acento");
                error=true;
            }
        }
        while(error==true);
    }
    public static void pedirProducto(){
        //se pedirá unidades,precio e iva del producto y se validarán.
        //se usan los mismos catch para los 3 datos
        
        for(int c=0;c<3;c++){
            do{
                try{
                    switch(c){
                        case 0://UNIDADES
                            unidades = Integer.parseInt(JOptionPane.showInputDialog("Teclee unidades del producto"));
                            //
                            error=false; 
                            break;
                        case 1://PRECIO
                            precio = Double.parseDouble(JOptionPane.showInputDialog("Teclee unidades del producto"));
                            error=false;  
                        case 2://IVA
                            iva = Integer.parseInt(JOptionPane.showInputDialog("Teclee iva del producto."));
                            error=false;
                    }
                }
                catch(NullPointerException e){
                    JOptionPane.showMessageDialog(null, "No puedes dejar este campo vacío.");
                    error=true;
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Sólo se pueden escribir números");
                    error=true;
                }
            }
            while(error==true);
        }
    }
    public static double calcularTotal(){
        double total = precio * unidades;
        return total;
    }
}