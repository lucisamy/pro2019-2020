/*
    ej5:Crear un programa que recoja una fecha introducida por el usuario
        como 3 campos numericos (dıa, mes, año) y devuelva la fecha 100 dıas
        posterior mostrada con el formato: Viernes, 16 de noviembre de 2018
 */
package pro3p3e5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Teclea el dia"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Teclea el mes como número"));
            int año = Integer.parseInt(JOptionPane.showInputDialog("Teclea año"));

            //con LocalDate
            LocalDate fecha = LocalDate.of(año,mes,dia);
            //fecha 100 dias posterior
            fecha = fecha.plusDays(100);
            JOptionPane.showMessageDialog(null, fecha.getDayOfWeek() + ", " + fecha.getDayOfMonth() + " de " + fecha.getMonth() + " de " + fecha.getYear());
            //se podría usar un periodo de 100 dias y agregar ese periodo a una fecha?
            //como se usa un periodo definido con anterioridad?
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas");
        }
        //Cómo sacar resultado en castellano?
        //estructuras switch, revisar ejercicio año pasado.
        
        //intentarlos con date y calendar
    }
    
}
