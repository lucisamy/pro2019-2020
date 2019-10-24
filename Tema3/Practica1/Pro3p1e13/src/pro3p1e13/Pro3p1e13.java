/*
    Ej13:Diseña un programa que reciba a traves del teclado el peso, edad,
        nombre, sexo y estatura de un grupo de 30 alumnos y, posteriormente,
        muestre el numero de niños y de niñas que son aptos para jugar al
        baloncesto.
        Los requisitos para poder jugar al baloncesto son los siguientes: 
        Los niños deben tener una estatura mayor de 1.70 metros y pesar más de
        70 kilos . Y las ninas deben medir más de 1.60 metros y pesar más de
        60 kilos.
 */
package pro3p1e13;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p1e13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0,cniños = 0,cniñas = 0;
        //Repetitiva
        do
        {
            float peso = Float.parseFloat(JOptionPane.showInputDialog("Teclea peso del estudiante"));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Teclea edad del estudiante"));
            String nombre = JOptionPane.showInputDialog("Teclea nombre del estudiantre");
            Character sexo;
            do
            {
                sexo = JOptionPane.showInputDialog("Teclea sexo del estudiante. Escribe F para femenino y M para masculino").charAt(0);
                if(sexo.equals('F')==false ||sexo.equals('M')==false)
                    JOptionPane.showMessageDialog(null, "el dato de entrada no es válido");
            }
            while(sexo.equals('F')==false||sexo.equals('M')==false);
            float estatura = Float.parseFloat(JOptionPane.showInputDialog("Teclea estatura del estudiante"));
            JOptionPane.showMessageDialog(null,  "los datos del estudiante son: \n" + "peso: " + peso + "Kg, edad: " + edad + " años, nombre: " + nombre + ", sexo: " + sexo + ", estatura:" + estatura + " m");
            //verificar si es apto
		if (sexo.equals('F'))
                {
                    if (estatura>1.60 && peso>60) 
                        cniñas++;
                }   
		else
                {   
                    if (estatura>1.70 &&  peso>70)
                        cniños++;
                }
            contador++;
        }
        while(contador!=30);
        JOptionPane.showMessageDialog(null, "El número de niñas aptas para el baloncesto es de " + cniñas + "  y el número de niños aptos es de " + cniños);
        
    }
    
}
