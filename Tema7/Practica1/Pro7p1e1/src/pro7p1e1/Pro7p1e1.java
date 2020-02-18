/*
Desarrolla un proyecto java que te permita guardar informacion para la 
DGT sobre las personas y sus vehıculos.
De cada persona queremos guardar su dni, nombre y apellidos, direccion
completa y su numero de telefono. 
De cada vehıculo queremos guardar su matrícula y marca. Hay que tener en
cuenta que existen diferentes tipos de vehículos (motos, coches y camiones).
De camiones existen las siguientes marcas: Scania, Man, Volvo y Mercedes.
De coches existen las siguientes marcas: Audi, BMW, Renault, Hyundai y
Citroen.
De motos existen las siguientes marcas: Kawasaki, Ducate y Harley-Davidson.
Una persona puede disponer de varios vehıculos. Un veh´ıculo pertenece
solo a una persona. 
Tras crear diferentes objetos de tipo persona y vehıculo con datos de entrada
validados y relacionarlos correctamente; muestra los siguientes datos:
    1.- Nombre de las personas con mas de un vehıculo.
    2.- Nombre de la persona que mas vehıculos tiene.
    3.- Nombre de la persona que mas motos tiene. 
    4.- ¿ Hay alguna persona que tenga una moto de la marca Ducate?
    5.- Lista ordenada alfabeticamente de todas las personas indicando su 
    numero de vehıculos.
 */
package pro7p1e1;

import UML.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Excepciones.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
/**
 *
 * @author Lucía
 */
public class Pro7p1e1 {

    /**
     * @param args the command line arguments
     */
    //GLOBALES
    static ArrayList<Persona>listaPersonas = new ArrayList();
    static ArrayList<Vehiculo>listaVehiculos = new ArrayList();
    public static void main(String[] args) {
        try{ 
            datosDeEntrada();
            pMasDe1Vehiculo();
            pMaxVehiculos();
            pMaxMotos();
            pBuscarDucate();
            listaOrdenada();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
        }
    }
    public static void datosDeEntrada()throws Exception{
        do{
            //crear Objetos persona con sus vehículos.solicitar datos para crear objeto persona
            Persona p = new Persona(solicitarDato("DNI",".+"),solicitarDato("Nombre",".+"),
                    solicitarDato("Apellidos",".+"),solicitarDato("Dirección completa",".+"),
                    solicitarDato("Teléfono",".+"),solicitarVehiculos());
            //falta relacionar cada objeto vehiculo con el propietario que acabamos de crear
            for(Vehiculo v: p.getVehículos()){
                v.setPropietario(p);
            }
            listaPersonas.add(p);
        }
        while(JOptionPane.showConfirmDialog(null, "Quieres continuar?")==0);
        
    }
    public static String solicitarDato(String campo,String expr)throws Exception{
        boolean error=true;
        String dato = "";
        do{
            try{
                Pattern p = Pattern.compile(expr);
                dato = JOptionPane.showInputDialog("Teclea " + campo);
                Matcher m = p.matcher(dato);
                if(!m.matches())
                    throw new DatoInvalidoException();
                error=false;
            }
            catch(DatoInvalidoException e){
                JOptionPane.showMessageDialog(null, "dato no válido");
            }
        }
        while(error);
        return dato;
    }
    public static ArrayList<Vehiculo>solicitarVehiculos()throws Exception{
        ArrayList<Vehiculo>vehiculosPersona = new ArrayList();
        //crear objetos vehículo y añadirlos al arraylist general si no están y al arraylist de la persona.
        int continuar;
        do{
            try{
                //solicitar datos de vehículo de la persona y crear objetos vehiculo.
                String matricula = solicitarDato("Matrícula del vehículo",".+");
                String tipoVehiculo="";
                //buscar si este vehiculo ya existe en el arraylist general de vehiculos
                int x;
                for(x=0;x<listaVehiculos.size()&&!listaVehiculos.get(x).getMatricula().equalsIgnoreCase(matricula);x++){}
                if(x<listaVehiculos.size())//encontró la matricula
                    //listaVehiculos.get(x); //me quedo con el objeto.
                    //buscar si este objeto vehículo ya existe en el arraylist de los  vehículos de la persona.
                    if(!vehiculosPersona.contains(listaVehiculos.get(x)))
                        //si ya existe no queremos hacer nada mas, si no existe lo añadimos a los vehiculos de la persona. 
                        vehiculosPersona.add(listaVehiculos.get(x));
                else //no existe vehiculo con esa matricula, pedimos el resto de datos para crear el objeto
                {    
                    tipoVehiculo = solicitarDato("Tipo de vehículo","(Coche|Camión|Moto)"); //FALTA CONTROL MAYUSCULAS Y MINUSCULAS.   
                    Vehiculo v = null;    
                    switch(tipoVehiculo){
                        case "Coche": 
                            v = new Coche(MarcasCoches.valueOf(solicitarDato("Marca del vehículo",".")), matricula);
                            break;
                        case "Camión":
                             v = new Camion(MarcasCamiones.valueOf(solicitarDato("Marca del vehículo",".")),matricula);
                            break;
                        case "Moto":
                            v = new Moto(MarcasMotos.valueOf(solicitarDato("Marca del vehículo",".")),matricula);
                    }
                    //ya está creado el objeto ahora lo agregamos a la lista general de vehículos y a la lista de la persona.
                    listaVehiculos.add(v);
                    vehiculosPersona.add(v);
                }
                continuar = JOptionPane.showConfirmDialog(null, "Continuar agregando vehículos a esta persona?");
            }
            catch(VehiculoRepetidoException e){
                JOptionPane.showMessageDialog(null, "Ya existe un vehículo con esa matrícula");
                continuar=0;
            }
        }
        while(continuar==0);
        return vehiculosPersona;
    }
    public static void pMasDe1Vehiculo(){
        //Conseguir Nombre de las personas con mas de un vehıculo.
        ArrayList<Persona>personasBuscadas = new ArrayList();
        /*Programación imperativa(tradicional): 
            recorrer el arraylist de personas, y para cada persona, acceder a su array de vehiculos y comprobar si size>1
        */
        for(int x=0;x<listaPersonas.size();x++){
            if(listaPersonas.get(x).getVehículos().size()>1)
                personasBuscadas.add(listaPersonas.get(x));
        }
        //mostrar
        //comprobar si el arraylist está  vacío, puede que no haya personas con mas de 1 vehiculo.
        String mensaje="";
        if(personasBuscadas.isEmpty())
            mensaje = "No hay personas con mas de 1 vehículo";
        else
        {
            mensaje="Personas con más de 1 vehículo: \n";
            for(Persona p:personasBuscadas){
                mensaje= mensaje + p.getNombre()+ " " + p.getApellidos()+"\n";
            } 
        }
        JOptionPane.showMessageDialog(null,mensaje);

        /*Programación funcional*/
        
        if(listaPersonas.stream().anyMatch(p->p.getVehículos().size()>1)){
            JOptionPane.showMessageDialog(null,"Personas con más de 1 vehículo: \n");
            //filtrar las personas que cumplan la condicion
            Stream<Persona> filter = listaPersonas.stream().filter(persona->persona.getVehículos().size()>1)
            /*listaPersonas.stream().filter(persona->persona.getVehículos().size()>1)
                    .forEach(p->JOptionPane.showMessageDialog(null, p.getNombre() + " " + p.getApellidos()));
            de esta forma saca un cuadro de diálogo por persona.
            */
            //quiero mostrar su nombre y su apellido de cada una de ellas en un únicoString
            //Es necesario cambiar el tipo de dato : stream-->String 
            //opciones: collect, map, toArray, toString
            //filter.collect(toList()); --> necesita de importación  Collectors
            
            
        }                    
        else
            JOptionPane.showMessageDialog(null, "No hay personas con mas de 1 vehículo");
    }
    public static void pMaxVehiculos(){}
    public static void pMaxMotos(){}
    public static void pBuscarDucate(){}
    public static void listaOrdenada(){}
    
}
