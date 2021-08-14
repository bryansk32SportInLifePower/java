import java.util.Scanner;
import java.io.IOException;
public class Main {
/*
* Polya imen igrokov
* */
    static String playerName1 = "Player#1";
    static String playerName2 = "Player#2";
    static Scanner scanner = new Scanner(System.in);
    /*
    Polya bitvy i protivnika
    * */
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];

    public static void main(String[] args) {
        System.out.println("Player#1, please enter your name:");
        playerName1 = scanner.nextLine();
        System.out.println("Player#2, please enter your name:");
        playerName2 = scanner.nextLine();
        //zapusk rasmeshenia corabley
        placeShips(playerName1, battlefield1);
        placeShips(playerName2, battlefield2);
        //chikl peredachi hodov
        while (true) {
            makeTurn(playerName1, monitor1, battlefield2);
            if (isWinCondition()) {
                break;
            }
            makeTurn(playerName2, monitor2, battlefield1);
            if (isWinCondition()) {
                break;
            }
        }

    }
    public static void placeShips(String playerName, int[][] battlefield) {
        int deck = 4;
        while (deck >= 1) {
            System.out.println();
            System.out.println(playerName + ", please place your " + deck + "-deck ship on the battlefield:");
            System.out.println();

            drawField(battlefield);//pered vvodom coordinat risuem tecuchee znachenie polya

            System.out.println("Please enter OX coordinate:");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = scanner.nextInt();
            System.out.println("Choose direction:");
            System.out.println("1. Vertical.");
            System.out.println("2. Horizontal.");
            int direction = scanner.nextInt();
            //provercka na vozmoznost rasstanovki
            if (!isAvailable(x, y, deck, direction, battlefield)) {
                System.out.println("Wrong coordinates!");
                continue;
            }
            for (int i = 0; i < deck; i++) {
                if (direction == 1) {
                    battlefield[x][y + i] = 1;
                } else {
                    battlefield[x + i][y] = 1;
                }
            }
            deck--;
            clearScreen();
        }
    }
//otrisovka polya
    public static void drawField(int[][] battlefield) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    //ochistka posle vystrela
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
    ////
    public static void makeTurn(String playerName, int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println(playerName + ", please, make your turn.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                //otrisovka polya protivnika v savisimosty ot resultata vystrela
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("- ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            //vvod coordinat vystrela
            System.out.println("Please enter OX coordinate:");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = scanner.nextInt();
            //poluchenie resultata vustrela
            if (battlefield[x][y] == 1) {
                System.out.println("Hit! Make your turn again!");
                monitor[x][y] = 2;
            } else {
                System.out.println("Miss! Your opponents turn!");
                monitor[x][y] = 1;
                break;
            }
            clearScreen();
        }
    }
///////proverca na pobedu
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
////vosmoznost rasmechenia
    public static boolean isAvailable(int x, int y, int deck, int rotation, int[][] battlefield) {
        // vychod za polya
        if (rotation == 1) {
            if (y + deck > battlefield.length) {
                return false;
            }
        }
        if (rotation == 2) {
            if (x + deck > battlefield[0].length) {
                return false;
            }
        }
//variant casania corabley
        while (deck != 0) {
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;

                if (rotation == 1) {
                    yi = i;
                } else {
                    xi = i;
                }

                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0) {
                    if (battlefield[x + 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0) {
                    if (battlefield[x - 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0) {
                    if (battlefield[x + xi][y + 1 + yi] != 0) {
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0) {
                    if (battlefield[x + xi][y - 1 + yi] != 0) {
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }
}


