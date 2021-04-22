import javax.swing.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForeCur {
    public ForeCur() throws IOException {
    }
    Document document=getInfo();

    public static Document getInfo() throws IOException {//получаем страницу банка
        String url="https://cbr.ru/";
        Document doc= null;
try{
    doc = Jsoup.parse(new URL(url),1500);
} catch (IOException e){
    JOptionPane.showMessageDialog(null," Error");
        }
        return doc;
    }

    Elements course=document.select("div[class=main-indicator_rates-table]");// выбираем на странице нужную инфу
    String currency=course.text();
//специально для тестов
public void  go(){
   System.out.println(currency);

}
//из полученной инфы ищем курс доллара
    private String getCurency(String currency) {
        Pattern pattern=Pattern.compile("\\d{2}\\,\\d{4}");
        Matcher matcher=pattern.matcher(currency);
        if (matcher.find()){
        return matcher.group();}
        else{
            JOptionPane.showMessageDialog(null,"Error");
        }
        return matcher.group();
    }
// переводим текст в число,меняем тчк на запятые
    String res=getCurency(currency);
Double e=Double.parseDouble(res.replace(",","."));

    public double rubToDol(double put) {//пересчет в доллары
        double dol=put/e;
        JOptionPane.showMessageDialog(null,"Посчитано"+dol+" $");
        return dol;
    }

    public boolean check(String input) {// проверка введенного вначале программы
        double d=Double.parseDouble(input);
        if((d>0)){
        return true;}
        else return false;

    }
}

