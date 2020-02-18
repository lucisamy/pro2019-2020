/*
    Ej2: Crea una agenda con los datos de los alumnos de clase. 
        De cada alumno guarda su codigo, nombre, domicilio y telefono. 
        Una vez introducido sus datos, se visualizaran los datos del alumno que 
        corresponda con un codigo tecleado.
 */
package pro6p1e2;
import UML.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Excepciones.*;
/**
 *
 * @author Lucía
 */
public class Pro6p1e2 {

    /**
     * @param args the command line arguments
     */
    //VARIABLE GLOBAL
    static ArrayList<Alumno> alumnos = new ArrayList();
    
    public static void main(String[] args) {
        
        //DATOS DE EJEMPLO
        Alumno a1 = new Alumno(1,"Pepe","aaaa","67726831");
        alumnos.add(a1);
        Alumno a2 = new Alumno(2);
        alumnos.add(a2);
        //CREAR ALUMNOS
        char continuar;
        try{
            do{
                alumnos.add(crearAlumno());
                continuar=JOptionPane.showInputDialog("Quieres continuar s/n?").toLowerCase().charAt(0);
            }
            while(continuar=='s');
            //
        //BUSCAR ALUMNO
            int cod = pedirCodAlumno(); 
            
            if(buscarAlumno(cod)){
              //mostrar datos de alumno
                JOptionPane.showMessageDialog(null,"Los datos del alumno " + cod + " son:\n" + );
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
        }
    }
    public static int pedirCodAlumno()throws Exception{
        boolean error=true;
        int cod = 0;
        do{
            try{
                cod=Integer.parseInt(JOptionPane.showInputDialog("Teclea el código del alumno"));
                if(cod<=0)
                    throw new CodInvalidoException();
                error=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Debe ser un valor numérico");
            }
            catch(CodInvalidoException e){
                JOptionPane.showMessageDialog(null, "Todo codigo es mayor que 0");
            }
            /*
            catch(NullPointerException e){
                if(JOptionPane.showConfirmDialog(null, "Quieres terminar?")==0){
                    System.exit(0);
                    error=false;
                }
            }*/
            
        }
        while(error);
        return cod;
    }
    public static boolean buscarAlumno(int cod){
        int x;
        for(x = 0;x<alumnos.size()&&alumnos.get(x).getCod()!=cod;x++){}
        if(x<alumnos.size()){  
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Alumno no encontrado");
            return false;
        }
    }
    public static String pedirCadena(String dato){
        boolean error=true;
        String cadena="";
        int x;
        do{
            try{
                cadena=JOptionPane.showInputDialog("Teclea " + dato + " del alumno");
                if(cadena.isEmpty())
                    throw new DatosObligatoriosException();
                else{
                    if(dato.equals("teléfono")){
                        if(cadena.length()<9)
                            throw new TelefonoNoValidoException();
                        else{
                            for(x=0;x<cadena.length()&&Character.isDigit(cadena.charAt(x));x++){}
                            if(x<cadena.length()) //encontró una letra
                                throw new TelefonoNoValidoException();
                        }
                    }
                    else{
                        //nos han pedido una cadena de texto para nombre o para domicilio
                        //en el caso de nombre: alfabetico (no puede tener numeros)
                        //en el caso de domicilio: alfabetico con numeros (puede tener numeros, pero obligatoriamente debe empezar con letra)
                        for(x=0;x<cadena.length()&&!Character.isDigit(cadena.charAt(x));x++){
                            if(x<cadena.length()) //encontró un número
                        }
                        if(Character.isDigit(cadena.charAt(0)))
                            throw new CadenaNoValidaException();
                    }
                    error=false;
                }
                
            }
            catch(DatosObligatoriosException e){
                JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios");
            }
            catch(CadenaNoValidaException e){
                if(dato.equals("nombre"))
                    JOptionPane.showMessageDialog(null, "Este dato no puede contener números");
                JOptionPane.showMessageDialog(null, "Este dato no puede empezar con un número");
            }
            catch(TelefonoNoValidoException e){
                JOptionPane.showMessageDialog(null, "El teléfono debe ser un dato numérico de 9 cifras");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
            }
        }
        while(error);
        return cadena;
    }
    public static Alumno crearAlumno()throws Exception{
        Alumno a = new Alumno();
        int cod; 
        do{
            cod = pedirCodAlumno();
            if(buscarAlumno(cod))
                JOptionPane.showMessageDialog(null, "este alumno ya ha sido creado");
        }
        while(buscarAlumno(cod));
        a.setCod(cod);
        a.setNombre(pedirCadena("nombre"));
        a.setDomicilio(pedirCadena("domicilio"));
        a.setTel(pedirCadena("teléfono"));
        return a;
    }
}
