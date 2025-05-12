/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Productos;
import modelo.conexion;


public class DaoProductos {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Productos p){
        
        String insertSQL ="insert into productos (nombre_producto, marca, descripcion, id_categoria, stock_minimo) values (?,?,?,?,?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            //insertamos el producto
            ps = con.prepareStatement(insertSQL);
            ps.setString(1,p.getNombre_producto());
            ps.setString(2,p.getMarca());
            ps.setString(3,p.getDescripcion());
            ps.setInt(4,p.getId_categoria());
            ps.setInt(5,p.getStock_minimo());
            int n = ps.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se modifico ningún registro");
            return false;
        }
    }
}
