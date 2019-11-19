/*
    Ej20:Crea un minijuego en el que el ordenador elija un numero aleatorio
        comprendido entre 0 y 100 para que el usuario intente adivinarlo.
        (numero = aleatorio(0,100))
        Cada vez que el usuario haga un intento le daremos pistas de si el
        numero que busca es mas alto o mas bajo que el que ha escrito, hasta
        que acierte o escriba la palabra FIN para terminar el juego.
 */
package pro3p1e20;

import java.util.Random;
import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro3p1e20 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //En esta versión uso solo una variable tipo String para guardar el dato de entrada.
        String intento="";//podrá contener la palabra FIN o el número para tratar de adivinar.
        //numero aleatorio
        int n = (int) (Math.random() * 100); //el método random devuelve valor entre 0 y 1 asi que multiplico por 100.
        //otra forma: int aleatorio = new Random().nextInt(101);
        System.out.println(n);
        boolean error=true;
        int intentoNumerico;
        int x = 0;
        do{
            try{
                intento=JOptionPane.showInputDialog("Intenta adivinar el número o escribe FIN para terminar");
                //validaciones
                //solo existen 2 opciones buenas: es un número entre 0 y 100 o es la palabra fin.
                //comprobamos que no hayan dejado el cuadro vacio
                if(intento.isEmpty())
                    throw new CampoVacioException();
                else
                {//revisamos si han puesto fin
                    if(intento.equalsIgnoreCase("FIN")==false)
                    {
                        //comprobamos si la cadena es un número
                        for(x=0;x<intento.length()&&Character.isDigit(intento.charAt(x));x++){}
                        //si salgo del for es porque se acabaron las posiciones o porque encontró algo que no era un numero.
                        if(x<intento.length())
                        //se encontró algo que no es un número (y sabemos que tampoco es la palabra FIN)
                            throw new CaracterInvalidoException();
                        else //se llegó al final y todos son números.
                        {
                            //realizamos la conversión
                            intentoNumerico = Integer.parseInt(intento);
                            if(intentoNumerico<0|intentoNumerico>100)
                                throw new IntentoNoValidoException();
                            else
                                intento = comparar(intentoNumerico,n);
                                error=true;//si el intento es fin se saldrá de la repetitiva.
                        }
                    }
                }   
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "no puedes dar a la x o cancelar, escribe FIN para terminar.");
                error=true;
                intento="";
            }
            catch(CampoVacioException e){
                JOptionPane.showMessageDialog(null, "no puedes dejar este campo vacío o en blanco");
                error=true;
            }
            catch(CaracterInvalidoException e){
                JOptionPane.showMessageDialog(null, "Intento no válido, solo se permite escribir números o la palabra FIN para terminar.");
                error=true;
            }
            catch(IntentoNoValidoException e){
                JOptionPane.showMessageDialog(null, "Intento no válido, El número a adivinar está entre 0 y 100");
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
                error=false;
            }    
        }
        while(error&&!intento.equalsIgnoreCase("FIN"));
        //no hay errores y se ha escrito fin.
        System.exit(0);
    }
    public static String comparar (int intentoNumerico,int n){
        if(intentoNumerico==n){
            JOptionPane.showMessageDialog(null, "Felicidades, has ganado!");
            return "fin";
        }
        else{
            if(intentoNumerico<n)
                JOptionPane.showMessageDialog(null, "Intenta con un número más grande");
            
            else
                JOptionPane.showMessageDialog(null, "Intenta con un número más pequeño");
            return "";
                
        }
    }
}
