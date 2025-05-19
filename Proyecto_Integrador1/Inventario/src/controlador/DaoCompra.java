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
import modelo.Compra;


import modelo.conexion;

/**
 *
 * @author User
 */
public class DaoCompra {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Compra co){
        //String checkSQL = "select count(*) from categorias where nombre_categoria = ?;";
        String insertSQL ="insert into compra (id_proveedor, fecha_compra,numero_documento) values (?,?,?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(insertSQL);
            ps.setInt(1,co.getId_proveedor());
            ps.setDate(2,java.sql.Date.valueOf(co.getFecha_compra()));// para fechas y tipo date en bd
            ps.setInt(3,co.getNumero_documento());
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
        List<Compra> listaCom = new ArrayList<>();
        String SQL ="select * from compra;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Compra co = new Compra();
                co.setId_compra(rs.getInt(1));
                co.setId_proveedor(rs.getInt(2));
                co.setFecha_compra(rs.getDate(3).toLocalDate());
                co.setNumero_documento(rs.getInt(4));
                
                listaCom.add(co);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaCom;
    }
    public boolean editar(Compra com){
       
        String SQL ="update compra set id_proveedor = ?, fecha_compra = ?, numero_documento = ? where id_compra = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,com.getId_proveedor());
            ps.setDate(2,java.sql.Date.valueOf(com.getFecha_compra()));
            ps.setInt(3,com.getNumero_documento());
            ps.setInt(4,com.getId_compra());
            
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
    public boolean eliminar(Compra com){
        String SQL ="delete from compra where id_compra= ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,com.getId_compra());
            
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
    public boolean buscar(Compra com){
        String SQL ="select * from compra where id_compra = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,com.getId_compra());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                com.setId_compra(rs.getInt(1));
                com.setId_proveedor(rs.getInt(2));
                com.setFecha_compra(rs.getDate(3).toLocalDate());
                com.setNumero_documento(rs.getInt(4));
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
