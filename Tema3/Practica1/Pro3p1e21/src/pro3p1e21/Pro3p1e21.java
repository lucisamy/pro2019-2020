/*
    Ej21:Haz un programa que pida al usuario un numero y diga si ese numero
        es primo o no.
 */
package pro3p1e21;

import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro3p1e21 {

    /**
     * @param args the command line arguments
     */
    static boolean error;
    static int n;
    public static void main(String[] args) {
        //error=true;
        do{
            try{
                pedirNumero();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
            }
        }
        while(error);
        //comprobar si es primo
        comprobarPrimo();
    }
    public static void pedirNumero()throws Exception{
        try{
            n = Integer.parseInt(JOptionPane.showInputDialog("Teclea un número"));
            if(n<=0)
                throw new ValorNoValidoException();
            error=false;
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "hay que escribir un número");
            error=true;
        }
        catch(ValorNoValidoException e){
            JOptionPane.showMessageDialog(null, "El número debe ser mayor a 0");
            error=true;
        }
    }
    public static void comprobarPrimo(){
        //un numero es primo solo si al dividirlo sucesivamente por 1-numero solo tiene resto 0 2 veces: al dividir por 1 y al dividir por si mismo.
        int restoCero=0;
        for(int divisor=1;divisor<=n;divisor++){
            if(n%divisor==0)
                restoCero++;
        }
        if(restoCero>2)
            JOptionPane.showMessageDialog(null, "este número no es primo");
        else
            JOptionPane.showMessageDialog(null, "este número es primo");
    }
}
