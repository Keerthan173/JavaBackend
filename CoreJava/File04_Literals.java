/*
 * Literals are fixed values that are represented directly in the code.
 * They can be of various types such as integers, floating-point numbers, characters, and strings.
 */

public class File04_Literals{
    public static void main(String[] args) {
        int num1 = 3;// Decimal literal
        int num2 = 0b101; // Binary literal (equivalent to 5)
        int num3 = 0x3A; // Hexadecimal literal (equivalent to 58) - 3A in hexadecimal is 3*16^1 + 10*16^0 = 48 + 10 = 58
        System.out.println(num1);// Output: 3
        System.out.println(num2);// Output: 5
        System.out.println(num3);// Output: 58

        int n1 = 10_00_000; // Underscores in numeric literals for readability
        System.out.println(n1); // Output: 1000000

        double x = 12e3; // Scientific notation (12 * 10^3 = 12000.0)
        System.out.println(x); // Output: 12000.0
        double y = 32e10; // Scientific notation (32 * 10^10 = 320000000000.0)
        System.out.println(y); // Output: 3.2E11

        char ch = 'A'; // Character literal
        ch++;
        System.out.println(ch); // Output: B
    }
}