
import entity.Hiber;
import entity.HiberUt;
import entity.Myso;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

@Log4j2

public class Main {




    
    public static void main(String[] args) {

       Main main=new Main();
       Myso myso=new Myso();
       //myso.go();
myso.findClient();
main.startWorkDatabase();
    }
    public void startWorkDatabase() {
        Session session=HiberUt.getSessionfacktory().openSession();
       session.getTransaction().begin();
        String sql="From "+Hiber.class.getSimpleName();
        @SuppressWarnings("unchecked")
        List<Hiber>hibers=(List<Hiber>)session.createQuery(sql).list();
        System.out.println("answer "+hibers.size());
        for (Iterator<Hiber>it=hibers.iterator();it.hasNext();){
            Hiber hibered=(Hiber) it.next();
            System.out.println(hibered.toString());
        }
        session.getTransaction().commit();
session.close();
//HiberUt.shutup();
    }



}