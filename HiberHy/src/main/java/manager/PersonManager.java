package manager;

import hibernate.domain.Persons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonManager {
    public static void main(String[] args) {


        sessionExample();
       // jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory en= Persistence.createEntityManagerFactory("persistence");
        EntityManager e=en.createEntityManager();
        e.getTransaction().begin();
        Persons pp=new Persons();
        pp.setFirstName("Michael");
        pp.setLastName("schumacher");
        e.persist(pp);
        System.out.println(pp.getPersonId());
        e.getTransaction().commit();
        e=en.createEntityManager();
       List list= e.createQuery("FROM Persons").getResultList();
       list.forEach(p-> System.out.println(p));
       e.close();

    }

    private static void sessionExample() {
        SessionFactory sf=buildSession();
        Session session=sf.openSession();
        session.getTransaction().begin();

        Persons persons=new Persons();
        persons.setFirstName("Fernando");
        persons.setLastName("Alonso");
        session.save(persons);
        Long id=(Long)session.save(persons);
        System.out.println(id);
        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSession(){
        try {
            StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata=new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        }catch (Throwable ex){
            System.err.println("Session failed"+ ex);
            throw new ExceptionInInitializerError(ex);
        }
   }
}
