package train.question.com;

import java.util.*;
public class Main {
public static void arrayCheck(int[] array){
        HashSet<Integer> used = new HashSet<>();

        for(int i = 0; i < array.length; i++){
        if(used.contains(array[i])){
        continue;
        } else {
        used.add(array[i]);
        }

        ArrayList<Integer> positions = new ArrayList<>();
        positions.add(i);
        for(int j = i + 1; j < array.length; j++){
            if(array[i] == array[j]){
        positions.add(j);
            }

        }
        System.out.print(array[i] + " in position " );
        for(Integer p : positions){
        System.out.print(p + ", ");
        }
        System.out.println();
        }
        }

        public static void main(String[] args) {
        Random R = new Random();
        int a;
        int[] m = new int [10];
        for(a = 0; a<m.length; a++) {
            m[a]=R.nextInt(10);
            System.out.println(a + " : " + m[a]+" ");
        }
        arrayCheck(m);
    }
    }

