/*
    Ej16:Calcula el promedio de edades de un grupo de estudiantes de los
        cuales no se conoce la cantidad.
 */
package pro3p1e16;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String respuesta="si";//para obligar a entrar a la repetitiva la primera vez inicio valor en "si"
        int c=0;
        double suma=0,promedio;
        while(respuesta.compareToIgnoreCase("si")==0)
        {
            //pedir y validar edad
            boolean error;
            int edad;
            do
            {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Escribe edad del estudiante"));
                if(edad<=0)
                {    
                    JOptionPane.showMessageDialog(null, "Edad introducida incorrecta.");
                    error=true;
                }
                else
                    error=false;
            }
            while(error==true);
            suma = suma + edad;
            c++;
            respuesta = JOptionPane.showInputDialog("Quieres continuar?");
        }
        promedio = suma/c;
        JOptionPane.showMessageDialog(null, "El promedio de las edades es de " + promedio);
    }
    
}
