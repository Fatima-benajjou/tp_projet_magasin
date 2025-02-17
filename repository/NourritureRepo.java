package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.entity.Vetement;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class NourritureRepo {

    //variable global dans notre repository accesible par toute les methode du repository
    private SessionFactory sessionFactory;
    private Session session;

    public NourritureRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Nourriture save (Nourriture nourriture) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(nourriture);
            session.getTransaction().commit();
            return nourriture;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Nourriture nourriture) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(nourriture);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Nourriture findById(int id) {
        session = sessionFactory.openSession();
        Nourriture nourriture = session.get(Nourriture.class, id);
        session.close();
        return nourriture;
    }


    public Nourriture getById(Class<Nourriture> classe, int id)
    {
        return session.find(classe, id);
    }


    public List<Nourriture> getAll() {
        session = sessionFactory.openSession();
        Query<Nourriture> query = session.createQuery("select n From Nourriture n", Nourriture.class);
        List<Nourriture> listeNourriture = query.getResultList();
        session.close();
        return listeNourriture;


    }

}





