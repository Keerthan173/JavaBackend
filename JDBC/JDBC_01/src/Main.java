import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String url="jdbc:mysql://localhost:3306/?user=root";
    private static final String username="root";
    private static final String password=".....";

    public static void main(String[] args) {

        // ✅ Step 1: Load MySQL JDBC Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                //com.mysql.cj.jdbc.Driver is the class name of the MySQL JDBC driver
                //Class.forName(...) loads that class at runtime.
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!" + e.getMessage());
            return; // Stop execution if driver not found
        }

        // ✅ Step 2: Establish the database connection
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            // DriverManager.getConnection(...) - A static method that tries to create a connection to the database.
            // Connection - Is a Java interface, represents an open link between your Java program and the database.
            System.out.println("Database connection established successfully!");

        }catch (SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }
        // ✅ Always use try-with-resources for auto-closing Connection
    }
}
