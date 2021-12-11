import miner.Box;
import miner.Coordinats;
import miner.CoordsMake;
import miner.Game;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
private Game game;
    private JPanel panel;
    private JLabel label;
//Box box;
    private final int COLS = 9; // столбцы
    private final int ROWS = 9; // строки
    private final int BOMBS = 10; // количество бомб
    private final int IMAGE_SIZE = 50; // размер картинки одинаковый по x и по y
    public static void main(String[] args) {
new Main();
    }
    Main(){
        game=new Game(COLS,ROWS);
        setImage();
        initPanel();
     initFrame();

    }
    private void initPanel(){
        panel=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                for (Coordinats coordinats: CoordsMake.getAllCoords()) {

                    g.drawImage((Image) game.getBox(coordinats).image,
                            coordinats.x*IMAGE_SIZE, coordinats.y*IMAGE_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(CoordsMake.getSize().x*IMAGE_SIZE, CoordsMake.getSize().y*IMAGE_SIZE));
        add(panel);
    }
    private void initFrame ()
    {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Sweeper ");
        setResizable(false);

        //метод из класса JFrame устанавливает размер окна достаточный для отображения
        setIconImage(getIme("icon"));//установка иконки для игры
       // setLocationRelativeTo(null);
        setVisible(true);
    }
    private void setImage(){
        for (miner.Box box: Box.values())
            box.image=getIme(box.name().toLowerCase());
    }
    public Image getIme(String st){
        String s="img/"+st+".png";
        ImageIcon icon=new ImageIcon(getClass().getResource(s));
        return icon.getImage();
    }
}
