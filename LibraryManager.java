import java.sql.*;
import java.util.*;

public class LibraryManager {

    // Add new book
    public void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author, issued) VALUES (?, ?, false)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();
            System.out.println("✅ Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Issue a book
    public void issueBook(int id) {
        String sql = "UPDATE books SET issued = true WHERE id = ? AND issued = false";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("📖 Book issued successfully!");
            else
                System.out.println("⚠️ Book not available or already issued.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Return a book
    public void returnBook(int id) {
        String sql = "UPDATE books SET issued = false WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("🔄 Book returned successfully!");
            else
                System.out.println("⚠️ Invalid book ID.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all books
    public void viewBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n📚 Library Books:");
            while (rs.next()) {
                Book b = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getBoolean("issued")
                );
                System.out.println(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
