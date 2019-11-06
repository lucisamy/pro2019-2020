/*
    Ej4:Desarrolla un programa que solicite al usuario el mes en letra y que
        luego lo valide, es decir, que muestre un mensaje indicando si el mes
        tecleado es correcto o no.
 */
package pro4p1e4;

import Excepciones.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro4p1e4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String mes= pedirMes();
            //ARRAY con todos los meses válidos:
            String [] meses = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
            buscarMesEnArray(mes,meses);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
        }
    }
    public static String pedirMes()throws Exception{
        //Pedimos dato de entrada y validamos que sea un string válido.
        boolean error=true;
        String mes="";
        do{
            try{
                mes =  JOptionPane.showInputDialog("Teclea un mes en letra.");//se permite guardar nulos.
                //comprobar que no han dejado el campo vacío o con un blanco
                if(mes.isEmpty()||mes.equals(" ")){
                    throw new CampoVacioException();
                }
                else{ //sabemos que no está vacío
                    //queremos comprobar que no se trate de un número: para ello debemos recorrer el string y comparar cada carácter.
                    for(int x=0;x<mes.length();x++){
                        if(Character.isDigit(mes.charAt(x)))
                            throw new DatoNumericoException();
                    }
                }
                mes.toLowerCase();//es aquí donde se produce un error si el valor de mes es null.
                error=false;
            }
            //el orden en el que colocamos los catch importa!
            catch(NullPointerException e){
                int respuesta = JOptionPane.showConfirmDialog(null, "seguro que quierer salir del programa?");
                if(respuesta==0)
                    System.exit(0);
                else
                    error=true;
            }
            catch(CampoVacioException e){
                JOptionPane.showMessageDialog(null, "has dejado el campo vacío. Escribe de nuevo el mes");
                error=true;
            }
            catch(DatoNumericoException e){
                JOptionPane.showMessageDialog(null, "No escribas el mes con números.");
                error=true;
            }
        }
        while(error);
        return mes;
    }
    public static void buscarMesEnArray(String mes,String[]meses){
        //para buscar el mes recorremos el array y comparamos con cada posicion:
        //para seguir en la repetitiva deben cumplirse 2 condiciones: deben quedar posiciones y el valor de la posicion no debe ser igual al mes, es decir...
        //se saldrá de la repetitva si alguna de las condiones no se cumple: al recorrer todo el array o si encontramos lo que buscamos.
        int x;
        for(x=0;x<meses.length&&meses[x].equals(mes)==false;x++){}
        if(x<meses.length)
            //sabemos que salió porque se encontró el mes
            JOptionPane.showMessageDialog(null, "Mes Correcto");
        else
            //sabemos que es porque llegó al final y no encontró el mes
            JOptionPane.showMessageDialog(null, "mes incorrecto");
        
    }
}
