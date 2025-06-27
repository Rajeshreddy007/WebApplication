import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC_UPDATE {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Class loader and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish Connection
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="Rajesh4795@";
		Connection connect = DriverManager.getConnection(url, username, password);
		
		//create statement
		Statement statement = connect.createStatement();
		
		//Execute SQL Query
		String sql="UPDATE employees SET emp_name='SHIVANI' where emp_id=3";
		int result = statement.executeUpdate(sql);
		
		//process result
		if(result==0)
			System.out.println("Unable to execute Operation");
		else
			System.out.println("Operation Executed Successfully");
		
		//close resources
		statement.close();
		connect.close();
		
		
	}

}
