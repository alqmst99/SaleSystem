package DAO;

import Model.Cliente;
import Model.Conecction;

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
public class ClienteDAO {

    //Conecction
    Conecction c = new Conecction();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;
//register Client
    public boolean RegistroCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        try {
            con = c.getConnection();
//Save into DB Client
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
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
    public List ListaCliente(){
        List<Cliente>ListaCl= new ArrayList();
        String sql= "SELECT * FROM clientes";
        try {
            con= c.getConnection();
            ps = con.prepareStatement(sql);
       
            rs= ps.executeQuery();
            while (rs.next()) {
                Cliente cl= new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getInt("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
                ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    
//Update Client
public boolean actualizarCliente(Cliente cl){
String sql= "UPDATE clientes SET dni=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
    try {
        ps= con.prepareStatement(sql);
        //data save
         ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.setInt(6, cl.getId());
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

public boolean EliminarCliente(int id){ 
    
String sql= "DELETE FROM clientes WHERE id= ?";
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

//Search Cliente by DNI
public Cliente BuscarCliente(int dni){
    Cliente producto = new Cliente();
    String sql= "SELECT * FROM clientes WHERE dni=?";
    try {
        con= c.getConnection();
         ps= con.prepareStatement(sql);
         ps.setInt(1, dni);
         rs= ps.executeQuery();
         if(rs.next()){
             producto.setNombre(rs.getString("nombre"));
             producto.setTelefono(rs.getInt("telefono"));
             producto.setDireccion(rs.getString("direccion"));
              producto.setRazon(rs.getString("razon"));
             
         }
        
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return producto;
}
}


