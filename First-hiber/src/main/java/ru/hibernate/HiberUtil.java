package ru.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HiberUtil {
    private static final SessionFactory sessionFack=buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        }
        catch(Throwable ex){
            System.out.println("failed"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFack(){
        return sessionFack;
    }
    public static void shutdown(){
        getSessionFack().close();
    }
}
