package com.proyecto.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="compras")
public class Compras {
    @Id
    private int idCompra;
    private String nombre;
    private double precio;
    private double total;
    private int idUsuarios;
    private int cantidad;
    private int idPago;
    private int idProductos;
    
    public Compras() {
    }

    public Compras(String nombre, double precio, double total, int idUsuarios, int cantidad, int idPago,
            int idProductos) {
        this.nombre = nombre;
        this.precio = precio;
        this.total = total;
        this.idUsuarios = idUsuarios;
        this.cantidad = cantidad;
        this.idPago = idPago;
        this.idProductos = idProductos;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    
    

    
}
