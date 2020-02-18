/*
Validar un numero binario.
 */
package pro6p3e7;

import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.regex.*;
/**
 *
 * @author Lucía
 */
public class Pro6p3e7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            if(!validar())
                throw new DatoNoValidoException();
            JOptionPane.showMessageDialog(null, "dato correcto");
        }
        catch(DatoNoValidoException e){
            JOptionPane.showMessageDialog(null, "dato incorrecto");
        }
    }
    public static boolean validar(){
        Pattern p = Pattern.compile("[01]+");
        Matcher m = p.matcher(JOptionPane.showInputDialog("Teclea un número binario"));
        return m.matches();
    }
    
}
