//Non sql query - create table
package createtable;
import java.sql.*;

public class Createtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Chandu@1502");
			Statement stmt = conn.createStatement();
			String sql = "Create table employee(id int primary key,name varchar(10),salary double)";
			stmt.executeUpdate(sql);
			System.out.println("Table create successfully");
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
