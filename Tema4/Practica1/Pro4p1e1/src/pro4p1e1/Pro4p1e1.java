/*
    Ej1:. Crear un array de 10 elementos para guardar en el valores de tipo real
        (float o double) que iremos introduciendo por teclado hasta finalizar.
        Una vez leıdos y almacenados se visualizara el valor maximo y el
        minimo.

 */
package pro4p1e1;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro4p1e1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO validaciones y funciones!!
        //Declaración array
        float [] miArray;
        //creación del array
        miArray = new float[10];
        //vamos llenando el array con dato de entrada
        for(int x=0;x<miArray.length;x++){
            miArray[x] = Float.parseFloat(JOptionPane.showInputDialog("teclear número real"));
        }
        //ya tenemos 10 elementos. debemos buscar cual es el mayor y el menor
        //si lo ordeno, el elemento de la primera posición será el menor y el elemento de la última posició será el mayor.
        Arrays.sort(miArray);
        //elemento mayor y menor
        float menor = miArray[0];
        float mayor = miArray[miArray.length -1];
        //mostrar resultado
        JOptionPane.showMessageDialog(null,"El valor máximo es " + mayor + " y el valor mínimo es " + menor);
        
    }
    
}
