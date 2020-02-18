/*
    Ej3:Define una clase Persona con los siguientes datos: 
        nombre, dNacimiento (dıa de nacimiento), 
        mNacimiento (mes de nacimiento), aNacimiento (año de nacimiento),
        direccion, codigo postal y ciudad. 
        Crea varios objetos de tipo Persona y a traves de un programa muestra
        los siguientes datos:
        -Nombre de la persona de mayor edad.
        -Nombre de las personas que viven en Elche.
        -Numero de personas mayores de edad. 
        Hay que comprobar que todos los campos contienen informacion y 
        que es logica.
 */
package pro6p1e3;

import UML.Persona;
import java.util.ArrayList;
import Excepciones.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucía
 */
public class Pro6p1e3 {

    /**
     * @param args the command line arguments
     */
    //ARRAYLIST COMO VARIABLE GLOBAL
    static ArrayList<Persona>listaPersonas = new ArrayList();
            
    public static void main(String[] args) {
    try{
        do{
            añadirPersonas();
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar?")==0);
        JOptionPane.showMessageDialog(null, "La persona de mayor edad es: " + calcularMayor().getNombre() 
                                        + " que tiene " + calcularMayor().getEdad() + "\n"
                                        + "Las personas que viven en Elche son las sgtes: \n" + listadoElche()
                                        + "Personas mayores de edad: " + mayoresDeEdad());
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage() );
    }
        
    }
    public static void añadirPersonas()throws Exception{
            String nombre = validarCadena("nombre");  
            int dia = pedirFecha("dia");
            int mes = pedirFecha("mes");
            int año = pedirFecha("año");
            //falta validacion fecha excepción datetimeformatter.
            String direccion = validarCadena("direccion");
            String codPostal = validarCadena("codPostal");
            String ciudad = validarCadena("ciudad");

        Persona p = new Persona(nombre,dia,mes,año,direccion,codPostal,ciudad);
        //faltaria validar que no se pueda meter dos veces la misma persona(?)
        listaPersonas.add(p);
    }
    public static String validarCadena(String dato)throws Exception{
        /* Tener en cuenta:
            ningún campo puede estar vacío.
            nombre y ciudad no pueden tener números ni símbolos, si espacios en blanco.
            codPostal no puede tener letras. tiene una longitud determinada (5)
            direccion puede tener letras y números y símbolos pero no puede empezar con un número.
        */
        boolean error=true;
        String cadena="";
        do{
            try{
                cadena = JOptionPane.showInputDialog("Teclea " + dato );
                if(cadena.isEmpty())
                    throw new DatoObligatorioException();
                //MÁS VALIDACIONES!
                error=false;
            }
            catch(DatoObligatorioException e){
                JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios");
            }
        }
        while(error);
        return cadena;
    }
    public static int pedirFecha(String dato)throws Exception{
        /*  
            Día: debe ser 2 digitos numéricos >0 y <=31
            Mes: debe ser 2 dígitos numéricos >0 y <=12
            Año: dede ser 4 dígitos numéricos >0 y < que año actual.
        */
        boolean error=true;
        int fecha=0;
        do{
            try{
                String cadena = JOptionPane.showInputDialog("Teclea " + dato + " de nacimiento");
                if(dato.equals("año")&&cadena.length()<4||dato.equals("año")==false&&cadena.length()<2)
                    throw new FechaException();
                fecha=Integer.parseInt(cadena);
                if((dato.equals("dia")&&(fecha<0||fecha>31))
                    ||(dato.equals("mes")&&(fecha<0||fecha>12))
                    ||(dato.equals("año")&&(fecha<0||fecha>LocalDate.now().getYear())))
                    throw new FechaException();
                error=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error. El dato debe ser numérico.");
            }
            catch(FechaException e){
                int cifra;
                String mensaje;
                if(dato.equals("año")){
                    cifra = 4;
                    mensaje = "Debe ser mayor a 0 y menor que el año actual";
                }
                else{
                    cifra = 2;
                    if(dato.equals("dia"))
                        mensaje="Puede ir del 01 al 30/31";
                    else
                        mensaje="Puede ir del 01 al 12";
                }
                JOptionPane.showMessageDialog(null, dato + "inválido. Debes teclear " + cifra + " dígitos numéricos.\n" + mensaje);
            }           
        }
        while(error);
        return fecha;
    }
    public static Persona calcularMayor(){
        int pos=0;
        for(int x=0,max=-1;x<listaPersonas.size();x++){
            if(listaPersonas.get(x).getEdad()>max){
                max=listaPersonas.get(x).getEdad();
                pos=x;
            }
        }
        return listaPersonas.get(pos);
    }
    public static String listadoElche(){
        String lista="";
        for(int x=0;x<listaPersonas.size();x++){
            if(listaPersonas.get(x).getCiudad().equalsIgnoreCase("ELCHE"))
                lista+=listaPersonas.get(x).getNombre() + "\n";
        }
        return lista;
    }
    public static int mayoresDeEdad(){
        int c=0;
        for(int x=0;x<listaPersonas.size();x++){
            if(listaPersonas.get(x).isMayor())
                c++;
        }
        return c;
    }
}
