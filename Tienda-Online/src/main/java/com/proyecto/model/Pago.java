package com.proyecto.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pago")
public class Pago {
    @Id
    private int idPago;
    private double total;
    
    public Pago() {
    }

    public Pago(double total) {
        this.total = total;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    

    
    
   

    
    
}
