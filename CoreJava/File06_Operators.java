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
    }
}