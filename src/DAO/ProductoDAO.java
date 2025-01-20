/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Model.Conecction;
import Model.Config;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Nahuel Pierini
* @Enterprise: FSTailSolution
 */
public class ProductoDAO {

    //Conecction
    Conecction c = new Conecction();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;
    
    //Create Producto
    public boolean CreateProducto(Producto pro){
        String sql= "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES(?,?,?,?,?)";
        try {
             con = c.getConnection();
             
             //Save producto
             ps= con.prepareStatement(sql);
             ps.setString(1, pro.getCodigo());
             ps.setString(2, pro.getNombre());
             ps.setString(3, pro.getProveedor());
             ps.setInt(4, pro.getStock());
             ps.setDouble(5, pro.getPrecio());
             ps.execute();
             
             return true;
        
        } catch (SQLException e) { 
            System.out.println(e.toString());
            return false;
        }
    }
    
    //List Combobox Proveedor
    public void CosultaProveedor(JComboBox prov){
        String sql= "SELECT nombre FROM proveedor";
        try {
             con = c.getConnection();
             //Save Proveedor
             ps= con.prepareStatement(sql);
             rs= ps.executeQuery();
             while(rs.next()){
                 prov.addItem(rs.getString("nombre"));
             }
             
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    //List Pruducto
     public List ListaProducto(){
        List <Producto> ListaProd= new ArrayList();
        String sql= "SELECT * FROM productos";
        try {
            con= c.getConnection();
            ps = con.prepareStatement(sql);
       
            rs= ps.executeQuery();
            while (rs.next()) {
                Producto prod= new Producto();
                prod.setId(rs.getInt("id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setProveedor(rs.getString("proveedor"));
                prod.setStock(rs.getInt("stock"));
                prod.setPrecio(rs.getDouble("precio"));
                ListaProd.add(prod);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaProd;
    }
     
    //Update Produtos 
 
public boolean actualizarProducto(Producto prod){
String sql= "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
    try {
        ps= con.prepareStatement(sql);
        //data save
         ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getProveedor());
            ps.setInt(4, prod.getStock());
            ps.setDouble(5, prod.getPrecio());
            ps.setInt(6, prod.getId());
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

//Delete Productos

public boolean EliminarProducto(int id){ 
    
String sql= "DELETE FROM productos WHERE id= ?";
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


//Search Producto by code

public Producto searchPro(String cod){
    Producto producto = new Producto();
    String sql= "SELECT * FROM productos WHERE codigo=?";
    try {
        con= c.getConnection();
         ps= con.prepareStatement(sql);
         ps.setString(1, cod);
         rs= ps.executeQuery();
         if(rs.next()){
             producto.setNombre(rs.getString("nombre"));
             producto.setPrecio(rs.getDouble("precio"));
             producto.setStock(rs.getInt("stock"));
         }
        
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return producto;
}

 //Search Datos by config
    public Config searchDatos() {
        Config conf = new Config();
        String sql = "SELECT * FROM config ";
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
           
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setCuit(rs.getInt("cuit"));
                conf.setNombre(rs.getString("nombre"));
                conf.setTelefono(rs.getInt("telefono"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setRazon(rs.getString("razon"));
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }
    
    
      //Update Datos in Config
 
public boolean actualizarDatos(Config conf){
String sql= "UPDATE config SET cuit=?, nombre=?, telefono=?,direccion=?, razon=? WHERE id=?";
    try {
        ps= con.prepareStatement(sql);
        //data save
         ps.setInt(1, conf.getCuit());
            ps.setString(2, conf.getNombre());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getRazon());
            ps.setInt(6, conf.getId());
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