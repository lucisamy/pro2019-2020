/*
Validar una matricula de un coche con formato 0000XXX
 */
package pro6p3e6;

import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.regex.*;

/**
 *
 * @author Lucía
 */
public class Pro6p3e6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        String matricula = JOptionPane.showInputDialog("Teclea la matrícula");
        if(validar(matricula))
            JOptionPane.showMessageDialog(null, "Dato correcto");
        else
            throw new DatoNoValidoException();
        }
        catch(DatoNoValidoException e){
            JOptionPane.showMessageDialog(null, "dato incorrecto");
        }
    }
    public static boolean validar(String dato){
        Pattern p = Pattern.compile("[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}");
        Matcher m = p.matcher(dato);
        return m.matches();
    }
}
