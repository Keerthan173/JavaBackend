/*
 * Type casting is the process of converting a variable from one data type to another.
 * Widdening conversion (implicit) occurs automatically when converting from a smaller to a larger data type.
 * Narrowing conversion (explicit) requires a cast operator to convert from a larger to a smaller data type.
 */

public class File05_TypeCasting {
    public static void main(String[] args) {
        // Widening conversion (implicit)
        int num = 100;
        double d = num; // int to double
        System.out.println(d); // Output: 100.0

        // Narrowing conversion (explicit)
        double d2 = 100.99;
        int num2 = (int) d2; // double to int
        System.out.println(num2); // Output: 100



        // What is byte?
        // Byte is a data type in Java that can hold an 8-bit signed integer value.
        // It can store values from -128 to 127.
        // 0 = 0
        // 127 = 127
        // 128 = -128 (wraps around)
        // 129 = -127 (wraps around)
        // 255 = -1 (wraps around)
        // 256 = 0 (wraps around)

        // Byte to int (widening)
        byte b = 10;
        int num3 = b; // byte to int (widening)
        System.out.println(num3); // Output: 10

        // Int to byte (narrowing)
        int num4 = 1000;
        byte b2 = (byte) num4; // int to byte (narrowing)
        System.out.println(b2); // Output: -24 ( 1000 % 256 = 1000 - 3 * 256 = 1000 - 768 = 232, which is -24 in signed byte representation)


        // Type Promotion
        // In Java, when performing arithmetic operations, smaller data types are promoted to larger data types.
        byte b3 = 10;
        byte b4 = 20;
        int sum = b3 + b4; // byte to int (promotion)
        System.out.println(sum); // Output: 30
    }
}