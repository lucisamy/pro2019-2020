/*
    Ej4: Desarrolla una programa en el que el usuario nos proporcione el
        nombre de los alumnos de un curso y sus notas en seis asignaturas
        distintas. El programa terminara cuando como nombre nos tecleen la 
        palabra FIN.
        Nuestro programa debe visualizar el nombre de cada uno de los alumnos
        y su nota media.
        Al final, cuando nos tecleen fin, mostraremos la nota media del conjunto
        de alumnos.
 */
package pro3p2e4;

import Excepciones.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucía
 */
public class Pro3p2e4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre="";
        boolean error = false;
        int nota;
        
        do{
            try{
                nombre = JOptionPane.showInputDialog("Teclea nombre del alumno o escribe FIN si quieres terminar");
                
                //validarNombre();
                //validaciones al nombre
                //está vacío?
                if(nombre.length()==0||nombre.equals(" ")){
                   throw new NombreVacioException();
                   
                }
                nombre.
                /*comprobar que sea un string: no puede contener simbolos ni numeros.
                Habria que hacer una validacion por cada tipo de dato que quiero recoger como invalido ya que string lo acepta todo.
                para comprobar que no contiene simbolos.
                habria que pensar que simbolos se quieren prohibir.
                <,.-ç+'¡
                para comprobar que no contiene números deben revisarse todas las posiciones del string con un for*/
                for(int x=0;x<nombre.length();x++){
                    int blancos=0;
                    /*if(Character.isDigit(nombre.charAt(x))){
                        throw new NombreInvalidoException();
                    }*/
                    
                    if(!Character.isLetter(nombre.charAt(x))){
                        throw new NombreInvalidoException();
                        //este método daria true con los espacios en blanco, números, y algunos símbolos aunque no todos. 
                        //no se podria colocar "nombre apellido" por el espacio en blanco.
                        //opciones invalidas: un blanco o varios sin letras, blanco en primera posición. 
                        //solo puede existir un blanco y nunca en primera posición.
                        //para comprobar si existe un blanco y cuantas veces y en que posición:
                        
                    }
                    if(nombre.charAt(x)==' '){
                        blancos++;
                    }
                    if(blancos>1){
                        throw new NombreInvalidoException();
                    }
                }
                //pedir6Notas
                /*for(int c=0; c<6;c++){
                    nota = Integer.parseInt(JOptionPane.showInputDialog("Teclea nota del alumno"));
                    //validar nota
                }*/
            
                calcularMediaAlumno();
            //mostrar mensaje: alumno + nota media.
            }
            catch(NombreVacioException e){
                JOptionPane.showMessageDialog(null, "el nombre no puede estar vacío o ser un espacio en blanco");
            }
            catch(NombreInvalidoException e){
                JOptionPane.showMessageDialog(null, "el nombre contiene algun caracter inválido, espacios en blanco, números, símbolos..");
            }
            /*  catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio.");}
                No se produce null pointer exception por dejar el nombre vacio, sino por  hacer clic en cancelar o en la x.
                fijarse en ejercicio resuelto. otra excepción para manejar campos vacíos.
                No veo en que caso se produce StringIndexOutOfBoundsException.
                
                
                
                Al hacer clic en cancelar se guarda un nulo y al mirar la condicion del do while se produce la excepción
                por tanto al estar fuera del bloque try-catch no entra en el bloque try-catch y  no se puede tratar la excepción
                
                soluciones:
                1.si hubiera otra condición o acción que hiciera saltar la excepción antes de terminar y mirar el do-while
                se podria tratar la excepción con el try-catch
                2. dos do-while. el mas externo seria para las validaciones. y el mas interno para repetir hasta que se escriba FIN.
                entre los dos se pondria el bloque try catch. 
                
            */
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Problemas. \n" + e.getClass() + " " + e.getMessage());
            }
            
        }
        while(!nombre.equalsIgnoreCase("FIN")||error==true);
        mostrarNotaMediaTotal(); 
    }
    public static void mostrarNotaMediaTotal(){
        
    }
    public static void calcularMediaAlumno(){
        
    }
}
