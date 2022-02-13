import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;

public class HiberUt {
    private static final SessionFactory sessionfack=initsessionFactory();

    private static SessionFactory initsessionFactory() {
   try {
       return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
   }
   catch (Throwable r){
       System.err.println("pizdec"+r);
       throw new ExceptionInInitializerError(r);
   }
    }
    public static SessionFactory getSessionfacktory(){
        return sessionfack;
    }
    public static void shutup(){
        getSessionfacktory().close();
    }
}
