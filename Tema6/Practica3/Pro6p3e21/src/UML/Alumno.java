/*
Crea una agenda con los datos de todos los alumnos de Arriaga Egibide.
De cada alumno hay que guardar su codigo (5 dıgitos numericos), nombre, 
domicilio, telefono, edad, sexo (H, M u O), fecha de nacimiento, 
direccion de correo electronico personal, direccion de correo electronico 
del centro (ikasle.egibide.org), pagina web (www.), curso (141GA) y estado civil
(casado o soltero).
Una vez introducidos todos los datos, se visualizaran los del alumno cuyo codigo
nos tecleen. 
Hay que comprobar que los campos contienen informacion y que es logica.
La direccion de la pagina web es opcional. 
En cuanto al curso tener en cuenta la siguiente estructura:
- El primer dıgito representa el centro (1 - Arriaga).
- El segundo dıgito representa el nivel (1- ESO 2-Bachiller 3-CFGM 4-CFGS).
- El tercer dıgito representa el curso (En la ESO hay cuatro, en el resto
de los niveles dos).
- Letra que identifica el ciclo o el curso.
- Letra que indica el modelo (A, B o D).
 */
package UML;

import java.time.LocalDate;

/**
 *
 * @author Lucía
 */
public class Alumno {
    
    private String cod;
    private String nombre;
    private String domicilio;
    private String tel;
    private int edad;
    private char sexo;
    private LocalDate fechaNacimiento;
    private String emailPersonal;
    private String emailEgibide;
    private String web;
    private String curso;
    private String estadoCivil;
    
    //CONSTRUCTOR

    public Alumno() {
    }

    public Alumno(String cod, String nombre, String domicilio, String tel, int edad, char sexo, LocalDate fechaNacimiento, String emailPersonal, String emailEgibide, String web, String curso, String estadoCivil) {
        this.cod = cod;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tel = tel;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.emailPersonal = emailPersonal;
        this.emailEgibide = emailEgibide;
        this.web = web;
        this.curso = curso;
        this.estadoCivil = estadoCivil;
    }
    
    //getters y setters
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailEgibide() {
        return emailEgibide;
    }

    public void setEmailEgibide(String emailEgibide) {
        this.emailEgibide = emailEgibide;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
}
