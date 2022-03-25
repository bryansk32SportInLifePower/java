package entity;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Myso {
    static JFrame frame;
    JPanel jPanel;
    JMenuBar menuBar;
    JMenu file;


    public void go() {

        frame = new JFrame("Monitoring Resources");
frame.setSize(300,300);
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuBar = new JMenuBar();
        jPanel = new JPanel();
        menuBar.add(file = new JMenu("Table clients"));

        jPanel.add(menuBar);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);

        jPanel.setLayout(new FlowLayout());
        frame.add(jPanel);
        frame.setVisible(true);
        JButton     button = new JButton("Add Client");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saveClients();
            }
        });
     JButton   jButton = new JButton("Find Client");
     jButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             findClient();
         }
     });
        jPanel.add(jButton);
        jPanel.add(button);
        file.add(button);
        file.add(jButton);
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

        public void saveClients(){
            String s;
            Double d;
            int x=0;
            Hiber hiber = new Hiber();
            Session session=HiberUt.getSessionfacktory().openSession();
            session.getTransaction().begin();
            if (x<3) {
                hiber.setTovar(s= String.valueOf(getClient()));
                hiber.setChena(d= Double.parseDouble(String.valueOf(getNumber())));
                session.save(hiber);
                session.getTransaction().commit();
                session.close();
                x++;
            }
        }
   public void findClient() {
        Session session=HiberUt.getSessionfacktory().openSession();
        session.getTransaction().begin();
        Query query=session.createQuery("FROM Hiber where tovar='sidorov'");
       List<Hiber>hibers=query.list();
        System.out.println("ansver ANSWERRRR " + hibers.toString());
JOptionPane.showMessageDialog(null,"ansver ANSWERRRR " + hibers.toString());
    }


}




