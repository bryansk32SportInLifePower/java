import javax.swing.*;
import java.awt.*;

public class BattleTraining extends JFrame {
    private final int ROWS=1;
    private final int  COLUM=15;
    private final int IMAGE_SIZE=50;

    JPanel panel;
    public static void main(String[] args) {
new BattleTraining().setVisible(true);
    }
    private BattleTraining(){
initFrame();
initPanel();
        
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setTitle("BattleSea");


        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initPanel() {
        panel=new JPanel();
        panel.setPreferredSize(new Dimension(COLUM*IMAGE_SIZE,ROWS*IMAGE_SIZE));
        add(panel);
    }


}
