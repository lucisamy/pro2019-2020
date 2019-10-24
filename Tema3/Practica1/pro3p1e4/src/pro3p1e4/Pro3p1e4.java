/*
    ej4:Pide que te introduzcan por teclado los valores de las diagonales de
        un rombo. Calcula y muestra su area ( ´ area ´ = D * d /2)

 */
package pro3p1e4;

import java.util.Scanner;

/**
 *
 * @author Lucía
 */
public class Pro3p1e4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //mostramos mensaje para pedir dato
        System.out.println("Teclea primera diagonal del rombo");
        //guardamos y leemos con clase Scanner
        String dato1 = new Scanner(System.in).nextLine();
        //Convertimos en número
        float d1 = Float.parseFloat(dato1);
        //Repetimos para obtener segunda diagonal
        System.out.println("Teclea segunda diagonal del rombo");
        float d2 = Float.parseFloat(new Scanner(System.in).nextLine());
        //Calculamos área
        float area = (d1*d2)/2;
        //mostramos resultado
        System.out.println("El área del rombo es " + area);
    }
    
}
