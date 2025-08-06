## 📚 What is JDBC?

JDBC is a Java API that allows Java programs to connect and interact with relational databases like MySQL.

---


Four Types of JDBC Drivers
---

- Type 1: JDBC-ODBC Bridge Driver - Converts JDBC calls into ODBC calls, which then go to the database. Slow & outdated.
- Type 2: Native-API Driver - Converts JDBC calls into native C/C++ DB API. Needs native libraries. OS-dependent.
- Type 3: Network Protocol Driver - Sends JDBC calls to a middleware server, which talks to the database. Rarely used.
- Type 4: Thin Driver (Pure Java) - Talks directly to the DB using Java & DB protocol. Fast, portable. Used in real apps.


Which One Do We Use?
--
Type 4 (Thin Driver) 
-
    Class.forName("com.mysql.cj.jdbc.Driver");
It is pure Java, no installation needed, and connects directly to the database.


---


## JDBC 4 main components
1. `DriverManager` - Manages drivers. Helps Java connect to the correct database by using the right driver.
     👉 Example: `DriverManager.getConnection(...)`         
2. `Connection` - Represents the connection between Java and the database.
    All SQL queries are sent through this connection.                                   
3. `Statement` & `PreparedStatement` - Used to **send SQL queries** to the database. 
     - `Statement`: for static SQL
     - `PreparedStatement`: for dynamic/parameterized queries (safer) 
4. `ResultSet` - **Holds data returned** from a SELECT query.
    We can use `.next()`, `.getString()`, etc., to read results row-by-row.                                 |


---


## 🧪 How to Run

1. Create a MySQL database, e.g. `mydb`
2. Create table `Students`:
    ```sql
    CREATE TABLE Students (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        age INT NOT NULL,
        marks DOUBLE NOT NULL
    );
    INSERT INTO Students (name, age, marks) VALUES ('Keerthan K', 20, 85.5);
    ```

3. Set up JDBC in your Java project:
   -
   🔹 Step 1: Download MySQL JDBC Driver
        Go to the official site: https://dev.mysql.com/downloads/connector/j/
        Download the platform-independent ZIP archive.
        Extract the ZIP. Inside you’ll find the JAR file: mysql-connector-j-8.0.xx.jar

    🔹 Step 2: Add the JAR to Your Java Project
        ✅ If you're using IntelliJ IDEA:
        Click Project Structure → Libraries.
        Click the + button → Choose Java.
        Select the mysql-connector-j-8.0.xx.jar file you downloaded.
        Click OK and apply.

5. Update the following in your Java file:
    ```java
    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "root";
    private static final String password = "";
    ```

6. Compile and run:
    ```bash
    javac Main.java
    java Main
    ```

---
