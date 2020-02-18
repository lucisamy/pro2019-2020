/*
Crea un proyecto con una ventana que te permita obtener los datos de
un grupo de personas (nombre, apellidos y dni). Cuando el usuario
termine de teclear los datos (clic del boton salir), mostraremos en una ´
segunda ventana todos los datos de todas las personas.
En la primera ventana hay etiquetas, cajas de texto y botones. En la
segunda una etiqueta,un textarea y el boton para finalizar la ejecuci ´ on´
del ejercicio.

 */
package UML;

/**
 *
 * @author Lucía
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
