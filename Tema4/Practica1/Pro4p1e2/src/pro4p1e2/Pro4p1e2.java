/*
    EJ2:. Crea un array de numeros donde le indicamos por teclado el tamaño
        del array, rellenaremos el array con numeros aleatorios entre 0 y 9,
        al final muestra por pantalla el valor de cada posicion y la suma de
        todos los valores.
 */
package pro4p1e2;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro4p1e2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //estructura: crear array,llenar array, mostrar resultado(valor de cada posicion,suma)
        //DECLARAR ARRAY
        int [] numeros;
        try{
            int tamañoArray=datoEntrada();
            //CREAR ARRAY
            numeros = new int [tamañoArray];
            llenarArray(numeros);
            mostrarResultado(numeros);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
        }
    }
    public static int datoEntrada()throws Exception{
        //validacion de datos de entrada
        boolean error=true;
        int tamañoArray=0;
        do{
            try{
                tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("teclea tamaño del array"));
                if(tamañoArray<=0){
                    throw new ValorNoValidoException();
                }
                error=false;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El valor debe ser un número");
                error=true;
            }
            catch(ValorNoValidoException e){
                JOptionPane.showMessageDialog(null, "El valor debe ser un número mayor que 0");
                error=true;
            }
        }
        while(error);
        return tamañoArray;
    }
    public static void llenarArray(int[]numeros)throws Exception{
        for(int x=0;x<numeros.length;x++){
            //para LLENAR EL ARRAY lo recorremos y vamos guardando en cada posición el número aleatorio
            numeros[x] = (int)(Math.random()*10);//el método random devuelve double con valor de 0 a 10, incluyendo 0, excluyendo 10.
            System.out.println(numeros[x]); //visualizamos que numero nos ha generado para comprobar
            //numero no es la posición sino directamente el elemento
        }
    }
    public static void mostrarResultado(int[]numeros)throws Exception{
        //para mostrar contenido de cada posición hay que recorrer el array por tanto necesitamos repetitiva
        //guardar en un string el contenido de cada posición e ir sumando
        String mensaje ="";
        int suma = 0;
        for(int x=0;x<numeros.length;x++){
            mensaje = mensaje + "posición " + x + ": " + numeros[x] + "\n";
            suma = suma + numeros[x];
        }
        //mostrar resultado final
        JOptionPane.showMessageDialog(null, mensaje + "La suma de todos los números es " + suma);
    }
}
