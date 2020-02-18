/*
Validar un numero hexadecimal.
 */
package pro6p3e9;

import java.util.regex.*;
import javax.swing.JOptionPane;
import Excepciones.*;
/**
 *
 * @author Lucía
 */
public class Pro6p3e9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean error=true;
        do{
            try{
                if(!validarDatoEntrada())
                throw new DatoInvalidoException();
                error=false;
            }
            catch(DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "dato incorrecto");
            }
        }
        while(error);
        JOptionPane.showMessageDialog(null, "dato correcto");
    }
    public static boolean validarDatoEntrada(){
        Pattern p = Pattern.compile("[0-9]+[A-F]*");
        Matcher m = p.matcher(JOptionPane.showInputDialog("Teclea un número hexadecimal"));
        return m.matches();
    }
    
}
