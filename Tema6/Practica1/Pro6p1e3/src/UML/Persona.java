/*
    Ej3:Define una clase Persona con los siguientes datos: 
        nombre, dNacimiento (dıa de nacimiento), 
        mNacimiento (mes de nacimiento), aNacimiento (año de nacimiento),
        direccion, codigo postal y ciudad. 
        Crea varios objetos de tipo Persona y a traves de un programa muestra
        los siguientes datos:
        -Nombre de la persona de mayor edad.
        -Nombre de las personas que viven en Elche.
        -Numero de personas mayores de edad. 
        Hay que comprobar que todos los campos contienen informacion y ´
        que es logica.
 */
package UML;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucía
 */
public class Persona {
    //ATRIBUTOS
    private String nombre;
    private int dNacimiento;
    private int mNacimiento;
    private int aNacimiento;
    private String direccion;
    private String codPostal;
    private String ciudad;
    
    //CONSTRUCTOR

    public Persona() {
    }

    public Persona(String nombre, int dNacimiento, int mNacimiento, int aNacimiento, String direccion, String codPostal, String ciudad) {
        this.nombre = nombre;
        this.dNacimiento = dNacimiento;
        this.mNacimiento = mNacimiento;
        this.aNacimiento = aNacimiento;
        this.direccion = direccion;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
    }
    
    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getdNacimiento() {
        return dNacimiento;
    }

    public void setdNacimiento(int dNacimiento) {
        this.dNacimiento = dNacimiento;
    }

    public int getmNacimiento() {
        return mNacimiento;
    }

    public void setmNacimiento(int mNacimiento) {
        this.mNacimiento = mNacimiento;
    }

    public int getaNacimiento() {
        return aNacimiento;
    }

    public void setaNacimiento(int aNacimiento) {
        this.aNacimiento = aNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    //OTROS MÉTODOS
    public int getEdad(){
        LocalDate fNacimiento = LocalDate.of(aNacimiento,mNacimiento,dNacimiento);
        //problemas con escribir números en 2 dígitos <10? por ejemplo "01"?
        Period edad = Period.between(fNacimiento, LocalDate.now());
        return edad.getYears();
    }
    public boolean isMayor(){        
        if(getEdad()>=18)
            return true;
        else
            return false;
    }
}
