/*
    Ej10:Introducir por teclado un numero comprendido entre el 1 y el 7 e
    imprimir el dia de la semana al que hace referencia. Por ejemplo, si
    introducen el 1 se visualizara Lunes
 */
package pro3p1e10;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de 1 a 7"));
        switch (n)
        {
            case 1: JOptionPane.showMessageDialog(null, "Lunes");
                break;
            case 2: JOptionPane.showMessageDialog(null, "Martes");
                break;
            case 3:JOptionPane.showMessageDialog(null, "Miércoles");
                break;
            case 4:JOptionPane.showMessageDialog(null, "Jueves");
                break;    
            case 5:JOptionPane.showMessageDialog(null, "Viernes");
                break;
            case 6:JOptionPane.showMessageDialog(null, "Sábado");
                break;
            case 7:JOptionPane.showMessageDialog(null, "Domingo");
                break;
            default: JOptionPane.showMessageDialog(null, "Porfavor escribe un número del 1 al 7");
        }
    }
}
