/*
    ej2:Escribe un programa que muestre el resultado de multiplicar dos
    numeros introducidos por teclado. 
 */
package pro3p1e2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucía
 */
public class Pro3p1e2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Mensaje de salida para pedir el dato
            System.out.println("Teclea un número");
            //Recogemos con BufferedReader y leemos.
            String dato1 =new BufferedReader(new InputStreamReader(System.in)).readLine();
            //Conversión a número
            int n1 = Integer.parseInt(dato1);
            //Repetimos para segundo número
            System.out.println("Teclea un número");
            String dato2 =new BufferedReader(new InputStreamReader(System.in)).readLine();
            int n2 = Integer.parseInt(dato2);
            int resultado = n1+n2;
            System.out.println("el resultado es " + resultado);
                    
        } catch (IOException ex) {
            Logger.getLogger(Pro3p1e2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
