package org.example.tp_projet.repository;

import org.example.tp_projet.entity.Electronique;
import org.example.tp_projet.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ElectroniqueRepo {



        //variable global dans notre repository accesible par toute les methode du repository
        private SessionFactory sessionFactory;
        private Session session;

        public ElectroniqueRepo() {
            //a la creation de notre repository on vien recuperer l'instance
            // de SessionFactory pour pouvoir crée des session dans notre repository
            sessionFactory = SessionfactorySingleton.getSessionFactory();
        }

        public Electronique create (Electronique electronique){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(electronique);
                session.getTransaction().commit();
                return electronique;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return null;
            }finally {
                session.close();
            }
        }

        public boolean delete  (Electronique electronique){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(electronique);
                session.getTransaction().commit();
                return true;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return false;
            }finally {
                session.close();
            }
        }

        public Electronique findById (int id ){
            session = sessionFactory.openSession();
            Electronique electronique = session.get(Electronique.class,id);
            session.close();
            return electronique;
        }
    }

