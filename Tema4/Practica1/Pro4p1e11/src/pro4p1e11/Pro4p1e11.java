/*
Ej11:. Nos piden que implementemos el software para una maquina expendedora
        de golosinas. Cada golosina tiene un nombre y un precio.
        Tambien tendrán una cantidad inicial que en principio será de 5.
        Tendremos un pequeño menú con las siguientes opciones: 
        - Pedir golosina: 
            Pedirá la posición de la golosina que quiera.
            Esta máquina tiene golosinas en cada posición, identificados por su 
            fila y columna, que será lo que introduzca el usuario al pedir una 
            golosina, por ejemplo si el usuario teclea 20 significa que esta
            pidiendo la golosina que esta en la fila 2 columna 0.
            Cuando no haya mas golosinas se le indicará al usuario.
            Solo puede pedir una golosina.
        - Mostrar golosinas: 
            Mostrará todas las golosinas disponibles. 
            Mostrará el código que debe introducir el usuario, el nombre 
            y el precio. La cantidad disponible no se mostrará.
        - Rellenar golosinas: 
            Esta es una función exclusiva de un técnico por lo que nos pedirá
            una contraseña, si el usuario escribe "MaquinaExpendedora2019" 
            le pedirá la posición de la golosina y la cantidad.
        - Apagar máquina:
            Sale del programa. Antes de salir mostrara las ventas totales 
            durante la ejecucion del programa.
 */
package pro4p1e11;

import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro4p1e11 {

    /**
     * @param args the command line arguments
     */
    //GLOBALES
    static int fila;
    static int columna;
    //arrays
    static String [][] golosinas = new String [5][4];
    static Double [][] precios = new Double [5][4];
    static int [][] cantidades = new int [5][4];
    public static void main(String[] args) {
        
        inicializarArrays();
        llenarGolosinas();
        llenarPrecios();
        llenarCantidades();
        int opc;
        try{
            do{
                opc = mostrarMenu();
                switch(opc){
                    case 1: pedirGolosina();
                        break;
                    case 2: mostrarGolosinas();
                        break;
                    case 3: rellenarGolosinas();
                        break;
                }
            }
            while(opc!=4);
            mostrarVentasTotales();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());        
        }
    }
    public static int mostrarMenu()throws Exception{
        boolean error;
        int n=0;
        do{
            try{
                n = Integer.parseInt(JOptionPane.showInputDialog("Menú: Elige una opción: \n"
                                                    + "1. Pedir Golosina \n"
                                                    + "2. Mostrar golosinas \n" 
                                                    + "3. Rellenar golosinas \n"
                                                    + "4. Apagar máquina"));
                if(n<1|n>4){
                    throw new OpcionInvalidaException();
                }
                error=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debes escribir un valor numérico");
                error=true;
            }
            catch(OpcionInvalidaException e){
                JOptionPane.showMessageDialog(null, "Opción inválida. Debes elegir entre 1 y 4");
                error=true;
            }
        }
        while(error);
        return n;
    }
    public static void inicializarArrays(){
        golosinas[0][0]="kitkat";
        golosinas[0][1]="chicle";
        golosinas[0][2]="chupa chup";
        golosinas[0][3]="baton";
        golosinas[1][0]="chocolate";
        golosinas[1][1]="kinder bueno";
        golosinas[1][2]="pringles";
        golosinas[1][3]="lays";
        
    }
    public static void pedirGolosina(){
        boolean error;
        do{
            try{
                pedirPosicion();
                if(cantidades[fila][columna]!=0){
                    pedirImporte();
                    JOptionPane.showMessageDialog(null, "Recoger producto");
                    cantidades[fila][columna]--;
                    error=false;
                }
                else
                    throw new ProductoAgotadoException();
            }
            catch(ProductoAgotadoException e){
                JOptionPane.showMessageDialog(null, "Este producto está agotado. No quedan unidades");
                error=true;
            }
        }
        while(error);
        
    }
    public static void pedirPosicion(){
        boolean error;
        do{
            try{
                String pos = JOptionPane.showInputDialog("teclear codigo producto");
                if(pos.isEmpty())
                    throw new CampoVacioException();
                int x;
                for(x=0;x<pos.length()&&Character.isDigit(pos.charAt(x));x++){}
                if(x<pos.length()|pos.length()!=2)//encuentra caracter no numérico o no son 2 caracteres devuelve error
                   throw new CodProductoInvalidoException();
                else{
                    //dato de entrada numerico de 2 cifras. comprobar que el codigo existe.
                    //convertir cada caracter a numero
                    fila = (int)pos.charAt(0);
                    columna = (int)pos.charAt(1);
                    //para ello debo comprobar las filas y columnas del array (cualquiera de los 3)
                    if(fila>=golosinas.length|columna>=golosinas[fila].length)
                        throw new CodProductoInvalidoException();
                    error=false;
                }
            }
            catch(CampoVacioException e){
                error=true;
            }
            catch(CodProductoInvalidoException e){
                JOptionPane.showMessageDialog(null, "Codigo de producto no válido");
                error=true;
            }
        }
        while(error);
        
    }
    public static void pedirImporte(){
        boolean error;
        do{
            try{
                double importe = Double.parseDouble(JOptionPane.showInputDialog("Introduzca importe: \n" 
                                                                         + fila + columna + " - " + golosinas[fila][columna] + "\n"
                                                                         + precios[fila][columna]));
                if(importe<precios[fila][columna])
                    throw new ImporteInsuficienteException();
                if(importe>precios[fila][columna])
                    calcularVuelta();
                error=false;
            }
            catch(ImporteInsuficienteException e){
                JOptionPane.showMessageDialog(null, precios[fila][columna] +"\n" + );
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=true;
            }
        }
        while(error);
        
    }
    public static void calcularVuelta(){
        
    }
    public static void mostrarGolosinas(){
        
    }
    public static void rellenarGolosinas(){
        
    }
    public static void mostrarVentasTotales(){
        
    }
}
