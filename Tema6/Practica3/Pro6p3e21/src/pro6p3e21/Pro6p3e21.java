/*
Crea una agenda con los datos de todos los alumnos de Arriaga Egibide.
De cada alumno hay que guardar su codigo (5 dıgitos numericos), nombre, 
domicilio, telefono, edad, sexo (H, M u O), fecha de nacimiento, 
direccion de correo electronico personal, direccion de correo electronico 
del centro (ikasle.egibide.org), pagina web (www.), curso (141GA) y estado civil
(casado o soltero).
Una vez introducidos todos los datos, se visualizaran los del alumno cuyo codigo
nos tecleen. 
Hay que comprobar que los campos contienen informacion y que es logica.
La direccion de la pagina web es opcional. 
En cuanto al curso tener en cuenta la siguiente estructura:
- El primer dıgito representa el centro (1 - Arriaga).
- El segundo dıgito representa el nivel (1- ESO 2-Bachiller 3-CFGM 4-CFGS).
- El tercer dıgito representa el curso (En la ESO hay cuatro, en el resto
de los niveles dos).
- Letra que identifica el ciclo o el curso.
- Letra que indica el modelo (A, B o D).
 */
package pro6p3e21;

import UML.Alumno;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro6p3e21 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Alumno>listaAlumnos = new ArrayList();
    public static void main(String[] args) {
        do{
            Alumno a = new Alumno();
            a.setCod(codAlumno());
            a.setNombre(nombreAlumno());
            domicilioAlumno();
            telAlumno();
            edadAlumno();
            sexoAlumno();
            fechaNacimiento();
            emailPersonal();
            emailEgibide();
            webAlumno();
            cursoAlumno();
            estadoCivil();
            listaAlumnos.add(a);
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar?")==0);
        codAlumno();
        //buscar en arrayList 
        //construit superstring con datos del alumno y mostrar.
    }
    public static String codAlumno(){
        boolean error=true;
        String cod="";
        do{
            try{
                cod = JOptionPane.showInputDialog("Teclea código del alumno");
                Pattern p = Pattern.compile("[0-9]{5}");
                Matcher m = p.matcher(cod);
                if(!m.matches())
                    throw new DatoInvalidoException();
                //recorrer arraylist para comprobar que este código no esté ya usado.
                int x;
                for(x=0;x<listaAlumnos.size()&&listaAlumnos.get(x).getCod()!=cod;x++){}
                if(x<listaAlumnos.size())
                    throw new AlumnoRepetidoException();
                error=false;
            }
            catch(DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "dato incorrecto");
            }
            catch(AlumnoRepetidoException e){
                JOptionPane.showMessageDialog(null, "El alumno con este código ya existe");
            }
        }
        while(error);
        return cod;
        
    }
    public static String nombreAlumno(){
        boolean error=true;
        String nombre="";
        do{
            try{
                nombre = JOptionPane.showInputDialog("Teclea el nombre del alumno");
                Pattern p = Pattern.compile("[A-Z]([a-z]+[ ]?)+([ ][A-Z]([a-z]+[ ]?)+)+");
                Matcher m = p.matcher(nombre);
                if(!m.matches())
                    throw new DatoInvalidoException();
                error=false;
            }
            catch(DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "dato incorrecto");
            }
        }
        while(error);
        return nombre;
    }
    public static void domicilioAlumno(){}
    public static void telAlumno(){}
    public static void edadAlumno(){}
    public static void sexoAlumno(){}
    public static void fechaNacimiento(){}
    public static void emailPersonal(){}
    public static void emailEgibide(){}
    public static void webAlumno(){}
    public static void cursoAlumno(){}
    public static void estadoCivil(){}
    
    
}
