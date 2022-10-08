package com.proyecto.servicios;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.proyecto.model.Contacto;


public class ContactoService{

    private SessionFactory factory;

    public ContactoService() {
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Contacto.class).buildSessionFactory();
    }

    public Session openSession(){
        Session session=factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String crear(Contacto contacto){
        
        String msg="";
        Session session=openSession();
        try {
            session.persist(contacto);
            session.getTransaction().commit();
            msg="Gracias por escribirnos. Intentaremos responderte lo antes posible.";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        session.close();
        return msg;
    }

    
} 
