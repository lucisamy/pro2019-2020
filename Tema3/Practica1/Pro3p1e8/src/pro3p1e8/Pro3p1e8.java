/*
    Ej8:
 */
package pro3p1e8;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //dato entrada
        int n = Integer.parseInt(JOptionPane.showInputDialog("Teclea un numero del 0 al 10"));
        //alternativa
        if(n>=5)
            JOptionPane.showMessageDialog(null, "Aprobado");
        else
            JOptionPane.showMessageDialog(null, "Suspendido");
    }
    
}
