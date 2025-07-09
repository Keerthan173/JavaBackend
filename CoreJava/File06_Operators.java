/*
 * Operators are special symbols in Java that perform operations on variables and values.
 * 
 * Arithmetic: +, -, *, /, %
 * Relational: ==, !=, >, <, >=, <=
 * Logical: &&, ||, !
 * Bitwise: &, |, ^, ~, <<, >>
 * Assignment: =, +=, -=, *=, /=, %=
 * Unary: +, -, ++, --
 * Ternary: ? :
 */

public class File06_Operators {
    public static void main(String[] args) {
        int num1 = 7;
        int result = num1++;    // Post-increment: returns the value before incrementing
        System.out.println("Result: " + result);// Output: 7
        System.out.println("Num: " + num1);// Output: 8

        int num2 = 7;
        int result2 = ++num2;   // Pre-increment: returns the value after incrementing
        System.out.println("Result: " + result2);// Output: 8
        System.out.println("Num: " + num2);// Output: 8


        double a = 10;
        int b = 10;
        boolean c = a==b;
        boolean d = a!=b;
        System.out.println(c); // Output: true
        System.out.println(d); // Output: false



        // Short circuit evaluation
        // In Java, logical operators && and || use short-circuit evaluation.
        // In an expression using &&, if the first operand is false, the second operand is not evaluated.
        // Similarly, in an expression using ||, if the first operand is true, the second operand is not evaluated.
        int x = 7;
        int y = 5;
        boolean res = (x > 10) && (y >1);
        // The second condition (y > 1) is not evaluated because the first condition (x > 10) is false.
        System.out.println(res);// Output: false 


        // Ternary operator
        int n1=7;
        int n2=5;
        int max = (n1>n2) ? n1 : n2 ;
        System.out.println(max); // Output: 7
    }
}
