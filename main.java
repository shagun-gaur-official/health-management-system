/* src/Main.java - Simple JDBC demo that lists patients
   Note: Update DB URL/USER/PASS before running. This is a skeleton for demo.
*/
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/healthdb";
        String user = "root";
        String pass = "your_password_here";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String q = "SELECT id, name, age, gender, contact FROM patients";
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(q)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("age"));
                }
            }
        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }
    }
}
