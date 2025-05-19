/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    
    public List Listar(){
        List<Productos> listaP = new ArrayList<>();
        String SQL ="select * from productos;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Productos p = new Productos();
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setMarca(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setId_categoria(rs.getInt(5));
                p.setStock_minimo(rs.getInt(6));
                listaP.add(p);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaP;
    }
    public boolean editar(Productos p){
       
        String SQL ="update productos set nombre_producto = ?, marca = ?, descripcion = ?, id_categoria = ?, stock_minimo = ? where id_producto = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setString(1,p.getNombre_producto());
            ps.setString(2,p.getMarca());
            ps.setString(3,p.getDescripcion());
            ps.setInt(4,p.getId_categoria());
            ps.setInt(5,p.getStock_minimo());
            ps.setInt(6,p.getId_producto());
            
            int n = ps.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }
    public boolean eliminar(Productos p){
        String SQL ="delete from productos where id_producto = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,p.getId_producto());
            
            int n = ps.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }
    public boolean buscar(Productos p){
        String SQL ="select * from productos where id_producto = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,p.getId_producto());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                p.setId_producto(rs.getInt(1));
                p.setNombre_producto(rs.getString(2));
                p.setMarca(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setId_categoria(rs.getInt(5));
                p.setStock_minimo(rs.getInt(6));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
