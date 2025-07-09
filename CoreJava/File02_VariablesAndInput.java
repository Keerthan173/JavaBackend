import java.util.Scanner;

public class File02_VariablesAndInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        float weight = 77.7f;
        char grade = 'A';
        boolean isPassed = true;
        System.out.println("Weight : "+weight + "\nGrade :"+grade + "\nisPassed : "+isPassed);

        sc.close();
    }
}

/*
Output:
Enter your name: MS Dhoni
Enter your age: 43
Hello, MS Dhoni! You are 43 years old.
Weight : 77.7
Grade :A
isPassed : true
*/