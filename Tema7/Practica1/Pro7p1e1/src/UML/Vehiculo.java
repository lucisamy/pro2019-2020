/*
De cada vehıculo queremos guardar su matrícula y marca. Hay que tener en
cuenta que existen diferentes tipos de vehículos (motos, coches y camiones).

Una persona puede disponer de varios vehıculos. Un vehıculo pertenece
solo a una persona. 
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Vehiculo {
    //variables propias
    private String matricula;
    
    //de la relación
    private Persona propietario;
    
    //Constructor
    
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo(String matricula, Persona propietario) {
        this.matricula = matricula;
        this.propietario = propietario;
    }
    
    //getters y setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
    
    
}
