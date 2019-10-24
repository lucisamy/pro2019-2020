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

/**
 *
 * @author Lucía
 */
public class Pro3p1e20 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String intento;
        //numero aleatorio
        int n = (int) Math.random() * 100; //el método random devuelve valor entre 0 y 1 asi que multiplico por 100.
        //otra forma: int aleatorio = new Random().nextInt(101);
        boolean error;
        System.out.println(n);
        
        
    }
    
}
