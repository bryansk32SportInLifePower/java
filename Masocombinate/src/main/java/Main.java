import entity.Hiber;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
@Log4j2
public class Main {
    public static void main(String[] args) {
       // log.
        Session session=HiberUt.getSessionfacktory().openSession();
      session.getTransaction().begin();;
        Hiber hiber=new Hiber();
        hiber.setChena(52.22);
        hiber.setTovar("Fibro");
        session.save(hiber);
        session.getTransaction().commit();



        session.close();
        HiberUt.shutup();
    }
}
