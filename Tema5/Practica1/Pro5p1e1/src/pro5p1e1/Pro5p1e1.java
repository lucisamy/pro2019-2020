/*
Ej1: Crea un arraylist para guardar valores de tipo real (Float o Double) 
    que iremos introduciendo por teclado hasta finalizar (mientras quiera continuar).
    Posteriormente muestra un menu para que el usuario pueda realizar las 
    siguientes operaciones:
        1. Visualizar el valor maximo y el mínimo.
        2. Solicitar un numero y buscarlo. Muestra un mensaje indicando si lo
            has encontrado o no.
        3. Solicitar un numero, buscarlo y borrarlo. Sino se encuentra muestra
            un mensaje de error.
        4. Convertir el arrayList en un array.
        5. Si no esta vacío, mostrar el número de elementos que contiene. 
        6. Insertar un nuevo elemento por el final.
        7. Insertar un nuevo elemento en la posicion que te indique el usuario. 
        8. Borrar un elemento de una posicion concreta. 
        9. Calcular la suma y la media aritmetica de los valores contenidos. 
        10. Finalizar
 */
package pro5p1e1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro5p1e1 {

    /**
     * @param args the command line arguments
     */
    //GLOBALES
    // arrayList
    static  ArrayList<Float> lista = new ArrayList();
    public static void main(String[] args) {    
        int respuesta=0;
        int opc;
        /* for no es la mejor repetitiva para llenar un arrayList
        for(int x=0;respuesta==0;x++){
            lista.add(x,Float.parseFloat("Escriba un número"));
            respuesta = JOptionPane.showConfirmDialog(null, "Quieres continuar?");
        }
        */
        do{
            try{
                lista.add(Float.parseFloat(JOptionPane.showInputDialog("Escriba un número")));
                respuesta = JOptionPane.showConfirmDialog(null, "Quieres continuar?");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getMessage() + " " + e.getMessage());
            }
        }
        while(respuesta==0);
        do{
            opc = mostrarMenu();
            switch(opc){
                case 1:maxYmin();
                break;
                case 2:buscarNumero();
                break;
                case 3:borrarNumero();
                break;
                case 4:convertirEnArray();
                break;
                case 5:mostrarTamaño();
                break;
                case 6:insertarElemento();
                break;
                case 7:insertarEnPosicion();
                break;
                case 8:borrarDePosicion();
                break;
                case 9:sumaYmedia();
                break;
                    
            }
        }
        while(opc!=10);
        
    }
    public static int mostrarMenu(){
        boolean error=true;
        int opc=0;
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog("Menú Elige una opción \n"
                                                                    + "1.Visualizar el valor maximo y el mínimo \n"
                                                                    + "2.Buscar un número \n"
                                                                    + "3.Buscar y borrar un número \n"
                                                                    + "4.Convertir el arrayList en un array \n"
                                                                    + "5.Mostrar el número de elementos \n"
                                                                    + "6.Insertar un nuevo elemento por el final \n"
                                                                    + "7.Insertar un nuevo elemento en una posicion concreta \n"
                                                                    + "8.Borrar un elemento de una posicion concreta \n"
                                                                    + "9.Calcular la suma y la media aritmetica de los valores contenidos \n"
                                                                    + "10.Finalizar"));
                if(opc<1||opc>10)
                    throw new OpcionNoValidaException();
                error=false;
            }
            catch(OpcionNoValidaException e){
                JOptionPane.showMessageDialog(null, "Opcion no válida, debe ser un número entre 0 y 10");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
            }
        }
        while(error);
        return opc;
    }
    public static void maxYmin(){
        //recorrer array buscando maximo valor y minimo valor.
        //ordenarlo y coger primera y ultima posicion?
            //identificar el max e ir moviéndolo al final.
        float max;
        float ultimo;
        int tamaño = lista.size();
         
        for(int y = 0;y<2;y++,tamaño--){
            max=0;
        /*obligamos a hacer todo 2 veces,
            cada vez inicializamos el valor max a 0 
            y segunda vez solo nos fijamos en el array menos el ultimo número*/
            for(int x=0;x<tamaño;x++){ //esta repetitiva colocará el número mayor al final

               if(lista.get(x)>max){
                   max = lista.get(x);
                   ultimo = lista.get(tamaño -1);
                   lista.set(tamaño -1, max);
                   lista.set(x, ultimo);
               }
           }
        }
        
    }
    public static void buscarNumero(){
        Float n = pedirNumero();
        if(lista.contains(n))
            JOptionPane.showMessageDialog(null, "Número encontrado");
        
        else
            JOptionPane.showMessageDialog(null, "Número no encontrado");
        
    }
    public static void borrarNumero(){
        
    }
    public static void convertirEnArray(){
        //primera forma:
        Object [] arrayLista = lista.toArray();
        //segunda forma:
        
        
        
        JOptionPane.showMessageDialog(null, "Se ha convertido a un array de " + arrayLista.length + " elementos");
    }
    public static void mostrarTamaño(){
        try{
            if(lista.size()>0){
                JOptionPane.showMessageDialog(null, "El arraylist tiene: " + lista.size() + " elementos.");
            }
            else
                throw new ArrayVacioException();
            }
        catch(ArrayVacioException e){
            JOptionPane.showMessageDialog(null, "El arraylist está vacío");
        }
    }
    public static void insertarElemento(){
        lista.add(pedirNumero());
        JOptionPane.showMessageDialog(null, "Elemento añadido");
    }
    public static void insertarEnPosicion(){
        int posicion = pedirNumero().intValue();
        lista.add(posicion,pedirNumero());
        JOptionPane.showMessageDialog(null, "Elemento añadido en la posición " + posicion);
    }
    public static void borrarDePosicion(){
        int posicion = pedirNumero().intValue();
        lista.remove(posicion);
        JOptionPane.showMessageDialog(null, "Elemento de la posicion " + posicion + " borrado");
    }
    public static void sumaYmedia(){
        
    }
    public static Float pedirNumero(){
        Float n=0f;
        boolean error=false;
        do{
            try{
                n = Float.parseFloat(JOptionPane.showInputDialog("Teclea un número"));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas");
                error=true;
            }
        }
        while(error);
        return n;
    }

}
