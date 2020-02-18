/*
De camiones existen las siguientes marcas: Scania, Man, Volvo y Mercedes.
 */
package UML;

/**
 *
 * @author Lucía
 */
public class Camion extends Vehiculo{
    private MarcasCamiones marca;
    
    //Constructor
    
    public Camion(MarcasCamiones marca, String matricula) {
        super(matricula);
        this.marca = marca;
    }

    public Camion(MarcasCamiones marca, String matricula, Persona propietario) {
        super(matricula, propietario);
        this.marca = marca;
    }
    
    //Getters y seters

    public MarcasCamiones getMarca() {
        return marca;
    }

    public void setMarca(MarcasCamiones marca) {
        this.marca = marca;
    }
    
    
}
