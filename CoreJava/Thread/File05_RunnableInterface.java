package Thread;/*
 * Runnable is a functional interface with one method: `run()`.
 * 🔹 Instead of extending Thread, we implement Runnable.
 * 🔹 This is preferred because:
 *    - Java doesn't support multiple inheritance
 *    - Allows extending other classes too(because if a class wants to be a thread it should extend Thread class).
 *
 * 🔹 Steps:
 * 1. Implement Runnable in a class
 * 2. Override run() method
 * 3. Pass object to Thread constructor
 * 4. Call start()
 */

class A3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);  // Pause for 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);  // Pause for 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class File05_RunnableInterface {
    public static void main(String[] args) {
        Runnable obj1 = new A3();
        Runnable obj2 = new B3();

        Thread t1 = new Thread(obj1);  // Create thread from Runnable
        Thread t2 = new Thread(obj2);

        t1.start();  // Start threads
        t2.start();
    }
}
