/*
    Ej2: Crea una agenda con los datos de los alumnos de clase. 
        De cada alumno guarda su codigo, nombre, domicilio y telefono. 
        Una vez introducido sus datos, se visualizaran los datos del alumno que 
        corresponda con un codigo tecleado.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Alumno {
    private int cod;
    private String nombre;
    private String domicilio;
    private String tel;
    
    public Alumno() {
    
    }
    
    public Alumno(int cod, String nombre, String domicilio, String tel) {
        this.cod = cod;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tel = tel;
    }
    
    public Alumno(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    /*
    public boolean buscarAlumno(int cod){
        
    }*/
}
