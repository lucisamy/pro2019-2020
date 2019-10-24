/*
    Ej12: En una empresa de telefonia se sigue la siguiente politica de facturacion:
        Si el consumo mensual no sobrepasa los 300 minutos, se cobra 0.04
        por minuto.
        Si pasa de los 300 minutos pero no de los 500 se cobra 0.03 por cada
        minuto.
        Si pasa de los 500 minutos, se cobran los primeros 300 minutos a precio
        normal (0.03) y los restantes a 0.02.
        Si el consumo mensual, es superior a 800 minutos, se aplica la regla de
        asignacion anterior y ademas que se le realiza un descuento de 1.25 %
        del total.
        A partir de lo explicado disena un algoritmo que a partir de los minutos 
        consumidos muestre el importe a pagar.
 */
package pro3p1e12;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float importe;
        int consumo = Integer.parseInt(JOptionPane.showInputDialog("Teclea consumo"));
        if(consumo<=300)
            importe = consumo*0.04f;
        else
        {
            if(consumo<=500)
                importe=consumo*0.03f;
            else
            {
                importe=(300*0.03f)+((consumo-300)*0.02f);
                if(consumo>800)
                    importe = importe-(importe*(1.25f/100));
            } 
        }
        JOptionPane.showMessageDialog(null, "El importe a pagar este mes es de" + importe + " euros.");
    }
    
}
