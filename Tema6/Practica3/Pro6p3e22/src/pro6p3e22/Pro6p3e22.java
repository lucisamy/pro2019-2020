/*
Desarrolla un programa en java que te permita dar de alta obras.
El diagrama de clases que nos han pasado lo tienes en la imagen y las
condiciones que contempla son:
- Una obra tiene uno o mas artistas. Un artista puede haber creado 
una o mas obras.
- Hay tres tipos de obras: libros, discos y películas.
- Un artista puede intervenir como actor en cero o en muchas pelıculas.
Tras implementar el modelo, solicita datos, valida los y crea los objetos
necesarios. Todos los datos de entrada son obligatorios, para el año de edicion 
sólo son válidos los últimos cien.

al final también mostraremos la información de todas las obras y sus artistas.
 */
package pro6p3e22;

import UML.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Excepciones.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucía
 */
public class Pro6p3e22 {

    /**
     * @param args the command line arguments
     */
    //GLOBALES
    static ArrayList<Obra>listaObras = new ArrayList();
    static ArrayList<Artista>listaArtistas = new ArrayList();
    public static void main(String[] args) {
        int continuar;
        do{
            //primero se piden los datos comunes a todas las obras (se evita repetir la solicitud de estos datos)
            String titulo = solicitarDato("Titulo","Obra","^[A-Za-z0-9]+[]*[A-Za-z0-9]$");
            int año = solicitarAñoEdicion();//Integer.parseInt(solicitarDatoObra("Año de Edición","19[89][0-9]|20([01][0-9]|20)"))
            
            try{ //menu para decidir que tipo de obra añadir: libro, disco, pelicula
                int opc = Integer.parseInt(JOptionPane.showInputDialog("Elige tipo de obra: \n"
                                                                        + "1.Libro \n"
                                                                        + "2.Disco \n"
                                                                        + "3.Película"));
                switch(opc){//solicitar datos de entrada y validarlos, luego asignarlos al objeto y añadirlos a arrays.
                    //hay forma de controlar que no se agregue un mismo libro,disco,pelicula?
                    case 1: añadirLibro(titulo,año);
                            break;
                    case 2: añadirDisco(titulo,año);
                            break;
                    case 3: añadirPelicula(titulo,año);
                            break;
                    default: throw new OpcionInvalidaException();  
                }
                continuar = JOptionPane.showConfirmDialog(null, "Quieres continuar?");
            }
            catch(ObraYaExisteException e){
                JOptionPane.showMessageDialog(null, "Esta obra ya existe");
                continuar=0;
            }
            catch(OpcionInvalidaException e){
               JOptionPane.showMessageDialog(null, "opción no válida, teclear número 1,2 o 3");
               continuar=0;
            }
        }
        while(continuar==0);
        
        //falta método mostrar datos.
        /* los artistas se crean, se añaden al crear las obras.
        //añadir artistas.
        do{
            añadirArtista();
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar?")==0);
        */
    }
    public static String solicitarDato(String campo, String objeto, String expr){
        boolean error=true;
        String dato="";
        do {
            try{
                dato = JOptionPane.showInputDialog("Escribe " + campo + " de " + objeto);
                Pattern p = Pattern.compile(expr);
                Matcher m = p.matcher(dato);
                if(!m.matches())
                    throw new DatoInvalidoException();
                error=false;
            }
            catch(DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "dato no válido");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getClass() + " " + e.getMessage());
            }
        }
        while(error);
        return dato;
    }
    public static int solicitarAñoEdicion(){
        boolean error=true;
        int año = 0;
        int añoActual = LocalDate.now().getYear(); 
        int fechaMin = añoActual-100;
        do{
            try{
                año = Integer.parseInt(JOptionPane.showInputDialog("Teclea Año de Edición de la Obra"));
                if(año>añoActual||año<fechaMin)
                    throw new DatoInvalidoException();
                error=false;
            }
            catch(NumberFormatException |DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "año de edición no válido. NumberFormat");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getClass() + " " + e.getMessage());
            }
        }
        while(error);
        return año;
    }
    public static void añadirLibro(String titulo,int año)throws ObraYaExisteException{
        //revisamos si existe un libro con ese título ya en el array. 
        //el nombre podria aparecer varias veces en el array, no solo una: puede existir un libro y pelicula con mismo titulo.
        for(int x=0;x<listaObras.size();x++){
            if(listaObras.get(x).getTitulo().equalsIgnoreCase(titulo)&&listaObras.get(x) instanceof Libro)
            //si encuentra una obra con ese titulo revisar si la obra es de tipo libro.
            //si es de tipo libro lanzar excepción y mostrar que ese libro ya existe y volver a pedir titulo de obra.
                throw new ObraYaExisteException();   
        }
        //si no es de tipo libro o no se encuentra obra con ese título seguir:
        Libro l = new Libro(solicitarDato("Editorial","Libro","^([A-Z][a-z]+[]?)+[A-Za-z]$"),
                            Integer.parseInt(solicitarDato("Número de páginas","Libro","[1-9][0-9]*")),
                            titulo,año);
        //artistas creadores para este libro, los vamos añadiendo de uno en uno.
        do{
            l.setArtista(añadirArtista());//asignamos artista con libro
            //añadirArtista().setObra!!
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar agregando artistas para esta obra?")==0);
        listaObras.add(l);
    }
    public static void añadirDisco(String titulo,int año)throws ObraYaExisteException{
        //Revisamos si existe un disco con ese título ya en el array
        for(int x=0;x<listaObras.size();x++){
            if(listaObras.get(x).getTitulo().equalsIgnoreCase(titulo)&&listaObras.get(x) instanceof Disco)
                throw new ObraYaExisteException();
        }
        Disco d = new Disco(solicitarDato("Discográfica","Disco"," "),
                            solicitarDato("Numero de canciones","Disco"," "),
                            titulo,año);
        //artistas creadores para este disco, los vamos añadiendo de uno en uno.
        do{
            d.setArtista(añadirArtista());//asignamos artista con libro
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar agregando artistas para esta obra?")==0);
        listaObras.add(d);
    }
    public static void añadirPelicula(String titulo,int año)throws ObraYaExisteException{
        //Revisamos si existe una Película con ese título ya en el array
        for(int x=0;x<listaObras.size();x++){
            if(listaObras.get(x).getTitulo().equalsIgnoreCase(titulo)&&listaObras.get(x) instanceof Pelicula)
                throw new ObraYaExisteException();
        }
        Pelicula p = new Pelicula(solicitarDato("Productora","Película"," "),
            Integer.parseInt(solicitarDato("Duración","Película"," ")),titulo,año);
        //artistas creadores para esta película, los vamos añadiendo de uno en uno.
        do{
            p.setArtista(añadirArtista());//asignamos artista con libro
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar agregando artistas para esta obra?")==0);
        listaObras.add(p);
    }
    public static Artista añadirArtista(){
        //solicitar nombre
        String nombre = solicitarDato("nombre","artista","([A-Z][a-z]+[ ]?)+");
        //revisar si ya existe una rtista con ese nombre en el arraylist
        int x;
        for(x=0;x<listaArtistas.size()&&!listaArtistas.get(x).getNombre().equals(nombre);x++){}
        if(x==listaArtistas.size()){
            //este artista no está en el array. es un nuevo artista.
            //Solicitar fechaNacimiento
            String fecha = JOptionPane.showInputDialog("Teclea fecha de nacimiento del artista");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(fecha,dtf);
            //ya tenemos los datos del artista nuevo asi que creamos y llenamos objeto y agregamos a la lista
            Artista a = new Artista(nombre,fechaNacimiento);
            listaArtistas.add(a);
            return a;
        }
        else
        //el artista con ese nombre ya existe en el array de artistas asi que no creamos el objeto.
            return listaArtistas.get(x);
            //throw new ArtistaYaExisteException(); no queremos mostrar ningún error, solo asignar el artista a la obra
    }
}
