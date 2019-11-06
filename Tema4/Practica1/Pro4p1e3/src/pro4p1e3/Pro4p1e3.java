/*
    EJ3:Crea un array de caracteres que contenga de la ’A’ a la ’Z’ (solo las
        mayusculas). Despues, ve pidiendo posiciones del array por teclado 
        y si la posicion es correcta, se anadirá a una cadena que se mostrará
        al final, se dejara de insertar cuando se introduzca un -1. 
        
        Por ejemplo, si escribo los siguientes numeros 
        0 //Anadira la ’A’
        5 //Anadira la ’F’
        25 //Anadira la ’Z’
        50 //Error, inserte otro numero
        -1 //fin
        Cadena resultante: AFZ
 */
package pro4p1e3;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro4p1e3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crearArray();//creamos y llenamos el array con el abecedario
        int posicion=0;
        String cadena="";
        posicion=pedirPosicion();//pedimos y validamos la posicion (int)
        while(posicion!=-1){
           cadena=construirCadena(posicion);
           posicion=pedirPosicion();
        }
        mostrarCadena(cadena);
    }
    public static void crearAray(){
        //declarar y crear el array.
        char[] abecedario = new char[25];
        //lenar el array con las letras del abecedario en mayúsulas.
        abecedario={'A','B'};
    }
    public static int pedirPosicion(){
        int posicion=0;
        boolean error=true;
        do{
            try{
                posicion = Integer.parseInt(JOptionPane.showInputDialog("teclea posicion de la letra"));
                error=false;
            }
            catch(Exception e){
                error=true;
            }
        }
        while(error);
        return posicion;
    }
}
