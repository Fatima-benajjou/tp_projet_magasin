package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Nourriture;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NourritureRepo {

        //variable global dans notre repository accesible par toute les methode du repository
        private SessionFactory sessionFactory;
        private Session session;

        public NourritureRepo() {
            //a la creation de notre repository on vien recuperer l'instance
            // de SessionFactory pour pouvoir crée des session dans notre repository
            sessionFactory = SessionfactorySingleton.getSessionFactory();
        }

        public Nourriture create (Nourriture nourriture){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(nourriture);
                session.getTransaction().commit();
                return nourriture;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return null;
            }finally {
                session.close();
            }
        }

        public boolean delete  (Nourriture nourriture){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(nourriture);
                session.getTransaction().commit();
                return true;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return false;
            }finally {
                session.close();
            }
        }

        public Nourriture findById (int id ){
            session = sessionFactory.openSession();
            Nourriture nourriture = session.get(Nourriture.class,id);
            session.close();
            return nourriture;
        }
    }




