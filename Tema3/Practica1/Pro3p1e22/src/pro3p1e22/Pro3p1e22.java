/*
    Ej22:Escribe un programa en el que pidamos al usuario un numero y nos
        muestre los numeros primos entre 1 y ese numero (incluido). 
 */
package pro3p1e22;

import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro3p1e22 {

    /**
     * @param args the command line arguments
     */
    static boolean error;
    public static void main(String[] args) {
        int n=0;
        do{
            try{
                n = datoEntrada();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                System.exit(0);
            }
        }
        while(error);
        calcularPrimos(n);
    }
    public static int datoEntrada()throws Exception{
        int n=0;
        try{
            n= Integer.parseInt(JOptionPane.showInputDialog("Teclea un número"));
            if(n<=0)
                throw new ValorNoValidoException();
            error=false;
        }
        catch(ValorNoValidoException e){
            JOptionPane.showMessageDialog(null, "debes escribir un número entero mayor a 0");
            error=true;
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Escribe un número");
            error=true;
        }
        return n;
    }
    public static void calcularPrimos(int n){
        if(n==1)
            JOptionPane.showMessageDialog(null, n + " es un número primo");
        else
        {
            String numPrimos="Entre 1 y " + n + ": ";
            for(int x =1;x<=n;x++){
                //cada vez que cambiamos de número ponemos a 0 el contador de restoCero. 
                int restoCero=0;
                //miraremos si un número es primo o no
                for(int divisor=1;divisor<=x;divisor++){
                    if(x%divisor==0){
                        restoCero++;
                    }
                }
                if(restoCero<=2)
                   numPrimos+= x + " ";
            }
            JOptionPane.showMessageDialog(null, numPrimos + "son números primos.");
        }
    }
    
}
