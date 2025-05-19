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

import modelo.Entradas;

import modelo.conexion;

/**
 *
 * @author User
 */
public class DaoEntradas {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Entradas en){
        //String checkSQL = "select count(*) from categorias where nombre_categoria = ?;";
        String insertSQL ="insert into entradas (id_compra, id_usuario, id_producto, tipo_unidad, cantidad, costo_unit, fecha_vencimiento, fecha_entrada) values (?,?,?,?,?,?,?,?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(insertSQL);
            ps.setInt(1,en.getId_compra());
            ps.setInt(2,en.getId_usuario());
            ps.setInt(3,en.getId_producto());
            ps.setString(4,en.getTipo_unidad());
            ps.setInt(5,en.getCantidad());
            ps.setDouble(6,en.getCosto_unit());
            ps.setDate(7,java.sql.Date.valueOf(en.getFecha_vencimiento()));// para fechas y tipo date en bd
            ps.setDate(8,java.sql.Date.valueOf(en.getFecha_entrada()));// para fechas y tipo date en bd
            
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
        List<Entradas> listaEn = new ArrayList<>();
        String SQL ="select * from entradas;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Entradas en = new Entradas();
                en.setId_entrada(rs.getInt(1));
                en.setId_compra(rs.getInt(2));
                en.setId_usuario(rs.getInt(3));
                en.setId_producto(rs.getInt(4));
                en.setTipo_unidad(rs.getString(5));
                en.setCantidad(rs.getInt(6));
                en.setCosto_unit(rs.getDouble(7));
                en.setFecha_vencimiento(rs.getDate(8).toLocalDate());
                en.setFecha_entrada(rs.getDate(9).toLocalDate());
                
                
                listaEn.add(en);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaEn;
    }
    public boolean editar(Entradas en){
       
        String SQL ="update entradas set id_compra = ?, id_usuario = ?, id_producto = ?, tipo_unidad = ?, cantidad = ?, costo_unit = ?, fecha_vencimiento = ?, fecha_entrada = ? where id_entrada = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,en.getId_compra());
            ps.setInt(2,en.getId_usuario());
            ps.setInt(3,en.getId_producto());
            ps.setString(4,en.getTipo_unidad());
            ps.setInt(5,en.getCantidad());
            ps.setDouble(6,en.getCosto_unit());
            ps.setDate(7,java.sql.Date.valueOf(en.getFecha_vencimiento()));
            ps.setDate(8,java.sql.Date.valueOf(en.getFecha_entrada()));
            ps.setInt(9,en.getId_entrada());
            
            
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
    public boolean eliminar(Entradas en){
        String SQL ="delete from entradas where id_entrada = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,en.getId_entrada());
            
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
    public boolean buscar(Entradas en){
        String SQL ="select * from entradas where id_entrada = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,en.getId_entrada());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                en.setId_entrada(rs.getInt(1));
                en.setId_compra(rs.getInt(2));
                en.setId_usuario(rs.getInt(3));
                en.setId_producto(rs.getInt(4));
                en.setTipo_unidad(rs.getString(5));
                en.setCantidad(rs.getInt(6));
                en.setCosto_unit(rs.getDouble(7));
                en.setFecha_vencimiento(rs.getDate(8).toLocalDate());
                en.setFecha_entrada(rs.getDate(9).toLocalDate());
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
