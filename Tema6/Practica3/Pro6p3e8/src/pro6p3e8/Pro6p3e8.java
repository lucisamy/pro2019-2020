/*
Validar un numero octal
 */
package pro6p3e8;

import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.regex.*;

/**
 *
 * @author Lucía
 */
public class Pro6p3e8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean error=true;
        do{
            try{
                if(!validar())
                    throw new DatoNoValidoException();
                error=false;
            }
            catch(DatoNoValidoException e){
                JOptionPane.showMessageDialog(null, "dato incorrecto");
            }
        }
        while(error);
        JOptionPane.showMessageDialog(null, "dato correcto");
    }
    public static boolean validar(){
        Pattern p = Pattern.compile("[0-7]+");
        Matcher m = p.matcher(JOptionPane.showInputDialog("teclea un número en octal"));
        return m.matches();
    }
    
}
