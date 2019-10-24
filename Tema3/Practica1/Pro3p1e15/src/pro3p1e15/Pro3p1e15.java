/*
    Ej15:Diseña un programa que permita introducir las notas de cierta cantidad 
        de alumnos y que luego muestre la cantidad de aprobados 
        (notas mayores o iguales a 6.00).
 */
package pro3p1e15;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int contador=0;
        String respuesta;
        do
        {
            float nota = Float.parseFloat(JOptionPane.showInputDialog("escribir nota del alumno"));
            if(nota>=6)
                contador++;
            respuesta = JOptionPane.showInputDialog("Quieres continuar?");
        }
        while(respuesta.equalsIgnoreCase("si"));
        JOptionPane.showMessageDialog(null, "la cantidad de aprobados es " + contador);
    }
    
}
