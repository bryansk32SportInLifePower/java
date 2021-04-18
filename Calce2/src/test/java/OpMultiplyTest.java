import junit.framework.TestCase;


public class OpMultiplyTest extends TestCase {

    public void testExec() {
        Multiply opMultiply=new Multiply();
       double actual= opMultiply.exec(4,5);
       double expceted=20;
       assertEquals(expceted,actual);

    }
}