/*
Apartir de un diagrama de clases, crea varios objetos de cada tipo y, 
por ultimo, muestra lo que se pide. 
no vamos a llevar a cabo validaciones ni a pedir datos de entrada.

    Ej2:En este ejercicio hay que mostrar:
        - el nombre del o de los estudios en los que se ha producido la pelıcula más larga
        - el nombre del estudio que mas películas ha producido.
        
Un estudio produce muchas películas.
Una película es producida por uno o más estudios.
 */
package pro6p2e2;

import UML.Estudio;
import UML.Pelicula;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Lucía
 */
public class Pro6p2e2 {

    /**
     * @param args the command line arguments
     */
    //ARRAYS COMO VARIABLE GLOBAL
    static ArrayList<Pelicula> todasPeliculas = new ArrayList();
    static Estudio[] todosEstudios = new Estudio[5];
    
    public static void main(String[] args) {
        try{ 
            crearEstudios();
            crearPeliculas();  
            estudioPeliculaMasLarga();
            estudioMasPeliculas();
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,e.getClass());
        }
    }
     public static void crearEstudios() throws Exception{
        // Crear objetos de tipo estudio 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        
        // Lista de telefonos
        String[] telefonos=new String[2];
        telefonos[0]="111111111";
        telefonos[1]="111111112";
        //lista de películas
        ArrayList<Pelicula>listaPeliculas = new ArrayList();
        listaPeliculas.add(todasPeliculas.get(0));
        todosEstudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es",LocalDate.parse("1950-09-23",formato),"EEUU",telefonos,listaPeliculas);
        
        
        
        telefonos = new String[2];
        telefonos[0]="222222222";
        telefonos[1]="222222223";
        listaPeliculas = new ArrayList();
        todosEstudios[1] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",LocalDate.parse("1960-09-23",formato),"EEUU",telefonos,listaPeliculas);
        
        
        
        telefonos = new String[2];
        telefonos[0]="333333333";
        telefonos[1]="333333334";
        listaPeliculas = new ArrayList();
        
        //todosEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",LocalDate.parse("1956-01-10"),"EEUU",telefonos);
        todosEstudios[2] = new Estudio();
        todosEstudios[2].setNombre("Warner Bros");
        todosEstudios[2].setPais("EEUU");
        todosEstudios[2].setCiudad("California");
        todosEstudios[2].setDireccion(" C/ c");
        todosEstudios[2].setFechaFundacion(null);
        todosEstudios[2].setDirWeb("www.warner.es");
        todosEstudios[2].setTelefonos(telefonos);
        todosEstudios[2].setFechaFundacion(LocalDate.parse("1956-01-10"));
        todosEstudios[2].setListaPeliculas(listaPeliculas);
        
        
        telefonos = new String[2];
        telefonos[0]="444444444";
        telefonos[1]="444444445";
        listaPeliculas = new ArrayList();
        todosEstudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",LocalDate.parse("1955-09-23",formato),"EEUU",telefonos,listaPeliculas);
        
        
        
        telefonos = new String[2];
        telefonos[0]="555555555";
        telefonos[1]="555555556";
        listaPeliculas = new ArrayList();
        
        todosEstudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",sdf.parse("1953-09-23"),"EEUU",telefonos);
    }
    
    public static void crearPeliculas() throws Exception{
        // Creo peliculas ya con los estudios
        todasPeliculas = new ArrayList();
        
        // char[4] para el año
        char[] año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '8';
        año[3] = '0';
        // Estudios de la película
        ArrayList <Estudio> lista = new ArrayList();
        lista.add(todosEstudios[0]);
        lista.add(todosEstudios[2]);
        Pelicula p = new Pelicula("ET",año,90.7f,"Infantil",lista);
        todasPeliculas.add(p);
        
    
        año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '9';
        año[3] = '7';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(todosEstudios[1]);
        lista.add(todosEstudios[2]);
        todasPeliculas.add(new Pelicula("Titanic",año,180,"Romántica",lista));
        
        
        
        año = new char[4];
        año[0] = '2';
        año[1] = '0';
        año[2] = '0';
        año[3] = '3';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(todosEstudios[4]);
        todasPeliculas.add(new Pelicula("El señor de los anillos",año,133,"Ciencia ficción",lista));
        
        
        
        año = new char[4];
        año[0] = '2';
        año[1] = '0';
        año[2] = '0';
        año[3] = '3';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(todosEstudios[3]);
        lista.add(todosEstudios[4]);
        lista.add(todosEstudios[1]);
        lista.add(todosEstudios[2]);
        todasPeliculas.add(new Pelicula("Piratas del Caribe",año,220,"Aventuras",lista));
        
        
        
        año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '9';
        año[3] = '4';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(todosEstudios[1]);
        todasPeliculas.add(new Pelicula("El rey león",año,97,"Infantil",lista));
    
    }
}
