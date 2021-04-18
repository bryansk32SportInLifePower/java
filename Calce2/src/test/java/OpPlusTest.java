import junit.framework.TestCase;

public class OpPlusTest extends TestCase {

    public void tearDown() throws Exception {
    }

    public void testExec() {
       Plus opPlus=new Plus();
       double actual=opPlus.exec(6,7);
       double excpected=13;
       assertEquals(excpected,actual);
    }
}