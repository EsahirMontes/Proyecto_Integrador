/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Inventario {
    
    int id_inventario;
    int id_producto;
    String producto;
    int stock_actual;

    public Inventario() {
    }

    public Inventario(int id_inventario, int id_producto, String producto, int stock_actual) {
        this.id_inventario = id_inventario;
        this.id_producto = id_producto;
        this.producto = producto;
        this.stock_actual = stock_actual;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }
    
    
}
