/*
Ej18: Diseñar un programa que calcule el n-esimo termino de la serie de
    Fibonacci. La sucesion comienza con los números 1 y 1, y a partir de
    estos, cada termino es la suma de los dos anteriores. 
    (1, 1, 2, 3, 5,8,13, 21,34, 55, 89, 144, 233, 377,...)

 */
package pro3p1e18v2;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e18v2 {

    /**
     * @param args the command line arguments
     */
    
    //variables globales, las usa la función principal y las actualiza la función avanzarSerie.
    
    public static int n1=1,n2=1,n=2;
    public static String serie;
    
    public static void main(String[] args) {
        
//Otra opcion: hacer un switch e incluir mostrar la serie de fibonacci con 1, 2, 3 o mas valores.
        int c=3,total;
        //validariamos para obligar a que sea un numero entero mayor que 0
        do
        {
            total = Integer.parseInt(JOptionPane.showInputDialog("Teclea cuántos números de la serie Fibonacci quieres mostrar?"));
            if(total<1)
                JOptionPane.showMessageDialog(null, "Porfavor escribe un número mayor que 0");
        }
        while(total<1);
        switch(total)
        {
            case 1: 
                serie = ""+ n1;
                break;
            case 2:
                serie = n1 + " " + n2;
                break;
            default:
                serie= n1 + " " + n2 + " " + n;
                for(c=3;c<total;c++) //si el total es 3 no entrará en el for.
                {
                    avanzarSerie();
                }        
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
