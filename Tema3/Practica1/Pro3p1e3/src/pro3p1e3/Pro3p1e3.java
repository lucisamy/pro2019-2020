/*
    ej3: Introduce por teclado los valores correspondientes a la base y la altura
        de un rectangulo e imprime su perímetro (2 x base + 2 x altura).
 */
package pro3p1e3;

import java.util.Scanner;

/**
 *
 * @author Lucía
 */
public class Pro3p1e3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //mostrar mensaje para pedir datos de entrada
        System.out.println("Teclea base del rectángulo");
        //entrada de datos con clase Scanner
        Scanner sc;
        sc = new Scanner(System.in);
        //lectura con el método nextLine
        String dato1 = sc.nextLine();
        //Convertimos en float
        float base = Float.parseFloat(dato1);
        //Repetimos con segundo dato:
        System.out.println("Teclea altura del rectángulo");
        Scanner sc2 = new Scanner(System.in);
        Float altura = Float.parseFloat(sc2.nextLine());
        //Calculamos perímetro
        Float perimetro = 2*base + 2*altura;
        //mostrar resultado2
        System.out.println("el perimetro del rectángulo es " + perimetro);
    }
    
}
