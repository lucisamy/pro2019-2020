/*
    Ej8:Control de las falta de asistencia de los alumnos. 
        Se dispone de los partes de faltas de los alumnos en el mes de noviembre
        y se pretende contabilizar el total de faltas de cada alumno. 
        Se teclearan los partes diarios introduciendo, el codigo del alumno
        y el número de faltas.
        Cada vez que el usuario nos introduzca datos, le preguntaremos si
        desea continuar. Al final daremos el resultado de las faltas obtenidas
        excluyendo aquellos que no hayan tenido ninguna. 
        Supondremos a efectos practicos un maximo de 5 alumnos en clase.
        Cogeremos los 5 primeros codigos distintos que introduzcan como correctos,
        no admitiremos ninguno mas.
 */
package pro4p1e8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.Arrays;

/**
 *
 * @author Lucía
 */
public class Pro4p1e8 {

    /**
     * @param args the command line arguments
     */
    //GLOABLES
    static boolean error =false;
    
    public static void main(String[] args) {
        //arrays
        int [] alumnos = new int [5];
        int [] arrayFaltas = new int [5];
        do{
        pedirFecha();
            do{
                int codAlumno = pedirNumero("código del alumno");
                int faltas;
                //revisamos si el alumno ya está
                System.out.println(Arrays.binarySearch(alumnos, codAlumno));
                //ordenar array???
                if(Arrays.binarySearch(alumnos, codAlumno)<0){
                    //agregar alumno al array en sgte posicion libre
                    int x = agregarAlumno(alumnos,codAlumno);
                    faltas = pedirNumero("las faltas");
                    arrayFaltas[x]=faltas;
                }
                else
                {
                    //si se encuentra sumar faltas en esa posicion
                    faltas = pedirNumero("las faltas");
                    arrayFaltas[Arrays.binarySearch(alumnos, codAlumno)]+=faltas;
                }
                
                
            }
            while(error&&JOptionPane.showConfirmDialog(null, "Más alumnos?")==0);
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar?")==0);
    }
    public static void pedirFecha(){
       final int AÑO = 2019;
       final int MES = 11;
       do{
            try{ 
                String fechaString = JOptionPane.showInputDialog("teclea fecha en formato dd/mm");
                fechaString += "/" + AÑO;
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha= LocalDate.parse(fechaString,formato);
                //LocalDate fecha = LocalDate.of(dia, mes, AÑO);
                if(fecha.getMonthValue()!=MES)
                    throw new MesIncorrectoException();
                error=false;
            }
            catch(MesIncorrectoException e){
                JOptionPane.showInputDialog("Mes incorrecto");
                error=true;
            }
            /*
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "No se ha escito una fecha válida");
                error=true;
            }
*/
            catch(NullPointerException e){
                System.exit(0);
                error=false;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=true;
            }
       }
       while(error);
        
    }
    public static int pedirNumero(String mensaje){
        int n=0;
        do{
            try{
                n=Integer.parseInt(JOptionPane.showInputDialog("Escribe " + mensaje));
                error=false;
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
            error=true;
        }
        }
        while(error);
        return n;
    }
    public static int agregarAlumno(int []alumnos,int codAlumno){
        int x=0;
        try{
            for(x=0;x<alumnos.length&&alumnos[x]!=0;x++){}
            if(x<alumnos.length){
                //salimos porque encontramos posicion vacía.
                alumnos[x]=codAlumno;   
            }
            else
                //salimos porque se acabaron las posiciones y no encontramos libre
               throw new SinEspacioException();
        }
        catch(SinEspacioException e){
            JOptionPane.showMessageDialog(null, "No puede haber más de 5 alumnos");
            error=true;
        }
        return x;   
    }
}
