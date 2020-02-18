/*
    Validar DNI, 8 numeros y una letra al final. 
 */
package pro6p3e4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dato = JOptionPane.showInputDialog("Teclea un DNI");
        if(validar(dato))
            JOptionPane.showMessageDialog(null, "dato correcto");
        else
            JOptionPane.showMessageDialog(null, "dato incorrecto");
        
    }
    public static boolean validar(String cadena){
        Pattern p = Pattern.compile("[0-9]{8}[A-HJ-NP-Z]");
        Matcher m = p.matcher(cadena);
        return m.matches();
    }
}
