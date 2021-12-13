package miner;

import java.util.ArrayList;
import java.util.Random;

public class CoordsMake {
    private static Coordinats size;//обьект класса координат
    private static ArrayList<Coordinats> allCoords;//коллекция координат
    private static Random random = new Random();//обьект рандома для вызова сатаны


    public static void setSize (Coordinats _size)//установка координат подчеркивание- статичный метод
    {
        size = _size;
        allCoords = new ArrayList<Coordinats>();
        for (int y = 0; y < size.y; y++)
            for (int x = 0; x < size.x; x++)
                allCoords.add(new Coordinats(x,y));// получаем массив где каждый элемент-картинка на поле с координатами икс игрек
    }

    public static Coordinats getSize()
    {
        return size;
    }

    public static ArrayList<Coordinats> getAllCoords ()
    {
        return allCoords;
    }


    public static boolean inBorder(Coordinats coordinats) {

    return coordinats.x>=0&&coordinats.x<size.x&&
            coordinats.y>=0&&coordinats.x<size.y;
    }

    public static Coordinats getRandomCoor() {
        return new Coordinats(random.nextInt(size.x),random.nextInt(size.y));
    }
}
