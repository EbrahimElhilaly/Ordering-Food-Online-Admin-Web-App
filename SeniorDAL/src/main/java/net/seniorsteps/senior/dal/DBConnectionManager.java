/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author helali
 */
public class DBConnectionManager {

    private static SessionFactory sessionFactory;

    private DBConnectionManager() {
        
    }
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    private static void buildSessionFactory() {
        StandardServiceRegistry registry = null;
        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void rollbackTransaction() {
        if (isActiveTransaction()) {
            getSessionFactory().getCurrentSession().getTransaction().rollback();
        }
    }

    public static Session getCurrentSession() {
        return DBConnectionManager.getSessionFactory().getCurrentSession();
    }

    public static boolean isActiveTransaction() {
        return getCurrentSession().getTransaction().isActive();
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession() {
        getSessionFactory().getCurrentSession().close();
    }

    public static void beginTransaction() {
        getCurrentSession().beginTransaction();
    }

    public static void commitTransaction() {
        getCurrentSession().getTransaction().commit();
    }

}
