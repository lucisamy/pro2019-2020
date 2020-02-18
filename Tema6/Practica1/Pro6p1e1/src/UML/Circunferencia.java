/*
    Ej1: Escribe un programa que pida los datos necesarios para calcular la
        longitud de una circunferencia (2 * PI * radio),
        su area ( PI * radio * radio) 
        y el volumen de una esfera ( 4 * PI * radio * radio * radio / 3)
 */
package UML;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Circunferencia {
    //ATRIBUTOS
    private float radio;
    //CONSTRUCTOR(ES)
    public Circunferencia(){
        
    }
    public Circunferencia(float radio){
        this.radio = radio;
    }
    
    //GETTERS Y SETTERS

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    //Métodos
    public void calcularLongitud(float radio){
        JOptionPane.showMessageDialog(null, "la longitud de la circunferencia es de " + (2*Math.PI*radio));
    }
    public void calcularArea(){
        JOptionPane.showMessageDialog(null, "el área de esta circunferencia es de " + (Math.PI * radio * radio));
    }
    public double calcularVolumen(float radio){
        return (4*Math.PI*radio*radio*radio)/3;
    }
}
