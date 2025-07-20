import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb"; //'mydb' is database name
    private static final String username = "root";
    private static final String password = ".....";

    public static void main(String[] args) {
        // ✅ Step 1: Load the JDBC driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ✅ Step 2: Try to connect and use the connection
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection success!");

            // ✅ Step 3: Create a Statement object to run SQL
            Statement statement = conn.createStatement();
            //Reads and prints student data from a Students table
            String query = "SELECT * FROM Students;";

            // ✅ Step 4: Execute the query and get results
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id"); // Get column by name
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                // ✅ Step 6: Print the row
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("----------------------");
            }


            // Inserting data
            String query1 = String.format("INSERT INTO Students(name, age, marks) VALUES('%s', %d, %.2f)","Rahul", 20, 74.5);
            int rowsAffected = statement.executeUpdate(query1);
            if(rowsAffected>0){
                System.out.println("Data Insertion Completed!");
            }else{
                System.out.println("Insertion failed!");
            }




            // Updating the data
            String query3 = String.format("UPDATE Students SET age=%d WHERE id=%d",77,1);
            int updatedRow = statement.executeUpdate(query3);
            if(updatedRow>0){
                System.out.println("Data updating success!");
            }
            else{
                System.out.println("Updating data failure!");
            }



            // Deletion
            String deleteQuery = "DELETE FROM Students WHERE id = 2";
            int deletedRow = statement.executeUpdate(deleteQuery);
            if (deletedRow > 0) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("No student found with the given ID.");
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
/*
Connection success!
ID: 1
Name: Amit
Age: 21
Marks: 94.5
----------------------

Data Insertion Completed!
Data updating success!
Delete successful!
*/

/*

❌ Disadvantages of Using Statement in JDBC
| # | Problem                         | Explanation                                                                                               |
| - | ------------------------------- | --------------------------------------------------------------------------------------------------------- |
| 1 | **SQL Injection Risk**          | If you build queries by joining strings (e.g., user inputs), attackers can inject malicious SQL.          |
| 2 | **Hard to Maintain**            | Concatenating strings for queries becomes messy and error-prone in big projects.                          |
| 3 | **No Query Reuse**              | Each time a new query is built, it's recompiled in the database — slower compared to `PreparedStatement`. |

 */