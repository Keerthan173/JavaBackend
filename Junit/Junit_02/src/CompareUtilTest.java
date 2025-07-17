import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompareUtilTest {

    CompareUtil util = new CompareUtil();

    @Test
    void testSum() {
        assertEquals(5, util.getSum(2, 3)); // ✅ checks if 2+3 == 5
    }

    @Test
    void testArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = util.getNumbers();

        assertArrayEquals(expected, actual); // ✅ checks each element
    }

    @Test
    void testArrayReferenceFails() {
        int[] arr1 = util.getNumbers();
        int[] arr2 = util.getAnotherNumbers();

        // This will pass (same content):
        assertArrayEquals(arr1, arr2);  // ✅

        // arr1 and arr2 is not same here
        assertNotSame(arr1, arr2); // ❌ different objects in heap
    }
}
