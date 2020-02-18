/*
Ej10: Crea una matriz de cuatro filas y cuatro columnas de numeros enteros que 
        inicialmente está vacía, nos piden hacer un menu con estas opciones:
        - Rellenar toda la matriz de numeros, debes pedırselos al usuario.
        - Suma de una fila que se pedira al usuario 
            (controlar que elija una correcta).
        - Suma de una columna que se pedira al usuario 
            (controlar que elija una correcta).
        - Sumar la diagonal principal
        - Sumar la diagonal inversa
        - La media de todos los valores de la matriz.
        - Salir.
        Hasta que no se haga la primera opcion, el resto de opciones no se 
        deberán de ejecutar, simplemente mostrar un mensaje donde diga que
        deben rellenar la matriz.
*/
package pro4p1e10;

import javax.swing.JOptionPane;
import Excepciones.*;
/**
 *
 * @author Lucía
 */
public class Pro4p1e10 {

    /**
     * @param args the command line arguments
     */
    //VARIABLES GLOBALES
    //array de dos dimensiones.
    static int [][] matriz = new int[4][4]; //lo usaremos en muchos métodos distintos.
    public static void main(String[] args) {
        boolean error;
        int opc;
        do{
            try{
                opc = mostrarMenu();
                if(opc!=1)
                    throw new RellenarMatrizException();
                rellenarMatriz();  
                error=false;
                do{
                    try{
                        opc = mostrarMenu();
                        switch(opc){
                            case 2: sumarFila();
                                break;
                            case 3: sumarColumna();
                                break;
                            case 4: diagonalPrincipal();
                                break;
                            case 5: diagonalInversa();
                                break;
                            case 6: mediaMatriz();
                                break;
                            case 7: System.exit(0);
                                break;
                            default:
                                throw new OpcionNoValidaException();
                        }
                        error=false;
                    }
                    catch(OpcionNoValidaException e){
                        if(opc!=1)
                        JOptionPane.showMessageDialog(null, "Opción escogida no válida, escribe un número entre 1-7 ");
                        else
                        JOptionPane.showMessageDialog(null, "Opcion escogida no válida. La matriz ya ha sido rellenada. elige entre 2-7");
                        error=true;
                    }
                }
                while(error&&opc!=7);
            }
            catch(RellenarMatrizException e){
                JOptionPane.showMessageDialog(null, "Es necesario rellenar la matriz primero");
                error=true;
            }
        }
        while(error);
    }
    public static int mostrarMenu(){
        boolean error;
        int opc=0;
        do{
            try{
                opc=Integer.parseInt(JOptionPane.showInputDialog("Menu: elige una opcion \n" +
                                                                    "1. Rellenar matriz \n" +
                                                                    "2. Sumar una fila \n" +
                                                                    "3. Sumar una columna \n"+
                                                                    "4. Sumar la diagonal principal \n"+
                                                                    "5. Sumar la diagonal inversa \n" +
                                                                    "6. Obtener media de la matriz \n"+
                                                                    "7.Salir"));

            error=false;    
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Para elegir una opción debes teclear un número");
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=false;
            }
        }
        while(error);
        return opc;
    }
    public static void rellenarMatriz(){
        for(int x=0;x<matriz.length;x++){
            for(int y =0;y<matriz.length;y++){
                matriz[x][y]=pedirNumero();
            }
        }
        JOptionPane.showMessageDialog(null, "La matriz ha sido rellenada.");
    }
    public static int pedirNumero(){
       boolean error;
       int n=0; 
       do{ 
            try{
                n = Integer.parseInt(JOptionPane.showInputDialog("Teclea un número"));
                error=false;
            }
            catch(NumberFormatException e){
                error=true;
            }
       }
       while(error);
        return n;
    }
}
