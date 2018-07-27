package konstYcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/db_konsty"; 	
	static final String USER = "root";
	static final String PASSWORD = "password";
	Connection connection = null;
	Statement statement = null;
	
	public String logIn() {
		String returnStatement = "";

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();
			
		    //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//System.out.println("test!");
			
			//String insert = "INSERT into konstyuser VALUES ('hej@hejsan.se', 'hej', 'Hejsan_Hejsson', 7, 'M30 X77')";
			//statement.executeUpdate(insert);
			
			String emailFromDb = "";
			String passwordFromDb = "";
			
			String select = "SELECT email, password FROM konstyuser";
			ResultSet rs = statement.executeQuery(select);
			while (rs.next()) {
				emailFromDb = rs.getString("email");
				passwordFromDb = rs.getString("password");
				returnStatement += emailFromDb + " " + passwordFromDb;
			}
			rs.close();			
			
			/*if (emailFromDb == inputEmail && passwordFromDb == inputPassword) 
				returnStatement =
			else
				returnStatement =*/
					
		} 
		catch (SQLException e) {
			//io?
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null)
					statement.close();
			}
			catch(SQLException e) {	}
			
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) { }
		}
		
		return returnStatement;

	}
}
