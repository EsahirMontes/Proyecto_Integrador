/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

public class Compra {
    
    int id_compra;
    int id_proveedor;
    LocalDate fecha_compra;
    int numero_documento;

    public Compra() {
    }

    public Compra(int id_compra, int id_proveedor, LocalDate fecha_compra, int numero_documento) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.fecha_compra = fecha_compra;
        this.numero_documento = numero_documento;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }
    
    
}
