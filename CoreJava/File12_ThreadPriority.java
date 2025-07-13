/*
 * 🔹 Java threads have priorities from 1 to 10:
 *    - Thread.MIN_PRIORITY = 1
 *    - Thread.NORM_PRIORITY = 5 (default)
 *    - Thread.MAX_PRIORITY = 10
 *
 * 🔹 Priority helps the Thread Scheduler decide which thread to run first.
 *    But behavior is OS + JVM dependent (not guaranteed).
 *
 * 🔸 Methods:
 *    - setPriority(int priority)
 *    - getPriority()
 */

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hello");
        }
    }
}

public class File12_ThreadPriority {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        // 🔹 Setting priorities
        obj1.setPriority(Thread.MIN_PRIORITY);    // Priority 1
        obj2.setPriority(Thread.MAX_PRIORITY);    // Priority 10

        // 🔹 Display priorities
        System.out.println("Priority of A (Hi): " + obj1.getPriority());
        System.out.println("Priority of B (Hello): " + obj2.getPriority());

        // 🔹 Start threads
        obj1.start();
        obj2.start();
    }
}

/*
Higher priority doesn't guarantee first execution

Output:
Priority of A (Hi): 1
Priority of B (Hello): 10
Hi
Hi
...
Hello
...
Hi
Hello
Hello
...
Hi
Hi
...
 */