package entity;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class MysoTwo {
    static JFrame frame;
    JPanel jPanel;
    JMenuBar menuBar;
    JMenu file;
    JMenuBar menuBartwo;
    JMenu filetwo;

    public void go() {
        JButton button = new JButton("Add clients");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveClients();
                //
            }
        });

        JButton jButton = new JButton("Find Client");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                findClient();
            }
        });


        frame = new JFrame("Mysocombinat");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuBar = new JMenuBar();
        this.menuBartwo = new JMenuBar();

        jPanel = new JPanel();

        menuBar.add(file = new JMenu("Bezicha"));
        menuBartwo.add(filetwo = new JMenu("Sovetskyi"));





        file.add(button);
        file.add(jButton);


        frame.setVisible(true);
        jPanel.add(menuBar);

        jPanel.setLayout(new FlowLayout());
        frame.add(jPanel);
        frame.setVisible(true);

    }


    private String getClient() {
        String client = JOptionPane.showInputDialog("Vvedite imy");
        return client;
    }

    private Double getNumber() {
        Double res = Double.valueOf(JOptionPane.showInputDialog("Vvedite nomer Clienta"));
        return res;
    }

    public void saveClients() {
        String s;
        Double d;
        int x = 0;
        Hiber hiber = new Hiber();
        Session session = HiberUt.getSessionfacktory().openSession();
        session.getTransaction().begin();
        if (x < 3) {
            hiber.setTovar(s = String.valueOf(getClient()));
            hiber.setChena(d = Double.parseDouble(String.valueOf(getNumber())));
            session.save(hiber);
            session.getTransaction().commit();
            session.close();
            x++;
        }
    }



    public void findClient() {
        String ss;
        Session session = HiberUt.getSessionfacktory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("FROM Hiber where tovar=:tovar");
        query.setParameter("tovar", ss = String.valueOf(getClient()));
        List<Hiber> hibers = query.list();
        System.out.println("ansver ANSWERRRR " + hibers.toString());
        JOptionPane.showMessageDialog(null, "ansver ANSWERRRR " + hibers.toString());
    }


    public void startWorkDatabase() {
        int y = 0;
        Session session = HiberUt.getSessionfacktory().openSession();
        session.getTransaction().begin();
        if (y < 5) {
            String sql = "From " + Hiber.class.getSimpleName();
            @SuppressWarnings("unchecked")
            List<Hiber> hibers = (List<Hiber>) session.createQuery(sql).list();
            // System.out.println("answer " + hibers.size());
            for (Iterator<Hiber> it = hibers.iterator(); it.hasNext(); ) {
                Hiber hibered = (Hiber) it.next();
                String message = (String) hibered.toString();
                JTextArea jTextArea = new JTextArea(5, 15);
                jTextArea.setText(message);
                JScrollPane scrollPane = new JScrollPane(jTextArea);
                JOptionPane.showMessageDialog(null, scrollPane);
                //  System.out.println(message);
               // session.getTransaction().commit();

                session.close();
                y++;
            }
        }
    }
}
