/*
    Ej17:Diseña un programa que obtenga la calificación mayor y la calificación
        menor, de un grupo de 40 estudiantes, además de los nombres de
        dichos alumnos.
 */
package pro3p1e17;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e17 {

    /**
     * @param args the command line arguments
     */
    //Variables globales:
    public static float cmayor,cmenor;
    public static String nmayor,nmenor;
    /*
        Dentro de las funciones buscarMayor y buscarMenor actualizamos el valor de 2 variables, la nota y el nombre 
        no podemos hacer return de 2 variables por lo que colocamos estas como globales.
    */
    
    public static void main(String[] args) {
        cmayor=-1;
        cmenor=11;
        float nota = 0;
        //Datos de entrada
        for(int c=0;c<2;c++)
        {
            String nombre = JOptionPane.showInputDialog("Escribe el nombre del alumno");
            boolean error = true;//inicializamos para obligar a entrar al menos una vez en el while.
            while(error==true)
            {
                nota = Float.parseFloat(JOptionPane.showInputDialog("Escribe la calificación del alumno"));
                error=validarNota(nota);
            }
            JOptionPane.showMessageDialog(null, "datos guardados: " + nombre + " " + nota);
            buscarMayor(nota,nombre);
            buscarMenor(nota,nombre);
        }
        JOptionPane.showMessageDialog(null, "La calificación mayor es de " + cmayor + " y pertenece al alumno " + nmayor
                                        + ". La califiación menor es de " + cmenor + " y pertenece al alumno " + nmenor+".");
        
    }
    public static boolean validarNota(float nota){
        boolean error;
        if(nota<0 && nota>10)
        {
            JOptionPane.showMessageDialog(null, "nota invalida. debe ser entre 0 y 10. Escribe de nuevo");
            error=true;
        }
        error=false;
        return error;
    }
    public static void buscarMayor(float nota,String nombre){   
        if(nota>cmayor)
        {
            cmayor = nota;
            nmayor = nombre;
        }
    }
    public static void buscarMenor(float nota, String nombre){
        if(nota<cmenor)
        {   
            cmenor = nota;
            nmenor = nombre;
        }
    }
}
