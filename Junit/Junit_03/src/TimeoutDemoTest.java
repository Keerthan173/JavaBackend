import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

public class TimeoutDemoTest {

    TimeoutDemo demo = new TimeoutDemo();

    @Test
    void testShortWaitWithinTimeout() {
        // This should pass (executes in < 1 sec)
        assertTimeout(Duration.ofSeconds(1), () -> {
            demo.shortWait();
        });
    }

    @Test
    void testLongWaitFailsTimeout() {
        // This will fail (longWait sleeps for 3 seconds)
        assertTimeout(Duration.ofSeconds(1), () -> {
            demo.longWait();
        });
    }
    // AssertionFailedError: execution exceeded timeout of 1000 ms by 2001 ms
}