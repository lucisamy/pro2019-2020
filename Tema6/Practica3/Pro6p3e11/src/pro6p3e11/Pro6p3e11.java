/*
Validar numero real positivo
 */
package pro6p3e11;
import Excepciones.*;
import java.util.regex.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucía
 */
public class Pro6p3e11 {

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
        Pattern p = Pattern.compile("[0-9]+[.,][0-9]+");
        Matcher m = p.matcher(JOptionPane.showInputDialog("teclea un número real positivo"));
        return m.matches();
    }
    
}
