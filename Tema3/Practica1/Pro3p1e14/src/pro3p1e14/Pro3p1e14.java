/*
    Ej14:Escribe un programa que calcule la suma de 10 numeros. El programa 
        irá pidiendo números al usuario y, cuando tenga 10, mostrará el resultado 
        y terminara.
 */
package pro3p1e14;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int suma = 0, contador;
        //mientras se cumpla la condición se repite.
        for(contador=0;contador!=10;contador++)
        //for(contador=0;contador<10;contador++)
        {
            int num = Integer.parseInt(JOptionPane.showInputDialog("escribe un número"));
            suma += num; //es lo mismo que: suma = suma + num;
        }
        JOptionPane.showMessageDialog(null, "el resultado de la suma es " + suma);
    }
    
}
