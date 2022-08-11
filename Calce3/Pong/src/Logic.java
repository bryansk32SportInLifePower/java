import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logic extends JPanel implements ActionListener, KeyListener {
    //биты
    private int bit1y = 120;
    private int bit2y = 120;
    // шарик
    private int ballx = 284;
    private int bally = 150;
    //шаг шарика
    private int bitx = 3;
    private int bity = 3;

    private int play1 = 0;
    private int play2 = 0;
    private final Timer timer;

    {
        timer = new Timer(10, this);
    }

    Logic() {
        addKeyListener(this);
        setFocusable(true);

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 400);
        g.setColor(Color.white);
        //byta 1
        g.fillRect(0, bit1y, 10, 100);
        //byte2
        g.fillRect(575, bit2y, 10, 100);
//pong
        g.fillOval(ballx, bally, 15, 15);
//line
        g.drawLine(290, 0, 290, 400);
        g.setColor(Color.WHITE);
        //score
        Font f=new Font("Arial",Font.BOLD,30);
        g.setFont(f);
        g.drawString(String.valueOf(play1),250,25);
        g.drawString(String.valueOf(play2),315,25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

        ballx += bitx;
        bally += bity;
        if (bally <= 0) {
            bity = -bity;
        }
        if (bally > 350) {
            bity = -bity;
        }
        if (bally - 50 <= bit2y && ballx >= 300 && bitx > 0) {
            bit2y -= 3;
        }
        if (bally - 50 >= bit2y && ballx >= 300 && bitx > 0) {
            bit2y += 3;
        }

        if (new Rectangle(ballx, bally, 15, 15).intersects(new Rectangle(575, bit2y, 10, 100))) {
            bitx = -bitx;
        }
        if (new Rectangle(ballx, bally, 15, 15).intersects(new Rectangle(0, bit1y, 10, 100))) {
            bitx = -bitx;
        }
if (ballx<-20){
    play2++;
    timer.stop();
      ballx = 284;
    bally = 150;
    bitx = 3;
     bity = 3;

}
        if (ballx>620){
            play1++;
            timer.stop();
             ballx = 284;
            bally = 150;
            bitx = -3;
            bity = -3;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bit1y += 7;
            if (bit1y >= 260) {
                bit1y = 262;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bit1y -= 7;
            if (bit1y <= 0) {
                bit1y = 2;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            timer.start();
        }
    }
}
