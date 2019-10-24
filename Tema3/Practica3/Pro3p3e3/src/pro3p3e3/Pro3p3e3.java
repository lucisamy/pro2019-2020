/*
    Ej3:Dada una cadena de caracteres y un caracter, verificar cuantas veces
        se repite el caracter en la cadena, por ejemplo: 
        Entrada: casa blanca ’a’
        Salida: El caracter ’a’ se repite 4 veces.
 */
package pro3p3e3;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e3 {

    /**
     * @param args the command line arguments
     */
    static String cadena;
    static String caracter;
    public static void main(String[] args) {
        datosEntrada();
        int contadorVocales = buscarCaracter();
        if(contadorVocales==1){
            JOptionPane.showMessageDialog(null,mostrarMensaje() + contadorVocales + " vez" );
        }
        else{
            JOptionPane.showMessageDialog(null, mostrarMensaje() + contadorVocales + " veces");
        }
        
    }
    public static void datosEntrada(){
        boolean error=true;
        do{
            try{
                do{
                    try{
                        cadena=JOptionPane.showInputDialog("Escribe una cadena de caracteres");
                        if(cadena.length()<2)
                            throw new PocosCaracteresException();
                        error=false;
                    }
                    catch(PocosCaracteresException e){
                        JOptionPane.showMessageDialog(null, "La cadena es demasiado corta, debe tener mas de 1 letra");
                        error=true;
                    }
                    catch(NullPointerException e){
                        System.exit(0);
                    }
                }
                while(error==true);
                do{
                    try{
                        caracter = JOptionPane.showInputDialog("que caracter quieres buscar?");
                        if(caracter.length()>1)
                            throw new MuchosCaracteresException();
                        if(caracter.length()<1)
                            throw new PocosCaracteresException();
                        error=false;
                    }
                    catch(MuchosCaracteresException e){
                        JOptionPane.showMessageDialog(null, "No puedes buscar más de 1 carácter");
                        error=true;
                    }
                    catch(PocosCaracteresException e){
                        JOptionPane.showMessageDialog(null, "Es obligatorio escribir el dato de entrada");
                        error=true;
                    }
                }
                while(error==true);
            }
            catch(NullPointerException e){
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getClass() + " " + e.getMessage());
                error=true;
            }
        }
        while(error==true);
    }
    public static int buscarCaracter(){
        int vocales=0;
        for(int x=0;x<cadena.length();x++){
            if(cadena.charAt(x)== caracter.charAt(0))
                vocales++;
        }
        return vocales;
    }
    public static String mostrarMensaje(){
        if(caracter.equals(" "))
            caracter = "Espacio en blanco";
        return "El caracter " + caracter + " se repite ";
    }
}
