/*

 */
package UML;

/**
 *
 * @author Lucía
 */
public class Persona {
    private String nombre;
    private int edad;
    private String profesion;
    private String tel;
    
    //Constructor
    
    public Persona() {
    }

    public Persona(String nombre, int edad, String profesion, String tel) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.tel = tel;
    }
    
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
