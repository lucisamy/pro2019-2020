/*
Crea un proyecto con una ventana que te permita obtener los datos de
un grupo de personas (nombre, apellidos y dni). 
Cuando el usuario termine de teclear los datos (clic del boton salir),
mostraremos en una segunda ventana todos los datos de todas las personas.
En la primera ventana hay etiquetas, cajas de texto y botones.
En la segunda una etiqueta,un textarea y el boton para finalizar la ejecucion
del ejercicio.
 */
package pro8p1e2;

import UML.Persona;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro8p1e2 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Persona>listaPersonas;
    static VentanaPrincipal vp;
    static VListado vLista;
    public static void main(String[] args) {
        listaPersonas = new ArrayList();
        vp = new VentanaPrincipal();
        vp.setVisible(true);
    }
    public static void altaPersonas(String nombre,String apellidos,String dni){
        //revisar si Dni ya existe en el arraylist
        //opcion1: si existe no se hace nada, no se añade y ya está. no se da ningún aviso.
        //programación funcional
        //final String dni2 = dni;
        if(!listaPersonas.stream().anyMatch(p->p.getDni().equals(dni)))
        {    listaPersonas.add(new Persona(nombre,apellidos,dni));
            JOptionPane.showMessageDialog(vp, "Alta correcta");
        }
        else
            vp.dniExistente();
        vp.limpiar();
        //opcion2: queremos dar un aviso de error si el dni ya existe
        /*programación con for tradicional
        int x;
        for(x=0;x<listaPersonas.size()&&!listaPersonas.get(x).getDni().equals(dni);x++){}
        if(x<listaPersonas.size())//si encuentra el dni
            vp.dniExistente();
        else
            listaPersonas.add(new Persona(nombre,apellidos,dni));
        vp.limpiar();
        */
    }
    public static void salirV1(){
        vp.dispose();
        //Crear lista
        String lista="";
        for(Persona p : listaPersonas){
            lista = lista + p.getNombre() + " " + p.getApellidos() + " " + p.getDni() + "\n";
        }
        vLista = new VListado(lista);
        vLista.setVisible(true);
    }
    public static void salir(){
        vLista.dispose();
        System.exit(0);
    }
}
