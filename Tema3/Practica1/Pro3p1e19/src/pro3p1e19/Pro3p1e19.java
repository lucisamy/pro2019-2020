/*
    Ej19:Escribe un programa que calcule el cuadrado de un numero haciendo
        solo sumas. (El cuadrado de un número n es la suma de los n primeros
        numeros impares).
 */
package pro3p1e19;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*V.1
       int c,base,x=1,resultado=1;
       base = Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
       if(base!=0)
       {
           for(c=2;c<=base;c++)
           {
               x = x+2;
               resultado = resultado + x;
           }
           JOptionPane.showMessageDialog(null, "El cuadrado de " + base + " es: " + resultado);
       }
       else
           JOptionPane.showMessageDialog(null, "El cuadrado de " + base + " es: " + base);     
    */ 
    //*V.2  
       int c,base,x=1,resultado=1;
       base = Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
	
       if(base != 0 && base !=1)
       {
           for(c=1;c<base;c++)
           {
                x=x+2;
                resultado = resultado+x;
           }
           JOptionPane.showMessageDialog(null, "el cuadrado de " + base + " es: " + resultado); 
       }
       else
            JOptionPane.showMessageDialog(null,  "el cuadrado de " + base + " es: " + base);
    //*/   
    }
    
}
