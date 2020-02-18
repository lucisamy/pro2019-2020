/*
    Validar numero real con x decimales.
 */
package pro6p3e13;
import Excepciones.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       boolean error=true;
       do{
            try{
               String x = JOptionPane.showInputDialog("cuántos decimales?");
               if(!validar(x))
                   throw new DatoInvalidoException();
               error=false;
            }
            catch(DatoInvalidoException | NumberFormatException e){
               JOptionPane.showMessageDialog(null, "dato incorrecto");
            }
       }
       while(error);
       JOptionPane.showMessageDialog(null, "dato correcto");
    }
    public static boolean validar(String x)throws NumberFormatException{
        Pattern p = Pattern.compile("[1-9][0-9]*"); //no puede escribir que quiere 0 decimales ni  03 decimales.
        Matcher m = p.matcher(x);
        if(!m.matches())
            throw new NumberFormatException();
        p = Pattern.compile("-?[0-9]+[.,][0-9]{" + x + "}");
        //otra opcion: String expresion = "[0-9]+[.,][0-9]{" + x + "}"; y luego compile(expresion)
        m = p.matcher(JOptionPane.showInputDialog("Teclea un número real con " + x + " decimales"));
        return m.matches();
    }
}
