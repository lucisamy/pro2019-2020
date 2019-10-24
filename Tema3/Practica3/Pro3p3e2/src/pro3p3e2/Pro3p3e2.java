/*
    Ej2:Dada una cadena de caracteres invertir la misma y mostrar por pantalla. 
        Ejemplo:
        Entrada: casa blanca
        Salida: acnalb asac
 */
package pro3p3e2;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String cadena = datosEntrada();
        String cadenaInvertida = invertirCadena(cadena);
        JOptionPane.showMessageDialog(null, cadenaInvertida);
        //JOptionPane.showMessageDialog(null,invertirCadena(cadena)); nos ahorrariamos la variable cadenaInvertida.
        //JOPtionPane.showMessageDialog(null,invertirCadena(datosEntrada())); nos ahorrariamos todas las variables del main.
    }
    public static String datosEntrada(){
    boolean error=true;
    String cadena="";
    do{
        try{
            cadena = JOptionPane.showInputDialog("Escribe una cadena de texto");
            if(cadena.isEmpty())
                throw new CampoVacioException();
            if(cadena.length()<1)
                throw new CadenaCortaException();
            error=false;
        }
        catch(CadenaCortaException e){
            JOptionPane.showMessageDialog(null, "La cadena debe tener mas de 1 carácter");
            error=true;
        }
        catch(NullPointerException | CampoVacioException e){
            JOptionPane.showMessageDialog(null, "Es obligatorio dar un  dato de entrada");
            error=true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
            error=true;
        }
    }
    while(error==true);
    return cadena;    
    }
    public static String invertirCadena(String cadena){
    String invertida = "";
    for(int x = cadena.length()-1;x>-1;x--){
        invertida = invertida + cadena.charAt(x);
    }
        return invertida;
    }
}
