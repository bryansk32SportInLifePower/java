import junit.framework.TestCase;
import org.junit.*;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;

public class OpDivisionTest  {

@Test
    public void testExec() throws DivException {
        Division opDivision=new Division();
        double actual=opDivision.exec(12,4);
        double expected=3;
        assertEquals(actual,expected);
    }

    @Test
    @Ignore
    public void testExecFail() throws DivException {
        Division opDivision=new Division();
        try {        double actual=opDivision.exec(12,0);
            Assert.fail("Ожидаемое ");

        }catch (DivException e){
            Assert.assertNotEquals("Провад",e.getMessage());
        }

    }
}