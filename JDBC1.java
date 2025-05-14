//Sample code to connect mysql using JDBC
package jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class jdbc1example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/college";
		String user = "root";
        String password = "Chandu@1502";
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("User Data:");
            while (rs.next()) {
                int id = rs.getInt("rollno");
                String name = rs.getString("name");
                //String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name );
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error:");
            e.printStackTrace();
        }
	}

}
