package com.proyecto.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.proyecto.model.Usuarios;


import jakarta.persistence.PersistenceException;

public class UsuariosService{

    private SessionFactory factory;

    public UsuariosService() {
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
    }

    public Session openSession(){
        Session session=factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String crear(Usuarios usuarios){
        String msg="";
        Session session=openSession();
        try {
            session.persist(usuarios);
            session.getTransaction().commit();
            msg="Se registro correctamente el nuevo usuario";
        }catch(PersistenceException e ){
            e.printStackTrace();
            e.toString();
            e.getMessage();
            msg="Este usuario ya existe";
        }
        session.close();
        return msg;
    }

    public List<Usuarios> listar(){

        List<Usuarios> usuarios = new ArrayList<>();
        Session session=openSession();
        try {
            usuarios= session.createQuery("from Usuarios",Usuarios.class).list();
            session.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuarios listarId(int idUsuarios){
        Usuarios usuarios = new Usuarios();
        Session session = openSession();
        try {
            usuarios = session.find(Usuarios.class, idUsuarios);
        }catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return usuarios;
    }
    
    
    public String actualizar(Usuarios usuarios){
        String msg ="";
        Session session = openSession();
        try {
            session.merge(usuarios);
            session.getTransaction().commit();
            msg="Usuario actualizado correctamente";
        }catch (PersistenceException e) {
            e.printStackTrace();
            msg="Este usuario ya exixte";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return msg;
    }

    public String eliminar(int idUsuarios){
        String msg="";
        Session session = openSession();
        try {
            Usuarios usuarios = listarId(idUsuarios);
            session.remove(usuarios);
            session.getTransaction().commit();
            msg="Usuario Eliminado";

        } catch (Exception e) {
            msg=e.getMessage();
        }
        session.close();
        return msg;

    }
} 
