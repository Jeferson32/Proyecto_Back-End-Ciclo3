package com.proyecto.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    private int idUsuarios;
    private String numIdentificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String celular;
    private String email;
    private String clave; 
    
    
    public Usuarios() {
    }


    public Usuarios(String numIdentificacion, String nombres, String apellidos, String direccion, String celular,
        String email, String clave) {
        this.numIdentificacion = numIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.clave = clave;
    }


    public int getIdUsuarios() {
        return idUsuarios;
    }


    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }


    public String getNumIdentificacion() {
        return numIdentificacion;
    }


    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getCelular() {
        return celular;
    }


    public void setCelular(String celular) {
        this.celular = celular;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getClave() {
        return clave;
    }


    public void setClave(String clave) {
        this.clave = clave;
    }

}
