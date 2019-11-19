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
package pro3p2e1v2;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p2e1v2 {
    //VERSION CON EXCEPCIONES
    /**
     * @param args the command line arguments
     */
    //constantes globales
    static final int HORAS_NORMALES = 40, COSTO_NORMAL = 10, COSTO_EXTRA = 15, PLUS = 100;
    
    public static void main(String[] args) {
        int nroHoras=0;
        char estadoCivil = 0;
        char nivelEstudios = 0;
        int sueldo=0;
        boolean error;
        try{
            do{
                //pedimos horas trabajadas y validamos.
                try{
                    nroHoras = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de horas trabajadas del empleado"));
                    if(nroHoras<1)
                        throw new HorasIncorrectasException();
                        //NINGUNA LINEA DENTRO DEL IF DESPUES DE ESTA SERÁ EJECUTADA
                    else
                        error=false;
                }
                catch(HorasIncorrectasException e){
                    //Mensaje de error
                    JOptionPane.showMessageDialog(null, "Horas trabajadas no puede ser inferior a 1");
                     error=true;
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Debes escribir un número");
                    error=true;
                }

            }
            while(error==true);
            sueldo = sueldoSegunHoras(nroHoras);
            //pedimos estado civil y nivel de estudios
            do{
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
            while(error==true);
            do{
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
            }
            while(error==true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "problemas \n" + e.getClass());
            System.exit(0);
        }
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
        //Mostrar resultado
        JOptionPane.showMessageDialog(null, "el sueldo del empleado es " + sueldo + " euros");
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
}
