/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;

public class DaoViewProductos {
    conexion con = new conexion(); // usamos tu clase de conexión

    public void cargarProductosEnTabla(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Descripción");
        modelo.addColumn("ID Categoría");
        modelo.addColumn("Nombre Categoría");

        try {
            Connection cn = con.conectar();
            Statement stmt = cn.createStatement();
            String sql = "SELECT p.id_producto, p.nombre_producto, p.marca, p.descripcion, c.id_categoria, c.nombre_categoria " +
                         "FROM productos p LEFT JOIN categorias c ON p.id_categoria = c.id_categoria";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getString("marca");
                fila[3] = rs.getString("descripcion");
                fila[4] = rs.getInt("id_categoria");
                fila[5] = rs.getString("nombre_categoria");
                modelo.addRow(fila);
            }

            tabla.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
