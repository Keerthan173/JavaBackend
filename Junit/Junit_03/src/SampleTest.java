/*
@BeforeEach: Reset or prepare things before every test

@AfterEach: Clean up after every test

@BeforeAll/@AfterAll: For one-time setup/teardown (like DB connect/disconnect)
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SampleTest {

    Sample s;

    @BeforeAll
    void setupOnce() {
        System.out.println("🟢 Before all tests");
    }

    @AfterAll
    void teardownOnce() {
        System.out.println("🔴 After all tests");
    }

    @BeforeEach
    void setup() {
        System.out.println("⚪ Before each test");
        s = new Sample(); // fresh instance each time
    }

    @AfterEach
    void cleanup() {
        System.out.println("⚫ After each test");
    }

    @Test
    void testMultiply() {
        System.out.println("✅ testMultiply");
        assertEquals(12, s.multiply(3, 4));
    }

    @Test
    void testSquare() {
        System.out.println("✅ testSquare");
        assertEquals(25, s.square(5));
    }
}

/*
Output Will Look Like:

🟢 Before all tests
⚪ Before each test
✅ testMultiply
⚫ After each test
⚪ Before each test
✅ testSquare
⚫ After each test
🔴 After all tests


 */