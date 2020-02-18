/*
Los metodos mostrar() devuelven un string con todos los datos del ´
objeto correspondiente.
Muestra el nombre del directivo que mas subordinados tiene.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Empleado extends Persona{
    //ATRIBUTOS PROPIOS
    private float sueldoBruto;
    
    //CONSTRUCTOR

    public Empleado(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Empleado(float sueldoBruto, String nombre, int edad) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }
    
    //GETTERS Y SETTERS

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(float sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    
    //MÉTODOS
    @Override
    public String mostrar(){
        return  this.getNombre() + ", " + this.getEdad() + " años, sueldo bruto: " + sueldoBruto;
    }
    
    public Double calcular_salario_neto(){
        return null;
    }
}
