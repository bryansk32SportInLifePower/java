package train.guestions.com;

import java.util.Locale;

public class Train {
    public boolean detectCapitalUse(String word) {
        char wor[];
        wor=word.toCharArray();
        if(wor.length>=1&&wor.length<=100){
           if (word.equals(word.toLowerCase())){
               return true;
           }
            if (word.equals(word.toUpperCase())){
                return true;
            }else{
                return false;
            }

        }
return false;
    }
}
