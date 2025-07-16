package Thread;/*
 * 🔹 Thread.sleep(ms) pauses the current thread for given milliseconds.
 * 🔹 It is used to:
 *    - Slow down thread output (e.g., for animations or demo)
 *    - Simulate delay (like file download, network wait)
 *    - Improve visibility in multithreading
 *
 * 🔹 sleep() throws InterruptedException → must be handled with try-catch
 */

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);  // Pause for 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);  // Pause for 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class File04_ThreadSleep {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        // 🔹 Start threads
        obj1.start();
        obj2.start();
    }
}
/*
"Hi" and "Hello" printed with a 10ms delay per line.
Output will look more cleanly interleaved compared to rapid execution.

Ouput:
Hi
Hello
Hi
Hi
Hello
Hello
Hi
Hello
...

 */
