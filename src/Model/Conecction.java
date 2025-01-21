package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Nahuel Pierini
* @Enterprise: FSTailSolution
 */
public class Conecction {

    Connection con;
    
    public Connection getConnection(){
        try {
            String myBD="jdbc:mysql://localhost:3306/sistemaventas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            
            System.out.println("The Connection is success");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
