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

import modelo.Proveedor;

import modelo.conexion;

/**
 *
 * @author User
 */
public class DaoProveedor {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Proveedor pr){
        
        String insertSQL ="insert into proveedor (nombre_comercial, ruc, direccion, telefono) values (?,?,?,?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            //insertamos el proveedores
            ps = con.prepareStatement(insertSQL);
            ps.setString(1,pr.getNombre_comercial());
            ps.setString(2,pr.getRuc());
            ps.setString(3,pr.getDireccion());
            ps.setString(4,pr.getTelefono());
            
            
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
        List<Proveedor> listaPr = new ArrayList<>();
        String SQL ="select * from proveedor;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Proveedor pr = new Proveedor();
                pr.setId_proveedor(rs.getInt(1));
                pr.setNombre_comercial(rs.getString(2));
                pr.setRuc(rs.getString(3));
                pr.setDireccion(rs.getString(4));
                pr.setTelefono(rs.getString(5));
                
                listaPr.add(pr);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaPr;
    }
    public boolean editar(Proveedor pr){
       
        String SQL ="update proveedor set nombre_comercial = ?, ruc = ?, direccion = ?, telefono = ? where id_proveedor = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setString(1,pr.getNombre_comercial());
            ps.setString(2,pr.getRuc());
            ps.setString(3,pr.getDireccion());
            ps.setString(4,pr.getTelefono());
            ps.setInt(5,pr.getId_proveedor());
            
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
    public boolean eliminar(Proveedor pr){
        String SQL ="delete from proveedor where id_proveedor = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,pr.getId_proveedor());
            
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
    public boolean buscar(Proveedor pr){
        String SQL ="select * from proveedor where id_proveedor = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,pr.getId_proveedor());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                pr.setId_proveedor(rs.getInt(1));
                pr.setNombre_comercial(rs.getString(2));
                pr.setRuc(rs.getString(3));
                pr.setDireccion(rs.getString(4));
                pr.setTelefono(rs.getString(5));
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
