import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

public class OpDivisionTest extends TestCase {
@Test
    public void testExec() throws DivException {
        Division opDivision=new Division();
        double actual=opDivision.exec(12,4);
        double expected=3;
        assertEquals(actual,expected);
    }

    @Ignore
    public void testExecFail() throws DivException {
        Division opDivision=new Division();
        double actual=opDivision.exec(12,0);
        double expected=3;
        throw new DivException(" Провал");
    }
}