import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageDemoTest {

    MessageDemo demo = new MessageDemo();

    @Test
    void testWithStringMessage() {
        int expected = 10;
        int actual = demo.getResult();

        // This message is always created, even if test passes
        assertEquals(expected, actual, "❌ Test failed: expected 10 but got " + actual);
    }

    @Test
    void testWithSupplierMessage() {
        int expected = 10;
        int actual = demo.getResult();

        // This message is created ONLY IF the test fails
        assertEquals(expected, actual, () -> "❌ Lazy message: expected " + expected + " but got " + actual);
    }
}