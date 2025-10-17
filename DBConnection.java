import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db",
                "root",     // your username
                "rootlibrary"  // your MySQL password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
