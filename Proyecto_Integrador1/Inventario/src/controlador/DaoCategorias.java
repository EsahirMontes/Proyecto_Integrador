/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categorias;
import modelo.conexion;

public class DaoCategorias {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Categorias c){
        String checkSQL = "select count(*) from categorias where nombre_categoria = ?;";
        String insertSQL ="insert into categorias (nombre_categoria) values (?);";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            //Verificar si existe la categoria antes de insertar
            ps = con.prepareStatement(checkSQL);
            ps.setString(1, c.getNombre_categoria());
            rs = ps.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "La categoría ya existe.");
            return false;
            }
            //si no existe insertamos la categoria
            ps = con.prepareStatement(insertSQL);
            ps.setString(1,c.getNombre_categoria());
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
    
    public List Listar(){
        List<Categorias> listaC = new ArrayList<>();
        String SQL ="select * from categorias;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categorias c = new Categorias();
                c.setId_categoria(rs.getInt(1));
                c.setNombre_categoria(rs.getString(2));
                listaC.add(c);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaC;
    }
    
    public boolean editar(Categorias c){
       //String checkSQL = "select count(*) from categorias where nombre_categoria = ?;";
        String SQL ="update categorias set nombre_categoria = ? where id_categoria = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setString(1,c.getNombre_categoria());
            ps.setInt(2,c.getId_categoria());
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
    
    public boolean eliminar(Categorias c){
        String SQL ="delete from categorias where id_categoria = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,c.getId_categoria());
            
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
    public boolean buscar(Categorias c){
        String SQL ="select * from categorias where id_categoria = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,c.getId_categoria());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                c.setId_categoria(rs.getInt(1));
                c.setNombre_categoria(rs.getString(2));
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
