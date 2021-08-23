package train.guestions.com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Vvedute");
        String ss=s.toString();
        Train t=new Train();
        System.out.println(t.detectCapitalUse(ss));
    }

}
