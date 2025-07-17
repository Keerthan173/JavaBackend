import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {
    Calc c = new Calc();

    @Test
    void testAdd() {
        assertEquals(5, c.add(2, 3));
        assertEquals(0, c.add(-2, 2));
    }

    @Test
    void testSub() {
        assertEquals(2, c.sub(5, 3));
        assertEquals(-5, c.sub(0, 5));
    }

    @Test
    void testMul() {
        assertEquals(6, c.mul(2, 3));
        assertEquals(0, c.mul(0, 100));
    }

    @Test
    void testDiv() {
        assertEquals(2, c.div(10, 5));
        assertEquals(1, c.div(5, 5));
    }

    @Test
    void testDivByZero() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            c.div(10, 0);
        });
        assertEquals("Cannot divide by zero", e.getMessage());
    }
}
