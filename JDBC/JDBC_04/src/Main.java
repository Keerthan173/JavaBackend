/*

Batch Processing:
    Batch processing in JDBC means sending multiple SQL statements to the database in one go instead of executing them one by one.
    This improves performance and reduces the number of database calls.

 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private final  static String url = "jdbc:mysql://localhost:3306/mydb";
    private final  static String username = "root";
    private final  static String password = ".....";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String insertQuery = "INSERT INTO Students (name, age, marks) VALUES(?, ?, ?)";
            try(PreparedStatement pstmt = conn.prepareStatement(insertQuery)){

                while(true){
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    // Clear the buffer
                    sc.nextLine();

                    pstmt.setString(1, name);
                    pstmt.setInt(2, age);
                    pstmt.setDouble(3, marks);

                    // ✅ Set values for the batch
                    pstmt.addBatch();

                    System.out.println("Type NO to stop entering more records (or press Enter to continue): ");
                    String check = sc.nextLine();

                    if(check.equalsIgnoreCase("NO")){
                        System.out.println("Thank you! Inserting batch...");
                        break;
                    }
                }

                // ✅ Execute the batch
                int[] insertedRows = pstmt.executeBatch(); // Returns an int[] array (0/1)
                System.out.println("✅ Records inserted: " + insertedRows.length);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

/*

Enter name: ABCD
Enter age: 26
Enter marks: 100
Type NO to stop entering more records (or press Enter to continue):

Enter name: XYZ
Enter age: 20
Enter marks: 95
Type NO to stop entering more records (or press Enter to continue):
no
Thank you! Inserting batch...
✅ Records inserted: 2

*/
