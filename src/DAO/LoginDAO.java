package DAO;

import Model.Conecction;
import Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nahuel Pierini
 * @Enterprise: FSTailSolution
 */
public class LoginDAO {

    Connection con;

    PreparedStatement ps;

    ResultSet rs;

    Conecction cn = new Conecction();
    
    //Login method with Usuario

    public Login login(String email, String password) {
        Login l = new Login();
        String sql = "SELECT * FROM usuarios WHERE email=? AND password= ?";
        try {
            //initial coneection
            con = cn.getConnection();
//Sent promp to DB
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
if(rs.next()){
    //save data login 
    l.setId(rs.getInt("id"));
    l.setNombre(rs.getString("nombre"));
    l.setEmail(rs.getString("email"));
    l.setPassword(rs.getString("password"));
    l.setRol(rs.getString("rol"));
}
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    //Register Usuario method
    
    public boolean Registrar(Login reg){
        String sql = "INSERT INTO usuarios (nombre,email, password, rol) VALUE (?, ?, ?, ?)";
        try {
            //initial coneection
            con = cn.getConnection();
//Sent promp to DB
            ps = con.prepareStatement(sql);
            
            //charge in DB data of Usuario
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getEmail());
            ps.setString(3, reg.getPassword());
            ps.setString(4, reg.getRol());
            ps.execute();
            return true;
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
