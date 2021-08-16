import java.util.Scanner;
import java.io.IOException;
public class Main {
/*
* Polya imen igrokov
* */

    static String playerName2;
     static String playerName1;
    private static Ships ships;
    static String s= ships.start(playerName1);
    static String s2= ships.startForNextGamer(playerName2);
    /*
    Polya bitvy i protivnika
    * */
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];

    public static void main(String[] args) {
        Ships ships = new Ships();
        ships.placeShips(s, battlefield1);
        ships.placeShips(s2, battlefield2);
        while (true) {
            ships.makeTurn(s,monitor1, battlefield2);
            if (!isWinCondition()) {
                break;
            }

            ships.makeTurn(s2, monitor2, battlefield1);
            if (!isWinCondition()) {
                break;
            }
        }
    }
    public static boolean isWinCondition() {
        int counter1 = 0;
        for (int i = 0; i < monitor1.length; i++) {
            for (int j = 0; j < monitor1[i].length; j++) {
                if (monitor1[i][j] == 2) {
                    counter1++;
                }
            }
        }
        int counter2 = 0;
        for (int i = 0; i < monitor2.length; i++) {
            for (int j = 0; j < monitor2[i].length; j++) {
                if (monitor2[i][j] == 2) {
                    counter2++;
                }
            }
        }
        if (counter1 >= 10) {
            System.out.println(playerName1 + " WIN!!!");
            return true;
        }
        if (counter2 >= 10) {
            System.out.println(playerName2 + " WIN!!!");
            return true;
        }
        return false;
    }

}


