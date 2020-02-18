/*
Validar una IP.
una ip consta de 4 números de mínimo una cifra hasta 3 cifras separados por puntos.
ccada cifra va desde 0 a 255.
0.0.0.0
255.255.255.255
 */
package pro6p3e5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro6p3e5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog("Escribe una dirección ip");
        if(validar(ip))
            JOptionPane.showMessageDialog(null, "dato correcto");
        else
            JOptionPane.showMessageDialog(null, "Dato incorrecto");
    }
    public static boolean validar(String ip){
        Pattern p = Pattern.compile("(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])[.]){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])[.])");
        Matcher m = p.matcher(ip);
        return m.matches();
    }
}
