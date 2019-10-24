/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro3p2e1v3;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p2e1v3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nroHoras=0;
        boolean error;
        do{
            //pedimos horas trabajadas y validamos.
            try{
                nroHoras = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de horas trabajadas del empleado"));
                if(nroHoras<1)
                    throw new HorasIncorrectasException();
                    //NINGUNA LINEA DENTRO DEL IF DESPUES DE ESTA SERÁ EJECUTADA
                else
                    error=false;
            }
            catch(HorasIncorrectasException e){
                //Mensaje de error
                JOptionPane.showMessageDialog(null, "Horas trabajadas no puede ser inferior a 1");
                 error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "problemas /n" + e.getClass());
                error=true;
            }
        }
        while(error==true);
    }
    
}
