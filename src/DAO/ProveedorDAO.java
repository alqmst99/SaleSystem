

package DAO;

import Model.Cliente;
import Model.Conecction;
import Model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel Pierini
* @Enterprise: FSTailSolution
 */
public class ProveedorDAO {
 //Conecction
    Conecction c = new Conecction();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;
    
    //Register Provider
    public boolean RegistroProv(Proveedor pr) {
        String sql = "INSERT INTO proveedor (cuit, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        try {
            con = c.getConnection();
//Save into DB Provider
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getCuit());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
               
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    // List Client
    public List ListaProveedor(){
        List<Proveedor>ListaPr= new ArrayList();
        String sql= "SELECT * FROM proveedor";
        try {
            con= c.getConnection();
            ps = con.prepareStatement(sql);
       
            rs= ps.executeQuery();
            while (rs.next()) {
                Proveedor cl= new Proveedor();
                cl.setId(rs.getInt("id"));
                cl.setCuit(rs.getInt("cuit"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
                ListaPr.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;
    }
    
    //Update Client
public boolean actualizarProveedo( Proveedor pr){
String sql= "UPDATE proveedor SET cuit=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
    try {
        ps= con.prepareStatement(sql);
        //data save
         ps.setInt(1, pr.getCuit());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.setInt(6, pr.getId());
            ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }finally{
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

//Delete Client

public boolean EliminarProveedor(int id){
String sql= "DELETE FROM proveedor WHERE id= ?";
    try { 
        ps= con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }finally{
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    }
}
}

