/*
validar un número entero: puede er positivo o negativo, en caso de ser negativo iria de 1-9 ya que no existe -0.
tampoco puede emmpezar en 0 y tener mas de un caracter
válidos:
0
-1
10
-10
no válido: 05, -0.
 */
package pro6p3e1;
import java.util.regex.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucía
 */
public class Pro6p3e1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena = JOptionPane.showInputDialog("Teclea un número entero");
        Pattern patron = Pattern.compile("0|^-?[1-9][0-9]*");
        Matcher mat = patron.matcher(cadena);
        if(mat.matches())
            JOptionPane.showMessageDialog(null, "dato correcto");
        else
            JOptionPane.showMessageDialog(null, "dato incorrecto");
        
    }
    
}
