/*
    EJ.1: Introducir por teclado el numero de horas trabajadas por un empleado 
        e imprimir el sueldo que le corresponde cobrar teniendo en cuenta que
        cada hora normal se paga a 10 euros y cada hora extra a 15.
        Las horas extras son aquellas superiores a las cuarenta.
        En algunos casos, a la nomina calculada hay que sumarle un plus de 
        100 euros segun el estado civil y el nivel de estudios del empleado. 
        Esta ultima informacion tambien la obtendremos a traves del teclado. 
        El estado civil puede ser S de soltero, C de casado, V de viudo y D de
        divorciado (S C V D ).
        El nivel de estudios puede ser P de primario, M de medo y S de
        superior (P M S).
        Llevan el plus de 100 euros las siguientes combinaciones: SP VS SM
        CS VP SS DS.
 */
package pro3p2e1v3;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p2e1v3 {
    //EN ESTA VERSION SE USARAN MAS FUNCIONES.
    /**
     * @param args the command line arguments
     */
    //por eso necesiatremos variables globales
    static boolean error;
    static int nroHoras;
    static int sueldo;
    //constantes globales
    static final int HORAS_NORMALES = 40, COSTO_NORMAL = 10, COSTO_EXTRA = 15, PLUS = 100;
    public static void main(String[] args) {
        int sueldo;
        char estadoCivil=0;
        char nivelEstudios=0;
        try{
            do{
                //pedimos horas trabajadas y validamos.
                pedirHoras(); 
            }
            while(error==true);
            sueldo = sueldoSegunHoras(nroHoras);
            do{
                estadoCivil = pedirEstadoCivil(estadoCivil);
            }
            while(error);
            do{
                nivelEstudios = pedirNivelEstudios(nivelEstudios);
            }
            while(error);
            calcularPlus(estadoCivil,nivelEstudios);
            //Mostrar resultado
            JOptionPane.showMessageDialog(null, "el sueldo del empleado es " + sueldo + " euros");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "problemas /n" + e.getClass());
        }
        
    }
    public static void pedirHoras(){
        try{
            nroHoras = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de horas trabajadas del empleado"));
            if(nroHoras<1)
                throw new HorasIncorrectasException();
                //NINGUNA LINEA DENTRO DEL IF DESPUES DE ESTA SERÁ EJECUTADA
            error=false;
            }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debes escribir un número");
            error=true;
        }
        catch(HorasIncorrectasException e){
            //Mensaje de error
            JOptionPane.showMessageDialog(null, "Horas trabajadas no puede ser inferior a 1");
             error=true;
        }
            
    }
    public static char pedirEstadoCivil(char estadoCivil){
        try{
            estadoCivil = JOptionPane.showInputDialog("escriba estado civil: S para soltero, C para casado, V para viudo y D para divorciado").toUpperCase().charAt(0);
            //validación
            if(estadoCivil =='S'||estadoCivil=='C'||estadoCivil=='V'||estadoCivil=='D'){
                error=false;
            }
            else
                throw new EstadoCivilException();
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No dejar el campo Vacio");
            error=true;
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
            System.exit(0);
        }
        catch(EstadoCivilException e){
            JOptionPane.showMessageDialog(null, "Error, el estado civil solo puede ser: S,C,V o D");
            error= true;
        }
    } 
    public static char pedirNivelEstudios(char nivelEstudios){
       try{
            nivelEstudios = JOptionPane.showInputDialog("Escriba nivel de estudios: P de primario, M de medo y S de superior").toUpperCase().charAt(0);
            //validar nivelEstudios
            if(nivelEstudios=='P'||nivelEstudios=='M'||nivelEstudios=='S'){
                error=false;
            }
            else{ 
                error=true;
                throw new NivelEstudiosException();
            }
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No dejar el campo Vacio");
            error=true;
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Operacion cancelada");
            System.exit(0);
        }
        catch(NivelEstudiosException e){
            JOptionPane.showMessageDialog(null, "El nivel de estudios solo puede ser: P,M o S");
            error=true;
        }
       return nivelEstudios;
    }
    public static int sueldoSegunHoras(int nroHoras){
        int sueldo;
        if(nroHoras>40){
            sueldo = (COSTO_NORMAL * HORAS_NORMALES) + (COSTO_EXTRA * (nroHoras-HORAS_NORMALES));
        }
        else
            sueldo = COSTO_NORMAL * nroHoras;
        return sueldo;    
    }
   public static void calcularPlus(char estadoCivil,char nivelEstudios){
       switch(estadoCivil){
            case 'S': 
                sueldo = sueldo + PLUS;      
                break;
            case 'C':
            case 'D':
                if(nivelEstudios == 'S')
                    sueldo += PLUS;
                break;
            case 'V':
                if(nivelEstudios=='P'||nivelEstudios=='S')
                    sueldo += PLUS;
                break;
        }
   }
}
