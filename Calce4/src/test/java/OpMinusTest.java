import junit.framework.TestCase;

public class OpMinusTest extends TestCase {

    public void testExec() {
        Minus opMinus=new Minus();
        double actual=opMinus.exec(7,4);
       double expected=3;
       assertEquals(expected,actual);
    }
}