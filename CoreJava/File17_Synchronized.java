/*
*  Synchronization is used to prevent race conditions in multithreading.
 * The `synchronized` keyword ensures that only one thread can access
 *    the method (or block) at a time for the same object.
 *
 * 🔸 In this example:
 * - Two threads increment the `count` 10,000 times each
 * - With synchronization, the final count is always 20000 ✅
 */

class Counter {
    private int count;

    // 🔐 Synchronized method — thread-safe
    public synchronized void increment() {
        count++;
    }

    public int getCounter() {
        return count;
    }
}

public class File17_Synchronized {
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

        // 🔹 Wait for threads to complete
        t1.join();
        t2.join();

        // ✅ Correct final count (20000 expected)
        System.out.println("Final Count: " + c.getCounter());
    }
}
