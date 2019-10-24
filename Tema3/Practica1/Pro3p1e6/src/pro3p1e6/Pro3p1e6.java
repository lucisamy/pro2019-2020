/*
    Ej6:Visualiza el area de la circunferencia que corresponde al radio 
        introducido por teclado. (A = PI * R * R)

 */
package pro3p1e6;

/**
 *
 * @author Lucía
 */
public class Pro3p1e6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Entrada de datos con JOptionPane
        String dato = javax.swing.JOptionPane.showInputDialog("Teclea el radio de la circunferencia");
        //Conversión
        Double radio = Double.parseDouble(dato);
        //Calcular Área
        Double area = Math.pow(radio,2) * Math.PI;
        //Mostrar resultado
        javax.swing.JOptionPane.showMessageDialog(null, "el area de la circunferencia es " + area);    
        
    }
    
}
