/*
    Ej5:Desarrolla un programa que pida los litros de agua caıdos durante un
        ano determinado (día, mes y litros). Cuando el usuario nos indique
        que no quiere continuar, debemos mostrar lo que ha llovido en cada
        uno de los meses del ano. Todos lo datos de entrada son numericos y
        suponemos que correctos.
 */
package pro4p1e5;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro4p1e5 {

    /**
     * @param args the command line arguments
     */
    //para las distintas validaciones:
    static boolean error;
    public static void main(String[] args) {
        //se necesitarán 3 arrays distintos: uno para los dias, otro para los meses y otro para los litros.
        //se irán rellenando con los datos de entrada.
        //DECLARAR Y CREAR ARRAYS
        //se supone que los datos que se podrán dar serán los correspondientes a cada dia del año.
        int [] dias = new int [365]; 
        int [] meses = new int [365];
        float [] litros = new float[365];
        //DATOS DE ENTRADA
        //los datos de entrada se piden una y otra vez hasta que el usuario nos indique que no quiere continuar o hasta que se hayan llenado los datos de todo un año.
        //cuando cogemos el dato de entrada lo queremos guardar en la primera posicion de los arrays correspondientes y luego ir avanzando de posicion
        for(int x=0,continuar=0;x<dias.length&&continuar==0;x++){
            int dia = pedirDia();
            //guardamos el dia en el array de dias.

            pedirMes();
            pedirLitros();
            continuar=JOptionPane.showConfirmDialog(null, "Quieres continuar?");
        }
        
        
    }
    public static int pedirDia(){
        int dia=0;
        do{
            try{
                error=false;
            }
            catch(Exception e){
                error=true;
            }
        }
        while(error);
        return dia;
    }
    public static int pedirMes(){
        int mes=0;
        do{
            try{
                error=false;
            }
            catch(Exception e){
                error=true;
            }
        }
        while(error);
        return mes;
    }
    public static float pedirLitros(){
        float litros = 0;
        do{
            try{
                error=false;
            }
            catch(Exception e){
                error=true;
            }
        }
        while(error);
        return litros;
    }
}
