/*
Apartir de un diagrama de clases, crea varios objetos de cada tipo y, 
por ultimo, muestra lo que se pide. 
no vamos a llevar a cabo validaciones ni a pedir datos de entrada.

    Ej1:En este ejercicio hay que mostrar el nombre del o de los estudios en
        los que se ha producido la pelıcula mas larga y el nombre del estudio ´
        que mas películas ha producido.
 */
package pro6p2e1;

import UML.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pro6p2e1 {

    /**
     * @param args the command line arguments
     */
    //ARRAYS COMO VARIABLE GLOBAL
    static ArrayList<Pelicula> todasPeliculas = new ArrayList();
    static Estudio[] todosEstudios = new Estudio[3];
    
    public static void main(String[] args) {
        crearEstudios();
        crearPeliculas();  
        estudioPeliculaMasLarga();
        estudioMasPeliculas();
        
    }
    public static void crearPeliculas(){
        Pelicula p = new Pelicula("ET");        
        Pelicula p1 = new Pelicula("Vengadores");
        Pelicula p2 = new Pelicula("Toy Story");
        p.setDuracion(1.5f);
        p1.setDuracion(2);
        p2.setDuracion(2.5f);
        ArrayList<Estudio>listaEstudios = new ArrayList();
        listaEstudios.add(todosEstudios[0]);
        p.setListaEstudios(listaEstudios);
        
        
    }
    public static void crearEstudios(){
        String[] telefonos=new String[1];
        telefonos[0]="663186261";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        todosEstudios[0]= new Estudio("Universal","vitoria","c/1","www.universal.com",LocalDate.parse("12/05/1992",formato),"españa",telefonos);
        telefonos=new String[1];
        telefonos[0]="674726831";
        todosEstudios[1] = new Estudio("Pixar","vitoria","c/1","www.pixar.com",LocalDate.parse("08/09/1980",formato),"españa",telefonos);
        telefonos=new String[1];
        telefonos[0]="676373192";
        todosEstudios[2]=  new Estudio("Pixar","vitoria","c/1","www.pixar.com",LocalDate.parse("08/09/1980",formato),"españa",telefonos);
    }
    public static void estudioPeliculaMasLarga(){
        
    }
    public static void estudioMasPeliculas(){
        
    }
}
