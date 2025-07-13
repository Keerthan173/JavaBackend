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

public class File11_WithThreads {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

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
(200 total lines: 100 Hi + 100 Hello)
 */