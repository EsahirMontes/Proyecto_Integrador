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
//import java.sql.SQLException;
import modelo.Salidas;

import modelo.conexion;

public class DaoSalidas {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insert(Salidas sa) {
        
        String insertSQL ="insert into salidas (id_usuario, id_producto, tipo_unidad, cantidad, costo_unit, fecha_salida, motivo_salida) values (?,?,?,?,?,?,?);";
        //ad
        String selectEntradaSQL = "select tipo_unidad, costo_unit from entradas where id_producto = ? order by id_entrada asc limit 1";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            //obtener datos de entradas
            ps = con.prepareStatement(selectEntradaSQL);
            ps.setInt(1, sa.getId_producto());
            rs = ps.executeQuery();
            //
            if (rs.next()) {
            String tipoUnidad = rs.getString("tipo_unidad");
            double costoUnit = rs.getDouble("costo_unit");

            // Paso 2: ahora hacemos el insert en salidas con los datos recuperados
            ps = con.prepareStatement(insertSQL);

            ps.setInt(1, sa.getId_usuario());
            ps.setInt(2, sa.getId_producto());
            ps.setString(3, tipoUnidad); // lo que recuperamos de entradas
            ps.setInt(4, sa.getCantidad());
            ps.setDouble(5, costoUnit);  // lo que recuperamos de entradas
            ps.setDate(6, java.sql.Date.valueOf(sa.getFecha_salida()));
            ps.setString(7, sa.getMotivo_salida());

            int n = ps.executeUpdate();
            return n != 0;

        } else {
            JOptionPane.showMessageDialog(null, "No se encontró información en 'entradas' para el producto.");
            return false;
        }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se modifico ningún registro");
            return false;
        }
    }
    
    public List Listar(){
        List<Salidas> listaSa = new ArrayList<>();
        String SQL ="select * from salidas;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
                        
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Salidas sa = new Salidas();
                sa.setId_salida(rs.getInt(1));                
                sa.setId_usuario(rs.getInt(2));
                sa.setId_producto(rs.getInt(3));
                sa.setTipo_unidad(rs.getString(4));
                sa.setCantidad(rs.getInt(5));
                sa.setCosto_unit(rs.getDouble(6));
                sa.setFecha_salida(rs.getDate(7).toLocalDate());
                sa.setMotivo_salida(rs.getString(8));
                
                
                listaSa.add(sa);
            }
           
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return listaSa;
    }
    public boolean editar(Salidas sa){
       
        String SQL ="update salidas set id_usuario = ?, id_producto = ?, cantidad = ?, fecha_salida = ?, motivo_salida = ? where id_salida = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            
            ps.setInt(1,sa.getId_usuario());
            ps.setInt(2,sa.getId_producto());
            ps.setInt(3,sa.getCantidad());
            ps.setDate(4,java.sql.Date.valueOf(sa.getFecha_salida()));
            ps.setString(5,sa.getMotivo_salida());
            ps.setInt(6,sa.getId_salida());
            
            
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
    public boolean eliminar(Salidas sa){
        String SQL ="delete from salidas where id_salida = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,sa.getId_salida());
            
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
    public boolean buscar(Salidas sa){
        String SQL ="select * from salidas where id_salida = ?;";
        try{
            con = cn.conectar();// hacemos la conexion a la BD
            
            ps = con.prepareStatement(SQL);
            ps.setInt(1,sa.getId_salida());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                sa.setId_salida(rs.getInt(1));
                sa.setId_usuario(rs.getInt(2));
                sa.setId_producto(rs.getInt(3));
                sa.setTipo_unidad(rs.getString(4));
                sa.setCantidad(rs.getInt(5));
                sa.setCosto_unit(rs.getDouble(6));
                sa.setFecha_salida(rs.getDate(7).toLocalDate());
                sa.setMotivo_salida(rs.getString(8));
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
