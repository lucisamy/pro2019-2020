/*
    Ej6:Crear un programa que reciba una fecha y que devuelva el nombre
        de la estacion en la que está ubicado dicha fecha.
 */
package pro3p3e6;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*el principio de las estaciones puede variar según el año asi que tomaremos como referencia este año 2019
        22/12/2018-20/03/2019-->invierno
        20/03/2019-21/06/2019-->primavera
        21/06/2019-23/09/2019-->verano
        23/09/2019-22/12/2019-->otoño
        22/12/2019-20/03/2020--> invierno    
        */
        //definiremos las fechas de inicio de cada estación como constantes:
        //si definimos como date tendremos que usar un string y un parse para construirlas.
        //para convertir una fecha String en una fecha Date necesitamos la clase SimpleDateFormat para parsear con un formato concreto
        boolean error;
        //DATE
        SimpleDateFormat formato = new SimpleDateFormat ("dd/mm/yyyy");
        final String INVIERNO = "22/12/2019";
        final String OTOÑO = "23/09/2019";
        final String VERANO = "21/06/2019";
        final String PRIMAVERA = "20/03/2019";
        try {
            Date invierno = formato.parse(INVIERNO);
            Date otoño = formato.parse(OTOÑO);
            Date verano = formato.parse(VERANO);
            Date primavera = formato.parse(PRIMAVERA);
           
            String fecha = JOptionPane.showInputDialog("Teclea una fecha de este año 2019 en formato dd/mm/2019");
            Date fechaDate = formato.parse(fecha);
            if(fechaDate.get)
            if(fechaDate.before(invierno)){
                if(fechaDate.before(otoño)){
                    if(fechaDate.before(verano)){
                        if(fechaDate.before(primavera)){
                            
                        }
                    }
                }
            }
            else
                
        } 
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Problemas al parsear la fecha. formato inválido.");
            error=true;
        }
        
    }
    
}
