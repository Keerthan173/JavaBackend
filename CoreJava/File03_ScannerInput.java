import java.util.Scanner;

public class File03_ScannerInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Using next() - reads one word(until space)
        System.out.print("Enter your first name (using next()): ");
        String firstName = sc.next();

        // 2. Fix for nextLine() after next() or nextInt()
        sc.nextLine(); // Clear the leftover newline

        // 3. Using nextLine() - reads full line(until Enter)
        System.out.print("Enter your full name (using nextLine()): ");
        String fullName = sc.nextLine();

        // 4. nextInt() followed by nextLine() (common issue fix)
        // Common Issue:
        // After using nextInt(), nextDouble(), etc., the newline (\n) remains in the input buffer.
        // So, if you follow it immediately with nextLine(), it may read empty string.
        // Fix:
        // Use an extra sc.nextLine(); to consume the leftover newline.
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        sc.nextLine(); // Consume newline left by nextInt()

        System.out.print("Enter your college name: ");
        String college = sc.nextLine();


        System.out.println("\n--- Output ---");
        System.out.println("First Name (next): " + firstName);
        System.out.println("Full Name (nextLine): " + fullName);
        System.out.println("Age: " + age);
        System.out.println("College: " + college);

        sc.close();
    }
}

/*
Output:
Enter your first name (using next()): Keerthan K
Enter your full name (using nextLine()): Keerthan K
Enter your age: 20
Enter your college name: SCEM

--- Output ---
First Name (next): Keerthan
Full Name (nextLine): Keerthan K
Age: 20
College: SCEM
*/
