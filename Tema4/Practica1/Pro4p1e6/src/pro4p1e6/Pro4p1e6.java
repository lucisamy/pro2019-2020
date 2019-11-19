/*
    Ej6:Realiza un programa que cuente el numero de veces que aparece cada
        una de las letras de un texto introducido por el teclado y a continuacion
        visualice el resultado.
 */
package pro4p1e6;

import javax.swing.JOptionPane;
import Excepciones.*;
/**
 *
 * @author Lucía
 */
public class Pro4p1e6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //arrays
        int [] contadores = new int [27];
        char [] abecedario = new char [27];
        inicializarArrayLetras(abecedario);
        try{
            String cadena = datoEntrada();
            contadores = buscarVocales(cadena,abecedario,contadores);
            mostrarResultado(contadores,cadena,abecedario);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
        }
    }
    public static void inicializarArrayLetras(char[]abecedario){
        abecedario[0] = 'a';
        abecedario[1] = 'b';
        abecedario[2] ='c';
        abecedario[3] ='d';
        abecedario[4] ='e';
        abecedario[5] ='f';
        abecedario[6] ='g';
        abecedario[7] ='h';
        abecedario[8] ='i';
        abecedario[9] ='j';
        abecedario[10] ='k';
        abecedario[11] ='l';
        abecedario[12] ='m';
        abecedario[13] ='n';
        abecedario[14] ='ñ';
        abecedario[15] ='o';
        abecedario[16] ='p';
        abecedario[17] ='q';
        abecedario[18] ='r';
        abecedario[19] ='s';
        abecedario[20] ='t';
        abecedario[21] ='u';
        abecedario[22] ='v';
        abecedario[23] ='w';
        abecedario[24] ='x';
        abecedario[25] ='y';
        abecedario[26] ='z';
    }
    public static String datoEntrada()throws Exception{
        String cadena="";
        boolean error;
        do{
            try{
                cadena = JOptionPane.showInputDialog("Escribe una cadena de texto");
                if(cadena.isEmpty()||cadena.equals(" "))
                    throw new EntradaVaciaException();
                //buscar Numeros
                int x;
                for(x=0;x<cadena.length()&&!Character.isDigit(cadena.charAt(x));x++){}
                //si sale del for puede ser porque lo recorrió todo y no encontró números
                //o porque encontró un número y ya no siguió
                if(x<cadena.length()){
                    throw new EntradaConNumerosException();
                }
                error=false;
            }
            catch(EntradaConNumerosException e){
                JOptionPane.showMessageDialog(null, "Porfavor, no escribas números en la cadena de texto");
                error=true;
            }
            catch(NullPointerException e){
                if(JOptionPane.showConfirmDialog(null, "Estás seguro que quieres cancelar?")==0)
                {    
                    System.exit(0);
                    error=false;
                }
                else
                    error=true;       
            }
            catch(EntradaVaciaException e){
                JOptionPane.showMessageDialog(null, "No has escrito nada o has dejado en blanco");
                error=true;
            }
        }
        while(error);
        return cadena;
    }
    public static int[] buscarVocales(String cadena,char [] abecedario,int [] contadores){
        //recorrer cadena de texto
        for(int x=0;x<cadena.length();x++){
            //para cada letra recorremos el array de letras
            for(int y=0;y<abecedario.length;y++){
                //si el caracter se encuentra en el array de letras en la posicion "y" sumamos +1 al array contadores en esa posicion.
                if(cadena.charAt(x)==abecedario[y])
                    contadores[y]++;
            }
        }
        return contadores;
    }
    public static void mostrarResultado (int [] contadores,String cadena,char[]abecedario){
        String resultado = "Para la cadena de texto: "  + cadena + " \n";
        //para ir colocando cada linea vamos recorriendo el array de letras y el array de contadores:
        for(int x = 0;x<abecedario.length;x++){ 
            if(contadores[x]!=1&&contadores[x]!=0)
                resultado += abecedario[x] + " aparece " + contadores [x] + " veces \n";
            else
                if(contadores[x]!=0)
                    resultado += abecedario[x] + " aparece " + contadores [x] + " vez \n";
        }
        resultado += "el resto de letras no aparecen";
        JOptionPane.showMessageDialog(null, resultado);
    }
}
