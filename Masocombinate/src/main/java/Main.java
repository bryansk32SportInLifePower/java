import entity.Hiber;
import entity.HiberUt;
import entity.MyasoBoxes;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

@Log4j2

public class Main {


    
    public static void main(String[] args) {

MyasoBoxes myasoBoxes=new MyasoBoxes();
        MyasoBoxes.AddClient addClient=new MyasoBoxes.AddClient();
myasoBoxes.go();
       Hiber hiber = new Hiber();
        Session session=HiberUt.getSessionfacktory().openSession();
        session.getTransaction().begin();
       // hiber.setTovar(hiber.setTovar(myasoBoxes.get););
      //  hiber.setChena(getNumber());
        session.getTransaction().commit();
        session.close();
       // HiberUt.shutup();
Main main=new Main();
main.startWorkDatabase();
//AddNumber addNumber=new AddNumber();
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
HiberUt.shutup();
    }
}