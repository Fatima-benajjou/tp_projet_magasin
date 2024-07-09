package org.example.tp_projet.repository;

import org.example.tp_projet.entity.LigneVente;
import org.example.tp_projet.entity.Vente;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LigneVenteRepo {

    private SessionFactory sessionFactory;
    private Session session;

    public LigneVenteRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public LigneVente save(LigneVente ligneVente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(ligneVente);
            session.getTransaction().commit();
            return ligneVente;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(LigneVente ligneVente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(ligneVente);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public LigneVente findById(int id) {
        session = sessionFactory.openSession();
        LigneVente ligneVente = session.get(LigneVente.class, id);
        session.close();
        return ligneVente;
    }

    public LigneVente getById(Class<LigneVente> classe, int id) {
        return session.find(classe, id);
    }

    public List<LigneVente> getAll(){
        session = sessionFactory.openSession();
        Query<LigneVente> query =session.createQuery("select l From LigneVente l", LigneVente.class);
        List<LigneVente> listeLigneVentes = query.list();
        session.close();
        return listeLigneVentes;

    }

}
