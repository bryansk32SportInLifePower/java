package train.guestions.com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String ss;
        Scanner  s=new Scanner(System.in);
        System.out.println("Vvedute");
        ss = s.nextLine();
        Train t=new Train();
        System.out.println(ss);
        System.out.println( t.detectCapitalUse(ss));
    }

}
