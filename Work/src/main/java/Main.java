import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main extends JFrame {

    private JPanel panel;
    private JLabel label;

    private final int COLS = 15; // столбцы
    private final int ROWS = 1; // строки
    private final int BOMBS = 10; // количество бомб
    private final int IMAGE_SIZE = 50; // размер картинки одинаковый по x и по y
    public static void main(String[] args) {
new Main();
    }
    Main(){

     setImage();
        initPanel();
     initFrame();

    }
    private void initPanel(){
        panel=new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                for (Box box:Box.values())
                    g.drawImage((Image)box.image,
                            box.ordinal()*IMAGE_SIZE,0,this);
            }
        };
        panel.setPreferredSize(new Dimension(COLS*IMAGE_SIZE,ROWS*IMAGE_SIZE));
        add(panel);
    }
    private void initFrame ()
    {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Sweeper ");
        setResizable(false);

        //метод из класса JFrame устанавливает размер окна достаточный для отображения
       // setIconImage(getIme("icon"));//установка иконки для игры
       // setLocationRelativeTo(null);
        setVisible(true);
    }
    private void setImage(){
        for (Box box:Box.values())
            box.image=getIme(box.name().toLowerCase());
    }
    public Image getIme(String st){
        String s="img/"+st+".png";
        ImageIcon icon=new ImageIcon(getClass().getResource(s));
        return icon.getImage();
    }
}
