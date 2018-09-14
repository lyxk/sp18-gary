import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    /**
     * Test Filk
     */

    @Test
    public void testFlik() {
        assertTrue(Flik.isSameNumber(3, 3));
        assertFalse(Flik.isSameNumber(4, 3));
    }
}
