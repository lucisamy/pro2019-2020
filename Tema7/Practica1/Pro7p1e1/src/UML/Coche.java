/*
De coches existen las siguientes marcas: Audi, BMW, Renault, Hyundai y
Citroen.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Coche extends Vehiculo{
    
    private MarcasCoches marca;
    
    //Constructor
    
    public Coche(MarcasCoches marca, String matricula) {
        super(matricula);
        this.marca = marca;
    }

    public Coche(MarcasCoches marca, String matricula, Persona propietario) {
        super(matricula, propietario);
        this.marca = marca;
    }
    
       
    //getters y setters

    public MarcasCoches getMarca() {
        return marca;
    }

    public void setMarca(MarcasCoches marca) {
        this.marca = marca;
    }
    
}
    

