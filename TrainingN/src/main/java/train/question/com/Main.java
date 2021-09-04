package train.question.com;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        String a;
        Scanner s=new Scanner(System.in);
        Train t=new Train();
        System.out.println("vvedite chislo");
        a=s.nextLine();
        System.out.println(t.fizz( a));
        }
}

