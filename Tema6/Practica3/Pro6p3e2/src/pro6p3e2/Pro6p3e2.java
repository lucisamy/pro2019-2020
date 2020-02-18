/*
Validar un numero entero positivo.
válidos: 0,1,10
inválidos: -5,a,05.

 */
package pro6p3e2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena = JOptionPane.showInputDialog("teclea un número entero positivo");
        if(validarCadena(cadena))
            JOptionPane.showMessageDialog(null, "Dato correcto");
        else
            JOptionPane.showMessageDialog(null, "dato incorrecto");
    }
    public static boolean validarCadena(String texto){
        Pattern patron = Pattern.compile("0|^[1-9][0-9]*");
        Matcher mat = patron.matcher(texto);
        return mat.matches();
    }
}
