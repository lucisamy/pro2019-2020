/*
    Ej5:Visualiza los grados Fahrenheit que corresponden a los grados 
        centıgrados que recibas como dato de entrada.
 */
package pro3p1e5;

import java.util.Scanner;

/**
 *
 * @author Lucía
 */
public class Pro3p1e5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mostrar mensaje para pedir dato. JOptionPane
        javax.swing.JOptionPane.showMessageDialog(null, "Teclea temperatura en ºC");
        //guardaremos el dato y leeremos con clase Scanner y método nextLine()
        float gradosC = new Scanner(System.in).nextFloat();
        //Calcular Farenheits
        //float gradosF = (float) ((1.8*gradosC) + 32);
        float gradosF = (1.8f*gradosC) + 32;
        //salida de datos: mostramos resultado con JOptionPane
        javax.swing.JOptionPane.showMessageDialog(null, gradosC + "ºC son " + gradosF + "ºF");
    }
    
}
