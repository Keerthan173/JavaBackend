/*
🔁 Transactions:
    A transaction is a group of SQL operations that must either all succeed or all fail.
    If one step fails, the entire operation is rolled back to maintain database consistency.

    Example Use Case:
    Transferring money from one account to another:
        Debit from account A ✅
        Credit to account B ✅
    → If either fails, the other must not proceed.
*/

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "root";
    private static final String password = ".....";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // ✅ Step 1: Disable auto-commit to start a transaction
            conn.setAutoCommit(false);

            System.out.print("Enter amount to transfer: ");
            double amount = sc.nextDouble();

            int fromAccount = 101;
            int toAccount = 102;

            // ✅ Optional check: Ensure sufficient balance
            if (!isSufficient(conn, fromAccount, amount)) {
                System.out.println("❌ Insufficient balance in account " + fromAccount);
                return;
            }

            try (
                    // ✅ Debit from source account
                    PreparedStatement debitStmt = conn.prepareStatement(
                            "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?");
                    // ✅ Credit to destination account
                    PreparedStatement creditStmt = conn.prepareStatement(
                            "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?")
            ) {
                // Set debit parameters
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);

                // Set credit parameters
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);

                int rowsDebited = debitStmt.executeUpdate();
                int rowsCredited = creditStmt.executeUpdate();

                if (rowsDebited > 0 && rowsCredited > 0) {
                    conn.commit(); // ✅ Commit transaction if both succeed
                    System.out.println("✅ ₹" + amount + " transferred from " + fromAccount + " to " + toAccount);
                } else {
                    conn.rollback(); // ❌ If either failed, rollback
                    System.out.println("❌ Transaction failed. Rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback(); // ❌ Rollback on exception
                System.out.println("❌ Error during transaction. Rolled back.");
                System.out.println("Error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    // ✅ Check if account has enough balance
    static boolean isSufficient(Connection conn, int account_number, double amount) {
        String query = "SELECT balance FROM Accounts WHERE account_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, account_number);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                double current_balance = resultSet.getDouble("balance");
                return current_balance >= amount;
            }
        } catch (SQLException e) {
            System.out.println("Error checking balance: " + e.getMessage());
        }
        return false;
    }
}

/*
Output Example:
Enter amount to transfer: 500
✅ ₹500.0 transferred from 101 to 102
 */


/*

| 🔧   Concept           |                             Meaning                                              |
| ---------------------- | -------------------------------------------------------------------------------- |
| `setAutoCommit(false)` | Tells Java not to save changes automatically — you will decide when to save.     |
| `commit()`             | **Saves** all the changes made in the transaction.                               |
| `rollback()`           | **Cancels** all changes if something goes wrong.                                 |
| `try-with-resources`   | Automatically **closes** the database connection and statements when done.       |

 */