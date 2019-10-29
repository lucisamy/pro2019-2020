/*
    Ej4:Crear un programa que calcule la diferencia en días entre dos fechas
        dadas por el usuario como cadenas con el formato dd/mm/yy.
 */
package pro3p3e4;

import Excepciones.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long ms=0;
        boolean error=true;
        //para convertir una fecha String en una fecha Date necesitamos la clase SimpleDateFormat o DateFormat para parsear con un formato concreto
        SimpleDateFormat formateador = new SimpleDateFormat ("dd/mm/yy");
        //DateFormat formateador = new SimpleDateFormat("dd/mm/yy");
        do{
            try{
            String fechaString1 = JOptionPane.showInputDialog("escribe una fecha con el formato dd/mm/yy");
            String fechaString2 = JOptionPane.showInputDialog("escribe una fecha con el formato dd/mm/yy");
            
                fechaDATE(fechaString1,fechaString2,formateador,ms);
                //fechaCALENDAR(fechaString1,fechaString2,formateador,ms);
                //fechaLocalDate(fechaString1,fechaString2);
                
                error=false;
            }
            catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Problemas con el dato de entrada. formato incorrecto.");
                error=true;
            }
            catch(FechasIgualesException e){
                JOptionPane.showMessageDialog(null, "Las fechas no pueden ser iguales");
                error=true;
            }
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "formato de fecha inválido. porfavor escribe dd/MM/yyyy");
                error=true;
            }
            catch(NullPointerException e){
                System.exit(0);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getClass() + " " + e.getMessage());
                error=true;
            }
        }
        while(error==true);
        
    } 
    public static void fechaDATE(String fechaString1,String fechaString2,SimpleDateFormat formateador,long ms)throws Exception{
        JOptionPane.showMessageDialog(null, "EJECUCION CON DATE");
        Date fecha1 = formateador.parse(fechaString1);
        Date fecha2 = formateador.parse(fechaString2);
        //Comprobar qué fecha es posterior y luego restar los dias.
        if(fecha1.before(fecha2))
           ms = fecha2.getTime()-fecha1.getTime();
        else
           if(fecha2.before(fecha1))
           ms = fecha1.getTime()-fecha2.getTime();

        long dias = ms/(1000*3600*24);
        //mostrar resultado
        mostrarResultado(dias);
    }
    public static void fechaCALENDAR(String fechaString1,String fechaString2,SimpleDateFormat formateador,long ms)throws Exception{
        JOptionPane.showMessageDialog(null, "EJECUCION CON CALENDAR");
        //para convertir de string a Calendar, primero hay que convertir de String a Date y de Date a Calendar
        Calendar fecha1=Calendar.getInstance();
        Calendar fecha2=Calendar.getInstance();
        fecha1.setTime(formateador.parse(fechaString1)); //formateador.parse(fechaString1) devuelve un Date.
        fecha2.setTime(formateador.parse(fechaString2));
        //Comprobar qué fecha es posterior y luego restar los dias.
        //86400000 ms = 1 dia.
        if(fecha1.before(fecha2))
            ms = fecha2.getTimeInMillis()-fecha1.getTimeInMillis();
        else
        {
            if(fecha2.before(fecha1))
                ms= fecha1.getTimeInMillis()-fecha2.getTimeInMillis();
            else
                //las fechas son iguales, para qué ejecuta el programa?
                throw new FechasIgualesException();
        }
        long dias = ms/86400000;
        //mostrar resultado
        mostrarResultado(dias);
    }
    public static void fechaLocalDate(String fechaString1,String fechaString2)throws Exception{
        JOptionPane.showMessageDialog(null, "EJECUCION CON LOCALDATE");
        //Para convertir de String a LocalDate se usa la clase DateTimeFormatter
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        /* con la máscara dd/mm/yy: 13/12/96
            dd=DayOfMonth=13
            mm=MinuteOfHour=12
            yy=Year=2096
            esto da error
        */    
        LocalDate fecha1 = LocalDate.parse(fechaString1, formato);
        LocalDate fecha2 = LocalDate.parse(fechaString2,formato);
        //para calcular la diferencia en dias se puede usar la clase Period
        Period dias;
        //según que fecha sea posterior:
        //si fecha 1 es posterior:
        if(fecha1.isAfter(fecha2))
            dias = Period.between(fecha2, fecha1);
        //si fecha2 es posterior:
        else
        {
            if(fecha2.isAfter(fecha1))
                dias = Period.between(fecha1, fecha2);
            else
                throw new FechasIgualesException();
        }
        //el resultado mostrado es: P-numero-D para mostrar apropiadamente hay que usar los métodos get de period
        //mostramos resultado
        JOptionPane.showMessageDialog(null, "la diferencia entra las dos fechas es de: " + dias.getDays() + " días");
    }
    public static void mostrarResultado(long dias){
        JOptionPane.showMessageDialog(null, "la diferencia entra las dos fechas es de: " + dias + " días");
    }
}
