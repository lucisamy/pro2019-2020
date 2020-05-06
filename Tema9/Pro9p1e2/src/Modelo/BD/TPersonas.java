/*

 */
package Modelo.BD;

import java.sql.Connection;

/**
 *
 * @author Lucía
 */
public class TPersonas {
    
    Connection con;
    
    //Constructor de tabla con conexión

    public TPersonas(Connection con) {
        this.con = con;
    }
    
}
