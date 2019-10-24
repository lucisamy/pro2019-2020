/*
    Ej1: Escribe un programa que visualice por pantalla un mensaje introducido por teclado.
 */
package pro3p1e1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucía
 */
public class Pro3p1e1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            //salida con system.out.println
            System.out.println("Teclea un mensaje");
            //Entrada de datos con System.in
            /*
            int dato = System.in.read();
            char letra = (char)dato;
            
            char letra = (char) System.in.read();
            System.out.println(letra);
            */
            //Entrada de datos con la clase BufferedReader
            
            /*InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);*/
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // leemos con método readLine
            String mensaje = br.readLine();
            System.out.println(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Pro3p1e1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
