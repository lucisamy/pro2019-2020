/*
    Ej11:Crear un diagrama de flujo que pida tres numeros y muestre cual es
         el mayor y cual es el menor.
 */
package pro3p1e11;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n1= Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
        int n2= Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
        int n3= Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
        if(n1>n2&&n1>n3)
        {   
            JOptionPane.showMessageDialog(null, n1 + " es el mayor");
            if(n2<n3)
                JOptionPane.showMessageDialog(null, n2 + " es el menor");
            else
                JOptionPane.showMessageDialog(null, n3 + " es el menor");
        }
        else
        {
            if(n1>n2)
                JOptionPane.showMessageDialog(null, n3 + " es el mayor y " + n2 + " es el menor");
            else
            {
                if(n1>n3)
                    JOptionPane.showMessageDialog(null, n2 + " es el mayor y " + n3 + " es el menor");
                else
                {
                    if(n2>n3)
                        JOptionPane.showMessageDialog(null, n2 + " es el mayor y " + n1 + " es el menor");
                    else
                        JOptionPane.showMessageDialog(null, n3 + " es el mayor y " + n1 + " es el menor");
                }
            }
        }
    }
    
}
