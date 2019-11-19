/*
    Ej7: Diseña un programa que a partir del importe de una venta y del
        pago del comprador, calcule la vuelta y el numero de monedas y/o
        billetes de cada clase que se deben entregar al comprador. 
        Para calcular las vueltas, intentamos devolver el mínimo numero 
        de billetes y/o monedas.
        
 */
package pro4p1e7;

import javax.swing.JOptionPane;
import Excepciones.*;

/**
 *
 * @author Lucía
 */
public class Pro4p1e7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //arrays
        try{
            float [] monedasYBilletes = new float [15];
            int [] contadores = new int [15];
            inicializarArrayBilletes(monedasYBilletes);
            float venta = datoEntrada("importe de la venta");
            float pago = datoEntrada("pago del cliente");
            float vuelta = pago - venta;
            if(vuelta<0)
                throw new PagoInsuficienteException();
            calcularVuelta(vuelta,monedasYBilletes,contadores);
            String mensajeSalida = "Se deben devolver: \n";
        }
        catch(PagoInsuficienteException e){
            JOptionPane.showMessageDialog(null, "El pago es insuficiente");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas \n" + e.getClass() + " " + e.getMessage());
           }
        
    }
    public static void inicializarArrayBilletes(float[] monedasYBilletes){
        monedasYBilletes[0]=500; //en ningun caso en una vuelta se dará un billete de 500.
        monedasYBilletes[1]=200;
        monedasYBilletes[2]=100;
        monedasYBilletes[3]=50;
        monedasYBilletes[4]=20;
        monedasYBilletes[5]=10;
        monedasYBilletes[6]=5;
        monedasYBilletes[7]=2;
        monedasYBilletes[8]=1;
        monedasYBilletes[9]=0.5f;
        monedasYBilletes[10]=0.2f;
        monedasYBilletes[11]=0.1f;
        monedasYBilletes[12]=0.05f;
        monedasYBilletes[13]=0.02f;
        monedasYBilletes[14]=0.01f;
    }
    public static float datoEntrada(String mensaje)throws Exception{
       float datoEntrada=0;
       boolean error;
       do{
            try{
                datoEntrada = Float.parseFloat(JOptionPane.showInputDialog("Teclee " + mensaje));
                if(datoEntrada<=0)
                    throw new ValorNoValidoException();
                error=false;
           }
            catch(ValorNoValidoException e){
               JOptionPane.showMessageDialog(null, "Escribe valor superior a 0");
               error=true;
           }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Sólo se pueden teclear números, no se puede dejar en blanco");
                error=true;
            }
            catch(NullPointerException e){
                if(JOptionPane.showConfirmDialog(null, "quieres salir del programa?")==0){
                    System.exit(0);
                    error=false;
                }
                else
                    error=true;
            }
       }
       while(error);
       return datoEntrada;
    }
    public static void calcularVuelta(float vuelta,float [] monedasYBilletes,int[] contadores){
        //repetitiva para contar cada billete y moneda
        for(int x=0;x<monedasYBilletes.length||vuelta>0;x++){
            if(vuelta<monedasYBilletes[x]){
                contadores[x]++;
                vuelta -= monedasYBilletes[x];
            }       
        }
        //repetitiva para mostrar totales por cada billete y moneda
        for(int x=0;x<contadores.length;x++){
            
        }
        
    }
}
