
package Modelo.UML;

/**
 *
 * @author Lucía
 */
public class Persona {
    String dni;
    String nombre;
    String apel1;
    String apel2;
    String tel;

    public Persona(String dni, String nombre, String apel1, String apel2, String tel) {
        this.dni = dni;
        this.nombre = nombre;
        this.apel1 = apel1;
        this.apel2 = apel2;
        this.tel = tel;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApel1() {
        return apel1;
    }

    public void setApel1(String apel1) {
        this.apel1 = apel1;
    }

    public String getApel2() {
        return apel2;
    }

    public void setApel2(String apel2) {
        this.apel2 = apel2;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
