import java.util.Scanner;

public class File07_Conditionals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nested if-else: Grade classification
        System.out.print("Enter your marks (0-100): ");
        int marks = sc.nextInt();

        if (marks >= 0 && marks <= 100) {
            if (marks >= 90) {
                System.out.println("Grade: A+");
            } else if (marks >= 75) {
                System.out.println("Grade: A");
            } else if (marks >= 60) {
                System.out.println("Grade: B");
            } else if (marks >= 40) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: F (Fail)");
            }
        } else {
            System.out.println("Invalid marks entered.");
        }

        // 2. Ternary operator: Pass/fail
        String result = (marks >= 40 && marks <= 100) ? "Passed" : "Failed";
        System.out.println("Result (ternary): " + result);

        // 3. Switch-case: Day type mapping
        System.out.print("Enter day number (1-7): ");
        int day = sc.nextInt();

        switch (day) {
            case 1:
            case 7:
                System.out.println("Weekend - Rest day");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Weekday - Work/Study day");
                break;
            default:
                System.out.println("Invalid day number");
        }

        sc.close();
    }
}

/*
Output example:
Enter your marks (0–100): 77
Grade: A
Result (ternary): Passed
Enter day number (1-7): 7
Weekend - Rest day
*/
