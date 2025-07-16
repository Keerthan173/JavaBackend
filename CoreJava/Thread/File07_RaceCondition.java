package Thread;/*
 *  A Race Condition happens when two or more threads access a shared resource (like a variable)
 *    and try to modify it at the same time — leading to incorrect or unexpected results.
 *
 * 🔹 In this example:
 *   - Two threads increment `count` 10,000 times each (expected total = 20,000)
 *   - But the result is sometimes less (e.g., 17900) due to lost updates.
 */

class Counter {
    private int count;

    public void increment() {
        count++;  // ❌ Not atomic — causes race condition
    }

    public int getCounter() {
        return count;
    }
}

public class File07_RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        // 🔹 Thread 1
        Runnable obj1 = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        // 🔹 Thread 2
        Runnable obj2 = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        // 🔹 Start both threads
        t1.start();
        t2.start();

        // 🔹 Wait for both threads to finish
        t1.join();
        t2.join();

        // 🔹 Final count should be 20000 — but it’s often less due to race condition
        System.out.println("Final Count: " + c.getCounter());
    }
}
