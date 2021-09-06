package train.question.com;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        int a;
        int b;
        Scanner s=new Scanner(System.in);
        Train t=new Train();
        System.out.println("vvedite String");
        a=s.nextInt();
        b=s.nextInt();
        System.out.println(t.fizz( a,b));
        }
}

