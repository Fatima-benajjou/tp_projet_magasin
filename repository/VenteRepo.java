package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.entity.Vente;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class VenteRepo {

    private SessionFactory sessionFactory;
    private Session session;

    public VenteRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Vente save(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(vente);
            session.getTransaction().commit();
            return vente;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(vente);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Vente findById(int id) {
        session = sessionFactory.openSession();
        Vente vente = session.get(Vente.class, id);
        session.close();
        return vente;
    }

    public Vente getById(Class<Vente> classe, int id) {
        return session.find(classe, id);
    }

    public List<Vente> getAll(){
        session = sessionFactory.openSession();
        Query<Vente> query =session.createQuery("select v From Vente c", Vente.class);
        List<Vente> listeVentes = query.list();
        session.close();
        return listeVentes;

    }

}
