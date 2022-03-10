package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyasoBoxes {
    static JFrame frame;

    JMenuBar menuBar;
    JMenu file;
    static JButton button, jButton;
    JPanel jPanel;

    public void go() {
        this.frame = new JFrame("Monitoring Resources");
        this.menuBar = new JMenuBar();
        this.jPanel = new JPanel();

        button = new JButton("Add Client");
        button.setActionCommand("falstart");
        button.addActionListener( new AddClient());
        jButton = new JButton("Add Client number");
        menuBar.add(file = new JMenu("Table clients"));
        file.add(button);
        file.add(jButton);
        jPanel.add(menuBar);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null); // при запуске отображает окно по центру экрана
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

public static  class AddClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("falstart".equals(e.getActionCommand())) {
                getClient();
                 getNumber();
            }
        }
        private String getClient() {
            String client= JOptionPane.showInputDialog("Vvedite imy");
            return client;
        }
        private Double getNumber() {
            Double res= Double.valueOf(JOptionPane.showInputDialog("Vvedite nomer Clienta"));
            return res;



        }

    }

}




