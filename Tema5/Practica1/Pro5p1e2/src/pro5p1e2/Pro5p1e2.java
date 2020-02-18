/*
Ej2: Queremos almacenar en un arrayList de dos dimensiones el numero de 
    alumnos con el que cuenta una academia, ordenados en funcion del nivel y 
    del idioma que se estudia (no hay todos los niveles para todos los idiomas).
    Tendremos tres niveles: el Nivel basico, medio y de perfeccionamiento y 
    cuatro idiomas ( Ingles, Frances, Aleman y Ruso). 
    Se pide realizar la creacion del arraylist y asignarle unos valores de ejemplo 
    a algunos elementos. Posteriormente se mostraran totales por niveles y por 
    idiomas.

 */
package pro5p1e2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro5p1e2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList de 2 dimensiones: 1 dimensión-->idioma / 1 dimensión-->niveles.
        ArrayList<ArrayList<Integer>> lista = new ArrayList();
        /*creo los 3 niveles:
        for(int x=0;x<3;x++){
            lista.add(x,new ArrayList()); //nivel básico,medio y perfeccionamiento
        }*/
        //nivel por nivel:
        lista.add(new ArrayList()); //nivel básico
        //añadimos 3 alumnos en inglés básico:
        lista.get(0).add(3);
        lista.add(new ArrayList()); //nivel medio
        //añadimos 7 alumnos en francés nivel medio:
        lista.get(1).add(1,7);
        //añadimos 1 alumno en alemán nivel medio:
        lista.get(1).add(3,1);
        lista.add(new ArrayList()); //nivel perfeccionamiento:
        //añadimos 2 alumnos a ruso nivel perfeccionamiento:
        lista.get(2).add(2,2);
        //totales por niveles
        int totalBasico=0;
        int totalMedio=0;
        int totalPerfeccionamiento=0;
       
            for(Integer elemento:lista.get(0)){
                totalBasico+=lista.get(0).get(elemento);
            }
            for(Integer elemento:lista.get(1)){
                totalMedio+=lista.get(1).get(elemento);
            }
            for(Integer elemento:lista.get(2)){
                totalPerfeccionamiento+=lista.get(2).get(elemento);
            }
        JOptionPane.showMessageDialog(null, "El total de alumnos por niveles es: \n"
                                            + "Nivel básico: " + totalBasico + "\n"
                                            + "Nivel medio: " + totalMedio + "\n"
                                            + "Nivel perfeccionamiento: " + totalPerfeccionamiento);
        //totales por idiomas:
        
    }
    
}
