import javax.swing.*;
import java.io.IOException;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Main main=new Main();
       main.start();
       //Специально для тестов,сравнение текущей инфы и ожидаемой
        ForeCur foreCur=new ForeCur() ;
        foreCur.go();
    }
    ForeCur foreCur=new ForeCur() ;

    public double start() {

        Object[] objects = {"RealDol", "Exit"};
        while (true) {
            //ввод данных для расчета
            String input = JOptionPane.showInputDialog("Перевод");
            if (foreCur.check(input) == true) {//проверка введеного на то что это цифры
                double put = Double.parseDouble(input);
                int choiche = JOptionPane.showOptionDialog(null, "Выбери действие", "Валюта варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, objects, objects);//cоздание окна с опциями действий
                if (choiche == 0) {//если решил пересчитать
                    foreCur.rubToDol(put);
                }
            } else {//выход в главное меню
                JOptionPane.showMessageDialog(null, "Плохо ввел");
            }
        }
    }
}
