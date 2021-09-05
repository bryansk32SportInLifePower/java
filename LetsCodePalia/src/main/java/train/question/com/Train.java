package train.question.com;

import java.util.ArrayList;
import java.util.List;

public class Train {
 public int  fizz(String s) {
boolean act;
     int result = 0;
     int center = 0;
     String b = s;
     String c = s;

    while (b.toLowerCase().equals(s) | c.toUpperCase().equals(s)) {


        act = true;

        while (act != false) {
            // ASCII char counts array
            int[] counts = new int[128];
            char[] chars = s.toCharArray();
            for (char d : chars) {
                counts[d]++;
            }

            for (int count : counts) {
                if (count % 2 == 0) {
                    result += count;
                } else {
                    result += (count - 1);

                    // Center will become non-zero (1) if there is but 1 odd character
                    center = 1;
                }
            }

            return result + center;

        }
    }
         System.out.println("hren");
     return 0;

 }
    }

