/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

public class Salidas {
    int id_salida;
    int id_usuario;
    int id_producto;
    String tipo_unidad;
    int cantidad;
    double costo_unit;
    LocalDate fecha_salida;
    String motivo_salida;

    public Salidas() {
    }

    public Salidas(int id_salida, int id_usuario, int id_producto, String tipo_unidad, int cantidad, double costo_unit, LocalDate fecha_salida, String motivo_salida) {
        this.id_salida = id_salida;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.tipo_unidad = tipo_unidad;
        this.cantidad = cantidad;
        this.costo_unit = costo_unit;
        this.fecha_salida = fecha_salida;
        this.motivo_salida = motivo_salida;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
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

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getMotivo_salida() {
        return motivo_salida;
    }

    public void setMotivo_salida(String motivo_salida) {
        this.motivo_salida = motivo_salida;
    }
    
}
