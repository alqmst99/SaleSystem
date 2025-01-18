
package DAO;

import Model.Conecction;
import Model.Detalle;
import Model.Ventas;

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
public class VentasDAO {
  //Conecction
    Conecction c = new Conecction();

    Connection con;

    PreparedStatement ps;

    ResultSet rs;
    
    int r;
//register Client
    public int RegistroCliente(Ventas v) {
        String sql = "INSERT INTO ventas (cliente, vendedor, total) VALUES (?,?,?)";
        try {
            con = c.getConnection();
//Save into DB Client
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
           
            ps.execute();
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            
        }finally{
            try {
                con.close();
               
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
           
        }
         return r;
    }

    // Max id ventas
   public int MaxVenta(){
       
        int id=0;
        String sql= "SELECT MAX(id)FROM ventas";
        try {
            con= c.getConnection();
            ps = con.prepareStatement(sql);
       
            rs= ps.executeQuery();
            if (rs.next()) {
             id=rs.getInt(1);
            }
        } catch (SQLException  e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
    //Register Detalle Venta
    public int RegistrarDetalleVenta(Detalle dv){
        String sql="INSERT INTO detalle (codigo_pro, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
        try {
            con= c.getConnection();
            ps = con.prepareStatement(sql);
            
            //Save data in datalle
            ps.setString(1,dv.getCod_pro() );
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio());
            ps.setInt(4, dv.getId());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
               
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        return r;
    }
    
}
    
    //Update Stcok
    public boolean ActualizarStock(int cant, String cod){
        String sql="UPDATE productos set Stock = ? WHERE codigo = ?";
        try {
             con= c.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}