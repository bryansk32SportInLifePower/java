import javax.swing.*;

public class Wind extends JFrame {
    Logic logic;
    public void start(){

        logic = new Logic();
        JFrame jFrame=new JFrame("Pong");
        jFrame.setSize(600,400);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLocation(500,400);
        jFrame.add(logic);
    }
}
