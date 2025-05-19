/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

public class Entradas {
    int id_entrada;
    int id_compra;
    int id_usuario;
    int id_producto;
    String tipo_unidad;
    int cantidad;
    double costo_unit;
    LocalDate fecha_vencimiento;
    LocalDate fecha_entrada;

    public Entradas() {
    }

    public Entradas(int id_entrada, int id_compra, int id_usuario, int id_producto, String tipo_unidad, int cantidad, double costo_unit, LocalDate fecha_vencimiento, LocalDate fecha_entrada) {
        this.id_entrada = id_entrada;
        this.id_compra = id_compra;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.tipo_unidad = tipo_unidad;
        this.cantidad = cantidad;
        this.costo_unit = costo_unit;
        this.fecha_vencimiento = fecha_vencimiento;
        this.fecha_entrada = fecha_entrada;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(String tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto_unit() {
        return costo_unit;
    }

    public void setCosto_unit(double costo_unit) {
        this.costo_unit = costo_unit;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    
}
