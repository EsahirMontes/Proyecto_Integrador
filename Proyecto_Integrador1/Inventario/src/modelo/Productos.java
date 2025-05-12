/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Productos {
    
    int id_producto;
    String nombre_producto;
    String marca;
    String descripcion;
    int id_categoria;
    int stock_minimo;

    public Productos() {
    }

    public Productos(int id_productos, String nombre_productos, String marca, String descripcion, int id_categoria, int stock_minimo) {
        this.id_producto = id_productos;
        this.nombre_producto = nombre_productos;
        this.marca = marca;
        this.descripcion = descripcion;
        this.id_categoria = id_categoria;
        this.stock_minimo = stock_minimo;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }
}
