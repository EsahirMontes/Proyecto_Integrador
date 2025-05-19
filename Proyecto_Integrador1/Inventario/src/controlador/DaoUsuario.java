/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



import modelo.conexion;
import modelo.usuarios;

public class DaoUsuario {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public usuarios login(String usuario, String pass){
        usuarios us = new usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' and password = '"+pass+"';";
        
        
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                us.setId_usuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setDoc_identidad(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setCargo(rs.getString(8));
                us.setUsuario(rs.getString(9));
                us.setPassword(rs.getString(10));

        }
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(DaoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, ex);
        }

       
        return us;
    }
    
    public boolean insert(usuarios us){
        
        String insertSQL ="insert into usuarios (nombre, apellido, doc_identidad, direccion, telefono, correo, cargo, usuario, password) values (?,?,?,?,?,?,?,?,?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            //insertamos los usuarios
            ps = con.prepareStatement(insertSQL);
            //ps.setInt(1,us.getId_usuario()); //es autoasignado, no se coloca
            ps.setString(1,us.getNombre());
            ps.setString(2,us.getApellido());
            ps.setString(3,us.getDoc_identidad());
            ps.setString(4,us.getDireccion());
            ps.setString(5,us.getTelefono());
            ps.setString(6,us.getCorreo());
            ps.setString(7,us.getCargo());
            ps.setString(8,us.getUsuario());
            ps.setString(9,us.getPassword());
            
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
        List<usuarios> listaU = new ArrayList<>();
        String SQL ="select * from usuarios;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuarios us = new usuarios();
                us.setId_usuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setDoc_identidad(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setCargo(rs.getString(8));
                us.setUsuario(rs.getString(9));
                us.setPassword(rs.getString(10));
                
                listaU.add(us);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaU;
    }
    public boolean editar(usuarios u){
       
        String SQL ="update usuarios set nombre = ?, apellido = ?, doc_identidad = ?, direccion = ?, telefono = ?, correo = ?, cargo = ?, usuario = ?, password = ? where id_usuario = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getApellido());
            ps.setString(3,u.getDoc_identidad());
            ps.setString(4,u.getDireccion());
            ps.setString(5,u.getTelefono());
            ps.setString(6,u.getCorreo());
            ps.setString(7,u.getCargo());
            ps.setString(8,u.getUsuario());
            ps.setString(9,u.getPassword());
            ps.setInt(10,u.getId_usuario());
            
            
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
    public boolean eliminar(usuarios us){
        String SQL ="delete from usuarios where id_usuario = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,us.getId_usuario());
            
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
    public boolean buscar(usuarios us){
        String SQL ="select * from usuarios where id_usuario = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,us.getId_usuario());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                us.setId_usuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setDoc_identidad(rs.getString(4));
                us.setDireccion(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setCorreo(rs.getString(7));
                us.setCargo(rs.getString(8));
                us.setUsuario(rs.getString(9));
                us.setPassword(rs.getString(10));
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
