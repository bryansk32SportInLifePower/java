package phone.project;
import java.util.ArrayList;
import java.util.List;

public class Client {
  private   String id;
  private final List <Numbers> numbersList;

    public Client(String id) {
        this.id=id;
        this.numbersList=new ArrayList <Numbers>();
    }
    public String getId(){
        return id;
    }
    public List<Numbers>getNumbers(){
        return numbersList;
    }


    public void addNumber(Numbers numbers){
        numbersList.add(numbers);
    }

    public void deleteNumber(final String number){
        for (int i=0;i<numbersList.size();i++){
            if (number.equalsIgnoreCase(numbersList.get(i).getName())){
                numbersList.remove(i);
            }
        }
    }
public Numbers getNumber(final String st){
        Numbers foundNumber=null;
        for(Numbers numbers:numbersList){
            if (st.equalsIgnoreCase(numbers.getName())){
                foundNumber=numbers;
                break;
            }
        }
        return foundNumber;
}
}
