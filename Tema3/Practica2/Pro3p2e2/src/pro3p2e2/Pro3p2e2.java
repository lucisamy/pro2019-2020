/*
    Ej.2: En un cursillo de programacion se estudian cuatro lenguajes: 
        Visual.Net, Cobol, Java y SQL. La nota final del curso depende de una
        practica que se realiza en los cuatro lenguajes. ´
        La nota en cada una de las practicas es apto ono apto y la nota del curso
        puede ser un sobresaliente, notable, bien, suficiente o insuficiente.
        Para calcular la nota del curso hay que seguir las siguientes instrucciones:
        Apto en los cuatro lenguajes Sobresaliente
        Apto en SQL, Cobol y uno de los otros dos Notable
        Apto en Cobol y SQL Bien
        Apto en SQL y uno entre Java y Visual.Net Suficiente
        Apto en Cobol y uno entre Java y Visual.Net Suficiente
        Resto de los casos Insuficiente.
        Desarrolla un programa que permita visualizar la nota de los alumnos
        recibiendo por teclado el apto o no apto en cada uno de los lenguajes.
 */
package pro3p2e2;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Pro3p2e2 {

    /**
     * @param args the command line arguments
     */
    
    //Variables globales
    static String notaVisual,notaCobol,notaJava,notaSQL;
    
    public static void main(String[] args) {
        String lenguaje;
        String nota;
        //pedimos las 4 notas
        for(int c = 0;c<4;c++){
            switch(c){
                case 0: 
                    lenguaje = "Visual.Net";
                    break;
                case 1: 
                    lenguaje = "Cobol";
                    break;
                case 2: 
                    lenguaje = "Java";
                    break;
                default: 
                    lenguaje = "SQL";
                    break;
            }
            //recogemos y validamos dato de entrada
            nota = datosEntrada(lenguaje);
            //guardamos cada nota
            guardarNota(nota,c);
        }
        //valorar notas
        String resultado = valorarNota();
        //Mostramos datos de salida
        JOptionPane.showMessageDialog(null, "La nota del alumno es " + resultado);
    }
    public static String datosEntrada(String lenguaje){
        boolean error=true;
        String nota="";
        do{    
            try
            {   //Mostrar mensaje
                nota = JOptionPane.showInputDialog("Teclea nota del alumno en " + lenguaje);
                //validarNota
                if(nota.equalsIgnoreCase("apto") || nota.equalsIgnoreCase("no apto")){
                    error=false;     
                }
                else
                {
                    throw new AptoNoAptoException();
                } 
            }
            catch(AptoNoAptoException e){
                JOptionPane.showMessageDialog(null, "La nota debe ser: apto o no apto");
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas /n" + e.getClass());
                error=true;
            }
        }
        while(error == true);
        return nota;
    }
    public static String valorarNota(){
        String resultado="";
        if(notaVisual.equalsIgnoreCase("apto")&&notaCobol.equalsIgnoreCase("apto")&&notaJava.equalsIgnoreCase("apto")&&notaSQL.equalsIgnoreCase("apto"))
          resultado = "Sobresaliente";
        else{
            if(notaCobol.equalsIgnoreCase("apto")&&notaSQL.equalsIgnoreCase("apto"))
            {
                if(notaJava.equalsIgnoreCase("apto")||notaVisual.equalsIgnoreCase("apto"))
                    resultado = "Notable";
                else
                    resultado = "Bien";
            }
            else
            {
                if(notaCobol.equalsIgnoreCase("apto")||notaSQL.equalsIgnoreCase("apto"))
                {
                    if(notaJava.equalsIgnoreCase("apto")||notaVisual.equalsIgnoreCase("apto"))
                        resultado = "Suficiente";
                    else
                        resultado = "Insuficiente";
                }
                else
                    resultado = "Insuficiente";
            }
        }
        return resultado;
    }
    public static void guardarNota(String nota,int c){   
        switch(c){
            case 0: 
                notaVisual = nota;
                break;
            case 1: 
                notaCobol = nota;
                break;
            case 2: 
                notaJava = nota;
                break;
            default: 
                notaSQL = nota;
                break;
        }
    }
}
