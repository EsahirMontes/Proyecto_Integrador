/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
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
    
}
