/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Lucía
 */
public class DatoInvalidoException extends Exception{
    private String campo;

    public DatoInvalidoException(String campo) {
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
    
    @Override
    public String getMessage(){
        String mensaje="";
        switch(campo){
            case "tfNombre":
                mensaje = "Nombre incorrecto";
                break;
            case "tfApellidos":
                mensaje = "Apellidos incorrectos";
                break;
            case "tfDni":
                mensaje = "Dni incorrecto";
        }
        return mensaje;
    }
    
}
