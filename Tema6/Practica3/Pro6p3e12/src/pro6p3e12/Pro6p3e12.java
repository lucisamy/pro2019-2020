/*
Validar numero real negativo.

 */
package pro6p3e12;
import Excepciones.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean error=true;
        do{
            try{
                if(!validar())
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
    public static boolean validar(){
        Pattern p = Pattern.compile("-[0-9]+[.,][0-9]+");
        Matcher m = p.matcher(JOptionPane.showInputDialog("teclea un número real neagtivo"));
        return m.matches();
    }
    
}
