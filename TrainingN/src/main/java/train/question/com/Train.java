package train.question.com;

import java.util.ArrayList;
import java.util.List;

public class Train {
 public int  fizz(String s){
     s=s.toUpperCase();
     int count=0;
     int len=s.length();
     for(int i=0;i<len;i++){
         int curr=s.charAt(i)-64;
         count+=Math.pow(26,len-i-1)*curr;
     }
     return count;
 }
    }

