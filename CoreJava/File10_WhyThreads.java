/*
 * ✅ WHY THREADS ARE NEEDED IN JAVA
 * ---------------------------------
 * 🔹 Problem:
 * In normal Java code, methods run one after the other — sequentially.
 * This means if one task takes time (like downloading, printing, looping), 
 * the next task has to wait.
 * 
 */

class A {
    public void show() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hi");
        }
    }
}

class B {
    public void show() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Hello");
        }
    }
}

public class File10_WhyThreads {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        // Runs one after another (not in parallel)
        obj1.show(); // prints Hi 100 times
        obj2.show(); // prints Hello 100 times
    }
}


/* Output:

Hi
Hi
...
(100 times)
Hello
Hello
...
(100 times)

*/
