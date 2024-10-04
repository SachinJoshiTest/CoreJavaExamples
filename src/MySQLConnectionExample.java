import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        // Database credentials
        String jdbcURL = "jdbc:mysql://your_hostname(localhost if local database):3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Column1: " + resultSet.getInt("student_id"));
                System.out.println("Column2: " + resultSet.getString("first_name"));
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

