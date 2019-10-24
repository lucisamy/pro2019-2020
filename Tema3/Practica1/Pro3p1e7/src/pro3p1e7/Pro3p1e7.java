/*
    Ej7:Realiza el diagrama de flujo que calcule la hipotenusa de un triangulo
        rectangulo teniendo como datos de entrada los dos catetos. 
        (El Teorema de Pitagoras nos dice que para cualquier triángulo rectángulo,
        la suma de los cuadrados de los catetos es igual al cuadrado de la
        hipotenusa).
 */
package pro3p1e7;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //entrada de datos
        double c1 = Integer.parseInt(JOptionPane.showInputDialog("teclea valor del primer cateto"));
        double c2 = Integer.parseInt(JOptionPane.showInputDialog("teclea el valor del segundo cateto"));
        //Calculo de hipotenusa
        double hipotenusa = Math.sqrt(2)(Math.pow(c1, 2)+ Math.pow(c2, 2));
        
    }
    
}
