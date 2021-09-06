package train.question.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Train {
 public int  fizz(int n,int k) {
     ArrayList<Integer> arr = new ArrayList<Integer>();
     arr.add(1);
     arr.add(n);
     int j=1;
     for(int i=1;i<=n/2;i++){
         if(n%i==0){
             arr.add(j++,i);
         }
     }

     Collections.sort(arr);
     if(arr.size()>k){
         return arr.get(k);
     } else {
         return -1;
     }
 }
    }

