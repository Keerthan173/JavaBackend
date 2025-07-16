package Thread;

class A2 extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B2 extends Thread {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("Hello");
        }
    }
}

public class File02_WithThreads {
    public static void main(String[] args) {
        A2 obj1 = new A2();
        B2 obj2 = new B2();

        obj1.start();  // Starts thread for A
        obj2.start();  // Starts thread for B
    }
}


/*
 * The order is not guaranteed — it depends on the Thread Scheduler and CPU.

✅ Output (example):
Hi
Hi
Hi
Hi
Hello
Hello
Hi
Hello
Hi
Hi
Hello
...
(2000 total lines: 1000 Hi + 1000 Hello)
 */