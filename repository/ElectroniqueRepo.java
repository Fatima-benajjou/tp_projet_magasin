package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.management.Query;
import java.util.List;

public class ElectroniqueRepo {


    //variable global dans notre repository accesible par toute les methode du repository
    private SessionFactory sessionFactory;
    private Session session;

    public ElectroniqueRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Electronique create(Electronique electronique) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(electronique);
            session.getTransaction().commit();
            return electronique;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Electronique electronique) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(electronique);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Electronique findById(int id) {
        session = sessionFactory.openSession();
        Electronique electronique = session.get(Electronique.class, id);
        session.close();
        return electronique;
    }

    public Electronique getById(Class<Electronique> classe, int id) {
        return session.find(classe, id);
    }


    public List<Electronique> getAll() {
        session = sessionFactory.openSession();
        Query <Electronique> query = session.createQuery("select * from Electrique", Electronique.class);
        List<Electronique> listeElectronique = query.list();
        session.close();
        return query.list();
    }
}

