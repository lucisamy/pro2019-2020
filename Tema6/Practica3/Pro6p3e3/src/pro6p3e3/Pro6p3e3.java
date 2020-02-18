/*
Validar un numero entero negativo.
válidos: -1,-10,-101..
inválidos: 5, 0, -0, -1-5.
 */
package pro6p3e3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String dato = JOptionPane.showInputDialog("Teclea un número entero negativo");
       if(validar(dato))
           JOptionPane.showMessageDialog(null, "Dato correcto");
       else
           JOptionPane.showMessageDialog(null, "dato incorrecto");
    }
    public static boolean validar(String texto){
        Pattern patron = Pattern.compile("-[1-9][0-9]*");
        Matcher mat = patron.matcher(texto);
        return mat.matches();
        
    }
    
}
