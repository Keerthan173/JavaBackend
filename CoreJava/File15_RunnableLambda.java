/*
 * THREADS USING LAMBDA EXPRESSIONS
 * ------------------------------------
 * 🔹 Runnable is a Functional Interface → eligible for lambda usage.
 * 🔹 Lambda expression makes thread creation shorter and cleaner.
 * 🔹 Works only when there is one abstract method (SAM interface).
 * 🔹 Syntax: Runnable r = () -> { code };
 */

public class File15_RunnableLambda {
    public static void main(String[] args) {

        // 🔹 Lambda for thread 1
        Runnable obj1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(10); // Pause for 10ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 🔹 Lambda for thread 2
        Runnable obj2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(10); // Pause for 10ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 🔹 Wrapping in Thread objects
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        // 🔹 Start both threads
        t1.start();
        t2.start();
    }
}