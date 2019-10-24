/*
    EJ1: Dada una cadena de caracteres mostrar por pantalla la cantidad de
        vocales que tiene. Ejemplo:
        Entrada: Hola tu
        Salida: La cantidad de vocales es 3
 */
package pro3p3e1;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import pro3p3e1.Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro3p3e1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contadorVocales=0;
        boolean error=true;
        do{
            try{
                String cadena = showInputDialog("Escribe el mensaje");
                //validar cadena
                //no puede estar vacío
                if(cadena.isEmpty())
                    throw new CampoVacioException();
                //no debe contener números.
                //recorrer cadena y buscar numeros y vocales
                for(int x=0;x<cadena.length();x++){
                    if(Character.isDigit(cadena.charAt(x)))
                        throw new CaracterNumericoException();
                    //si no es numérico damos por hecho que el dato de entrada es correcto 
                    error=false;
                    //como es letra pasamos a minúscula
                    cadena.toLowerCase();
                    //contar vocales.
                    if(cadena.charAt(x)=='a'||cadena.charAt(x)=='e'||cadena.charAt(x)=='i'||cadena.charAt(x)=='o'||cadena.charAt(x)=='u')
                        contadorVocales++;
                }
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Es obligatorio proporcionar un dato de entrada");
                error=true;
            }
            catch(CaracterNumericoException e){
                JOptionPane.showMessageDialog(null, "la cadena de caracteres solo debe contener letras");
                error=true;
            }
            catch(CampoVacioException e){
                JOptionPane.showMessageDialog(null, "No puedes dejar el nombre vacio");
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=true;
            }
        }
        while(error==true);
        JOptionPane.showMessageDialog(null,"El numero de vocales es " + contadorVocales);
    }
    
}
