/*
    EJ8:Desarrolla un proyecto que muestre en pantalla un menú con las 
        siguientes opciones:
        a) Calcular la edad de una persona.
        b) Sumar dos numeros.
        c) Contar cuantas vocales hay en una cadena.
        d) Salir
        Selecciona una opcion: 
        Si nos seleccionan la opcion a, pediremos una fecha de nacimiento y
        restándosela al dıa de hoy, obtendremos la edad en años de esa persona.
        Si nos seleccionan la opcion b, solicitaremos dos numeros y mostraremos
        el resultado de sumarlos.
        Si nos seleccionan la opcion c, solicitaremos una cadena de caracteres
        y mostraremos en pantalla el numero de vocales que la componen.
        Cuando nos seleccionen la opcion d el programa terminará.
 */
package pro3p3e8;

import Excepciones.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p3e8 {

    /**
     * @param args the command line arguments
     */
    static boolean cancelar;
    public static void main(String[] args) {
        boolean error=true;
        String opc="";
        do{
            do{
                try{
                    opc = mostrarMenu();
                    error=validar(opc);
                    opc = opc.toLowerCase();
                    switch(opc.charAt(0)){
                        case 'a': 
                            calcularEdad();
                            break;
                        case 'b':
                            sumarNumeros();
                            break;
                        case 'c':
                            contarVocales();
                            break;
                        case 'd':
                            cancelar=false;
                    }
                }
                catch(NullPointerException e){
                    JOptionPane.showMessageDialog(null, "el dato de entrada es obligatorio, si quieres salir elige la opción d");
                    error=true;
                }
                catch (CadenaVaciaException e){
                   JOptionPane.showMessageDialog(null, "no puedes dejar este campo vacío.");
                   error=true;
                }
                catch(MuchosCaracteresException e){
                    JOptionPane.showMessageDialog(null, "opción inválida, sólo se puede escribir 1 carácter.");
                    error=true;
                }
                catch(OpcionInvalidaException e){
                    JOptionPane.showMessageDialog(null, "opción inválida, sólo se puede escribir a,b,c o d.");
                    error=true;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                    error=true;
                }
            }
            while(error==true);
        }
        while(opc.charAt(0)!='d'||cancelar==true);
    }
    public static String mostrarMenu()throws Exception{
        return JOptionPane.showInputDialog("Selecciona una opción: \n" + 
                                            "a) Calcular la edad de una persona.\n" +
                                            "b) Sumar dos números.\n" +
                                            "c) Contar cuantas vocales hay en una cadena.\n" +
                                            "d) Salir");
        //se podria colocar un blanco o hacer clic en x o cancelar por lo que se producirían excepciones.
        //las tratamos en el main.
    }
    public static boolean validar(String opc)throws Exception{
        boolean error;
        //solo se puede escribir 1 carácter.
        if(opc.length()!=1){
            //si es menor está vacía.
            if(opc.isEmpty())
                throw new CadenaVaciaException();
            else
            //si es mayor escribió mas de un caracter    
                throw new MuchosCaracteresException();
        }
        else
        //no puede contener números, ni ser nada que no sea a,b,c,d.
        {    if(Character.isLetter(opc.charAt(0)))
            {
                //solo puede contener opciones a,b,c,d.
                if(opc.charAt(0)=='a'||opc.charAt(0)=='b'||opc.charAt(0)=='c'||opc.charAt(0)=='d')
                    error=false;
                else
                    throw new OpcionInvalidaException();
            }
            else
                throw new OpcionInvalidaException();
        }
        return error;
    }
    public static void calcularEdad()throws Exception{
        boolean error=true;
        do{
            try{
                String fechaString = JOptionPane.showInputDialog("Escribe fecha de nacimiento en formato dd/MM/yyyy");
                if(fechaString.isEmpty()){
                    throw new CadenaVaciaException();
                }
                cancelar=false;                
                //conversión a LocalDate
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNacimiento = LocalDate.parse(fechaString, formato);
                LocalDate fechaActual = LocalDate.now();
                Period edad = Period.between(fechaNacimiento, fechaActual);
                JOptionPane.showMessageDialog(null, edad.getYears());
                error=false;
            }
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Problemas en el formato de la fecha");
                error=true;
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "opción cancelada");
                cancelar=true;
                error=false;
            }
            catch (CadenaVaciaException e){
                JOptionPane.showMessageDialog(null, "no puedes dejar este campo vacío.");
                error=true;
                //como quiero que entre en la repetitiva no relanzo esta excepción.
            }
        }
        while(error);           
    }
    public static void sumarNumeros(){
        int n1 = pedirNumero();
        int n2 = pedirNumero();
       JOptionPane.showMessageDialog(null, "la suma de los números es " + (n1+n2));
    }
    public static void contarVocales(){
        //Dato de entrada
        String cadena = JOptionPane.showInputDialog("Teclea la cadena de texto");
        //falta Validaciones!
        cadena=cadena.toLowerCase();
        int contadorVocales=0;
        for(int x=0;cadena.charAt(x)<cadena.length()-1;x++){
            switch(cadena.charAt(x)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contadorVocales++;
            }
        }
        JOptionPane.showMessageDialog(null, "en esta cadena hay " + contadorVocales + " vocales");
    }
    public static int pedirNumero(){
        int n=0;
        boolean error=true;
        do{
            try{
                String cadena =JOptionPane.showInputDialog("Teclea un número");
                if(cadena.isEmpty())
                    throw new CadenaVaciaException();
                n = Integer.parseInt(cadena);

                error=false;
            }
            catch (CadenaVaciaException e){
                JOptionPane.showMessageDialog(null, "no puedes dejar este campo vacío.");
                error=true;
                //como quiero que entre en la repetitiva no relanzo esta excepción.
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getClass() + " " +e.getMessage());
                error=true;
            }
        }
        while(error==true);
        return n;
    }
}
