/*
De motos existen las siguientes marcas: Kawasaki, Ducate y Harley-Davidson.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Moto extends Vehiculo{
    private MarcasMotos marca;
    
    //constructor
    
    public Moto(MarcasMotos marca, String matricula) {
        super(matricula);
        this.marca = marca;
    }

    public Moto(MarcasMotos marca, String matricula, Persona propietario) {
        super(matricula, propietario);
        this.marca = marca;
    }
    //getters y setters

    public MarcasMotos getMarca() {
        return marca;
    }

    public void setMarca(MarcasMotos marca) {
        this.marca = marca;
    }
    
    
}
