/*
Ej18: Diseñar un programa que calcule el n-esimo termino de la serie de
    Fibonacci. La sucesion comienza con los números 1 y 1, y a partir de
    estos, cada termino es la suma de los dos anteriores. 
    (1, 1, 2, 3, 5,8,13, 21,34, 55, 89, 144, 233, 377,...)

 */
package pro3p1e18;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e18 {

    //variables globales, las usa la función principal y las actualiza la función avanzarSerie.
    
    public static int n1=1,n2=1,n=2;
    public static String serie;
    
    public static void main(String[] args) {
        int c=3,total;
        serie = n1 + " " + n2 + " " + n;
        //para empezar se obliga al usuario a decir que quiere mas de 3 números de la serie. 
        do
        {
            total = Integer.parseInt(JOptionPane.showInputDialog("Teclea cuántos números de la serie Fibonacci quieres mostrar?"));
            if(total<=3)
                JOptionPane.showMessageDialog(null, "Para generar la serie Fibonacci se necesitan mas de 3 números");
        }
        while(total<=3);
        for(c=3;c<total;c++)
        {
            avanzarSerie();
        }
        JOptionPane.showMessageDialog(null, "la serie de Fibonnaci es la sgte: " + serie);
    }
    public static void avanzarSerie(){
        n1=n2;
        n2=n;
        n=n1+n2;
        serie = serie + " " + n;
    }
}
