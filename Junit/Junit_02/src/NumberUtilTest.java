import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilTest {
    NumberUtil util = new NumberUtil();

    @Test
    void testIsEven() {
        assertTrue(util.isEven(4));      // 4 is even → true ✅
        assertFalse(util.isEven(5));     // 5 is odd → false ✅
    }

    @Test
    void testIsPositive() {
        assertTrue(util.isPositive(10)); // 10 is positive → true ✅
        assertFalse(util.isPositive(-3));// -3 is not positive → false ✅
    }

    @Test
    void testSquare() {
        assertNotEquals(10, util.square(3)); // 3*3 = 9 ≠ 10 ✅
        assertEquals(25, util.square(5));    // 5*5 = 25 ✅
    }
}