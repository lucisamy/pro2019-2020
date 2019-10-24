/*
    Ej9:Convertir una calificacion numérica que recibimos como dato de entrada
    (0 al 10) a muy deficiente, insuficiente, suficiente, bien, notable
    o sobresaliente.
 */
package pro3p1e9;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //dato entrada
        int n = Integer.parseInt(JOptionPane.showInputDialog("Teclea un número del 0 al 10"));
        //Alternativas
        if (n<5)
            if (n>=4)
                JOptionPane.showMessageDialog(null, "Insuficiente");
            else
                JOptionPane.showMessageDialog(null, "Muy deficiente");
        else
            if(n==5)
                JOptionPane.showMessageDialog(null, "Suficiente");
            else
                if (n<7)
                    JOptionPane.showMessageDialog(null, "Bien");
                else
                    if(n<9)
                        JOptionPane.showMessageDialog(null, "Notable");
                    else
                        JOptionPane.showMessageDialog(null, "Sobresaliente");
    }
    
}
