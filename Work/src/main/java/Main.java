import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main extends JFrame {
    public static void main(String[] args) {
new Main();
    }
    Main(){
     setImage();
     initFrame();
    }
    private void initFrame ()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper 2000 Volosatov");
        setResizable(false);
        setVisible(true);
        pack(); //метод из класса JFrame устанавливает размер окна достаточный для отображения
        setIconImage(getIme("icon"));//установка иконки для игры
        setLocationRelativeTo(null);

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
