package com.proyecto.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contacto")
public class Contacto {
    @Id
    private int idContacto;
    private String nombre;
    private String email;
    private String tema;
    private String mensaje;
    
    
    public Contacto() {
    }


    public Contacto(String nombre, String email, String tema, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.tema = tema;
        this.mensaje = mensaje;
    }


    public int getIdContacto() {
        return idContacto;
    }


    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getTema() {
        return tema;
    }


    public void setTema(String tema) {
        this.tema = tema;
    }


    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    

    
    
    

    

    

    
    
   

    
    
}
