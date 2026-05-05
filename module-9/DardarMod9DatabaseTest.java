package dardarmod9databasetest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DardarMod9DatabaseTest {

    public static void main(String[] args) {

        try {
            // Connect to database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/databasedb", 
                "student1", 
                "pass"
            );

            System.out.println("Connected to database!");

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

            // Print results
            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + " | " +
                    rs.getString("FIRSTNAME") + " " +
                    rs.getString("LASTNAME") + " | " +
                    rs.getString("CITY")
                );
            }

            // Close connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}