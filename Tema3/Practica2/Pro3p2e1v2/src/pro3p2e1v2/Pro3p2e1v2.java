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

    /**
     * @param args the command line arguments
     */
    //constantes globales
    static final int HORAS_NORMALES = 40, COSTO_NORMAL = 10, COSTO_EXTRA = 15, PLUS = 100;
    
    public static void main(String[] args) {
        int nroHoras=0;
        boolean error;
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
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "problemas /n" + e.getClass());
                error=true;
            }
        }
        while(error==true);
        int sueldo = sueldoSegunHoras(nroHoras);
        //pedimos estado civil y nivel de estudios
        char estadoCivil = 0;
        char nivelEstudios = 0;
        try{
            //error=true; //cambio valor de error a true para obligarle a entrar en la primera repetitiva do-while
            do{
                estadoCivil = JOptionPane.showInputDialog("escriba estado civil: S para soltero, C para casado, V para viudo y D para divorciado").toUpperCase().charAt(0);
                //validación
                if(estadoCivil =='S'||estadoCivil=='C'||estadoCivil=='V'||estadoCivil=='D'){
                    error=false;
                }
                else
                    throw new EstadoCivilException();
            }
            while(error==true);
            //error=true; //-->vuelvo a cambiar valor de error para obligar a entrar en la repetitiva
            do{
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
            while(error==true);
        }
        catch(EstadoCivilException e){
            JOptionPane.showMessageDialog(null, "Error, el estado civil solo puede ser: S,C,V o D");
            error= true;
        }
        catch(NivelEstudiosException e){
            JOptionPane.showMessageDialog(null, "El nivel de estudios solo puede ser: P,M o S");
            
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, "problemas /n" + e.getClass());
                error=true;
        }
        switch(estadoCivil){
            case 'S': 
                sueldo = sueldo + PLUS;
                error=false;       
                break;
            case 'C':
            case 'D':
                if(nivelEstudios == 'S')
                    sueldo += PLUS;
                error=false;
                break;
            case 'V':
                if(nivelEstudios=='P'||nivelEstudios=='S')
                    sueldo += PLUS;
                error=false;
                break;
        }
        //Mostrar resultado
        JOptionPane.showMessageDialog(null, "el sueldo del empleado es " + sueldo);
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
