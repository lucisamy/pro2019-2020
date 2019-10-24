/*
    Ej.3:Mostrar al usuario el siguiente menu:
        1.- Sumar dos numeros. 
        2.- Restar dos numeros 
        3.-Visualizar la tabla de multiplicar de un numero. 
        4.- Visualizar el cociente y el resto de una division. 
        5.-Salir del programa.
        Elige una opcion: 
        Cuando tengamos el resultado de la operacion elegida, lo visualizamos 
        en pantalla y volveremos a mostrar el menu hasta que seleccione 
        la opcion de salir.
 */
package pro3p2e3;

import javax.swing.JOptionPane;
import pro3p2e3.Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro3p2e3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        boolean error=true;
        int opc=0;
        do{ 
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción: \n"
                        + "1. Sumar dos números \n"
                        + "2. Restar dos números \n"
                        + "3. Visualizar la tabla de multiplicar de un número \n"
                        + "4. Visualizar el cociente y el resto de una división.\n"
                        + "5. Salir del programa"));
                if(opc<1||opc>5){
                    throw new OpcionIncorrectaException();
                }
                else{
                    error=false;
                }
                switch(opc){
                    case 1:
                        sumar();
                        break;
                    case 2:
                        restar();
                        break;
                    case 3:
                        tablaMultiplicar();
                        break;
                    case 4:
                        cocienteYResto();
                        break;
                }
                //se selecciona 5: salimos del programa.
                
            }
            
            catch(ArithmeticException e){
                JOptionPane.showMessageDialog(null, "no se puede dividir entre 0");
                error=true;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debes teclear números");
                error=true;
            }
            catch(OpcionIncorrectaException e){
                JOptionPane.showMessageDialog(null, "la opción elegida debe ser entre 1 y 5");
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass());
                error=true;
            }
        }
        while(error==true||opc!=5);
    }
    public static void sumar()throws Exception{ 
        int n1,n2;
            n1 = solicitarNumero();
            n2 = solicitarNumero();
        JOptionPane.showMessageDialog(null, "el resultado de la suma es " +(n1+n2));
    }
    public static int solicitarNumero() throws Exception{
        return Integer.parseInt(JOptionPane.showInputDialog("Teclea un número"));
    }
    public static void restar()throws Exception{
        JOptionPane.showMessageDialog(null, "El resultado de la resta es " + (solicitarNumero()-solicitarNumero()));
    }
    public static void tablaMultiplicar()throws Exception{
        int n = solicitarNumero();
        String tabla="";
        for(int c=0;c<13;c++){
            tabla = tabla + n + "*" + c + "=" + (n*c) + "\n";
        }
        JOptionPane.showMessageDialog(null, "La tabla de multiplicar de " + n + " es: \n" + tabla);
    }
    public static void cocienteYResto() throws Exception{
        int n1,n2;
            n1 = solicitarNumero();
            n2 = solicitarNumero();
        JOptionPane.showMessageDialog(null, "El cociente de la división es: " + (n1/n2) + " y el resto es: " + (n1%n2));
    }
}
