/*
    Ej1:Escribe un programa que pida los datos necesarios para calcular la
        longitud de una circunferencia (2 * PI * radio),
        su area ( PI * radio * radio) 
        y el volumen de una esfera ( 4 * PI * radio * radio * radio / 3)
 */

package pro6p1e1;
import UML.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucía
 */
public class Pro6p1e1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //ENTRADA DE DATOS Y CREACION DE OBJETOS
        try{
            //1ºforma: crear objeto y luego llenarlo usando constructor vacío + método set
            Circunferencia c = new Circunferencia();
            float r = pedirRadio();
            c.setRadio(r);//c.setRadio(pedirRadio());

            //2ºforma:crearlo y llenarlo a la vez
            Circunferencia c2 = new Circunferencia(r);//Circunferencia c2 = new Circunferencia(pedirRadio());

            //datos de salida: 
            //mostrar la longitud: hay que pasarle el radio
            c.calcularLongitud(r);//c.calcularLongitud(c.getRadio());
            //mostrar area
            c.calcularArea();
            //mostrar Volumen
            JOptionPane.showMessageDialog(null,"El volumen de esta circunferencia es de " + c.calcularVolumen(r));
            //c.calcularVolumen(c.getRadio())
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass());
        }
    }
    public static float pedirRadio()throws Exception{
        boolean error=true;
        float r = 0;
        do{
            try{
             r = Float.parseFloat(JOptionPane.showInputDialog("Teclea el radio de la cirncunferencia"));
            error=false;
            
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "El radio es un dato numérico. no se puede dejar vacío");
            }
            catch(NullPointerException e){
                if(JOptionPane.showConfirmDialog(null, "Quieres salir?")==0)
                    System.exit(0);
                else
                    error=true;
            }
        }
        while(error);
        return r;
    }
 
}
