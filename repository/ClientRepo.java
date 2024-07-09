package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Client;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;


public class ClientRepo {


    //variable global dans notre repository accesible par toute les methode du repository
    private SessionFactory sessionFactory;
    private Session session;

    public ClientRepo() {
        //a la creation de notre repository on vien recuperer l'instance
        // de SessionFactory pour pouvoir crée des session dans notre repository
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Client save(Client client) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
            return client;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(Client client) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Client findById(int id) {
        session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public Client getById(Class<Client> classe, int id) {
        return session.find(classe, id);
    }

        public List<Client> getAll(){
            session = sessionFactory.openSession();
            Query<Client> query =session.createQuery("select c From Client c", Client.class);
            List<Client> listeClients = query.list();
            session.close();
            return listeClients;

        }

}


