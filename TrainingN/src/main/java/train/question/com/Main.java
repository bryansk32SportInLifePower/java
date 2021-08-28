package train.question.com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int ss;
        Scanner  s=new Scanner(System.in);
        System.out.println("Vvedute");
        ss = s.nextInt();
        Train t=new Train();
        System.out.println(ss);
        System.out.println( t.detectCapitalUse(ss));
    }
}
