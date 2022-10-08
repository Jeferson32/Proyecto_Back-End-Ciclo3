package com.proyecto.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.proyecto.model.Producto;

import jakarta.persistence.PersistenceException;

public class ProductoService{

    private SessionFactory factory;

    public ProductoService() {
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Producto.class).buildSessionFactory();
    }

    public Session openSession(){
        Session session=factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String crear(Producto producto){
        String msg="";
        Session session=openSession();
        try {
            session.persist(producto);
            session.getTransaction().commit();
            msg="Se registro correctamente el nuevo celular";
        }catch (PersistenceException e) {
            e.printStackTrace();
            msg="Este registro ya existe"; 
        }catch(Exception e){
            e.printStackTrace();
        }
        session.close();
        return msg;
    }

    public List<Producto> listar(){

        List<Producto> producto = new ArrayList<>();
        Session session=openSession();
        try {
            producto= session.createQuery("from Producto",Producto.class).list();
            session.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    public Producto listarId(int idProductos){
        Producto producto = new Producto();
        Session session = openSession();
        try {
            producto = session.find(Producto.class, idProductos);
        }catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return producto;
    }
    
    
    public String actualizar(Producto producto){
        String msg ="";
        Session session = openSession();
        try {
            session.merge(producto);
            session.getTransaction().commit();
            msg="Celular actualizado correctamente";
        }catch (PersistenceException e) {
            e.printStackTrace();
            msg="Este articulo ya exixte";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return msg;
    }

    public String eliminar(int idProductos){
        String msg="";
        Session session = openSession();
        try {
            Producto producto = listarId(idProductos);
            session.remove(producto);
            session.getTransaction().commit();
            msg="Producto Eliminado con éxito";

        } catch (Exception e) {
            msg=e.getMessage();
        }
        session.close();
        return msg;

    }
} 
