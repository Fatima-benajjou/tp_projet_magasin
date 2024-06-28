package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Vetement;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VetementRepo {

    //variable global dans notre repository accesible par toute les methode du repository
    private SessionFactory sessionFactory;
    private Session session;

    public VetementRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Vetement create (Vetement vetement){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(vetement);
            session.getTransaction().commit();
            return vetement;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete  (Vetement vetement){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(vetement);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public Vetement findById (int id ){
        session = sessionFactory.openSession();
        Vetement vetement = session.get(Vetement.class,id);
        session.close();
        return vetement;
    }
}

