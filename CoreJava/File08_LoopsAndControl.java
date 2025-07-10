/*
 * Java Loop Notes (for GitHub)
 *
 * Loop Types:
 * 1. for      → Best when number of iterations is known
 * 2. while    → Used when condition-based, unknown iterations
 * 3. do-while → Runs at least once (entry check is skipped)
 *
 * Control Statements:
 * - break     → Exit the loop
 * - continue  → Skip to next iteration
 * - label     → Jump out of nested loops
 */

import java.util.Scanner;

public class File08_LoopsAndControl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1️⃣ for loop - Reverse a number
        System.out.print("Enter number to reverse: ");
        int num = sc.nextInt();
        int rev = 0;
        for (; num != 0; num /= 10) {
            int digit = num % 10;
            rev = rev * 10 + digit;
        }
        System.out.println("Reversed: " + rev);
        //Enter number to reverse: 73
        // Reversed: 37


        // 2️⃣ while loop - Pattern: right-angled triangle
        System.out.print("Enter number of rows for pattern: ");
        int rows = sc.nextInt();
        int i = 1;
        while (i <= rows) {
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
        // Enter number of rows for pattern: 3
        // * 
        // * * 
        // * * * 


        // 3️⃣ do-while loop - Input until valid number
        int age;
        do {
            System.out.print("Enter valid age (>= 0): ");
            age = sc.nextInt();
        } while (age < 0);
        System.out.println("Valid age entered: " + age);
        // Enter valid age (>= 0): -2
        // Enter valid age (>= 0): 7
        // Valid age entered: 7


        // 4️⃣ continue - skip even numbers
        System.out.print("Odd numbers from 1 to 10: ");
        for (int x = 1; x <= 10; x++) {
            if (x % 2 == 0) continue;
            System.out.print(x + " ");
        }
        System.out.println();
        // Odd numbers from 1 to 10: 1 3 5 7 9


        // 5️⃣ break + label - Exit outer loop from inner loop
        outer:
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if (x == 2 && y == 2) break outer;
                System.out.println("x=" + x + ", y=" + y);
            }
        }
        // x=1, y=1
        // x=1, y=2
        // x=1, y=3
        // x=2, y=1

        sc.close();
    }
}