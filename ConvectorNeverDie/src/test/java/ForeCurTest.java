import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class ForeCurTest  {
    ForeCur foreCur;

    {
        try {
            foreCur = new ForeCur();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void tearDown() throws Exception {
    }
@Test
    public void testGetInfo() {
        String actual=foreCur.currency;
        char[] ch=actual.toCharArray();
       String expet="Курсы валют 21.04.2021 22.04.2021 USD 76,0155 ₽ 76,8198 ₽ Официальный курс Банка России EUR 91,7507 ₽ 92,2913 ₽ Официальный курс Банка России";
       char[]vv=expet.toCharArray();
        Assert.assertArrayEquals(vv,ch);

    }


@Test
    public void testCheck() {
        foreCur.check("44");

    }
@Ignore("Должен падать")
    @Test
    public void testCheckFalseShouldFail() {
        foreCur.check("uu");
        Assert.fail("test failed");


    }
}