/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import modelo.Inventario;
import modelo.conexion;

/**
 *
 * @author User
 */
public class DaoInventario {
    
//    Connection con;
//    conexion cn = new conexion();
//    PreparedStatement ps;
//    ResultSet rs;
    
//    public List Listar(){
//        List<Inventario> listaIn = new ArrayList<>();
//        String SQL ="select * from inventario;";
//        try{
//            con = cn.conectar();// hacemos la conexion a la BD
//                        
//            ps = con.prepareStatement(SQL);
//            rs = ps.executeQuery();
//            
//            while(rs.next()){
//                Inventario in = new Inventario();
//                in.setId_inventario(rs.getInt(1));
//                in.setId_producto(rs.getInt(2));
//                in.setProducto(rs.getString(3));
//                in.setStock_actual(rs.getInt(4));
//                
//                
//                listaIn.add(in);
//            }
//           
//        }catch(Exception e){
//            JOptionPane.showConfirmDialog(null, e);
//            
//        }
//        return listaIn;
//    }
    conexion con = new conexion(); // usamos tu clase de conexión

    public void cargarProductosEnTabla(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Descripción");
        modelo.addColumn("Stock Actual");

        try {
            Connection cn = con.conectar();
            Statement stmt = cn.createStatement();
            String sql = "SELECT p.nombre_producto, p.marca, p.descripcion,COALESCE(SUM(e.cantidad), 0) - COALESCE(SUM(s.cantidad), 0) AS stock FROM productos p LEFT JOIN entradas e ON p.id_producto = e.id_producto LEFT JOIN salidas s ON p.id_producto = s.id_producto GROUP BY p.nombre_producto, p.marca, p.descripcion;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("nombre_producto");
                fila[1] = rs.getString("marca");
                fila[2] = rs.getString("descripcion");
                fila[3] = rs.getInt("stock");
                modelo.addRow(fila);
            }

            tabla.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
