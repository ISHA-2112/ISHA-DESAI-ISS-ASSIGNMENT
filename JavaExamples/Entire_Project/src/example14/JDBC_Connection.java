package example14;

import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBC_Connection {
	private static final Logger logger = LogManager.getLogger("example14");

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://LAPTOP-IVO2FEIG;databaseName=Exam;integratedSecurity=true;encrypt=false";
     

        // Insert some sample data
        insertPersonData(url,1004,  "Smith", "John");
        insertPersonData(url,1005, "Doe", "Jane");

        // Retrieve and print all person data
        retrievePersonData(url);
    }

    // Method to insert person data into the database
    private static void insertPersonData(String url, int ID, String lastName, String firstName) {
        String sql = "INSERT INTO ExamData (ID, LastName, FirstName) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, ID);
        	statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.executeUpdate();
            logger.info("Inserted person data for " + firstName + " " + lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve and print person data from the database
    private static void retrievePersonData(String url) {
        String sql = "SELECT * FROM ExamData where ID = 870";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            logger.info("Person data:");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String lastName = resultSet.getString("LastName");
                String firstName = resultSet.getString("FirstName");
                logger.info("ID: " + id + ", LastName: " + lastName + ", FirstName: " + firstName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
