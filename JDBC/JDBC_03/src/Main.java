import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = ".....";

    public static void main(String[] args) {
        try {
            // ✅ Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            // ✅ INSERT
            String insertQuery = "INSERT INTO Students(name, age, marks) VALUES(?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, "Dhoni");
                pstmt.setInt(2, 43);
                pstmt.setDouble(3, 77.5);
                int insertedRow = pstmt.executeUpdate();
                System.out.println(insertedRow > 0 ? "✅ Insertion successful!" : "❌ Insertion failed!");
            }

            // ✅ UPDATE
            String updateQuery = "UPDATE Students SET marks=? WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setDouble(1, 99.9);
                pstmt.setInt(2, 1);
                int updatedRow = pstmt.executeUpdate();
                System.out.println(updatedRow > 0 ? "✅ Update successful!" : "❌ Update failed!");
            }

            // ✅ RETRIEVE
            String selectQuery = "SELECT * FROM Students WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
                pstmt.setInt(1, 1);
                ResultSet resultSet = pstmt.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    double marks = resultSet.getDouble("marks");

                    System.out.println("📄 Retrieved Student:");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Marks: " + marks);
                } else {
                    System.out.println("⚠️ No student found with ID 1.");
                }
            }

            // ✅ DELETE
            String deleteQuery = "DELETE FROM Students WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, 1); // delete student with id=1
                int deletedRow = pstmt.executeUpdate();
                System.out.println(deletedRow > 0 ? "✅ Delete successful!" : "❌ Delete failed.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}


/*
✅ Insertion successful!
✅ Update successful!
📄 Retrieved Student:
ID: 1
Name: Dhoni
Age: 43
Marks: 99.9
✅ Delete successful!
 */
