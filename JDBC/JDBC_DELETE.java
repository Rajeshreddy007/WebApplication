import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC_DELETE {

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
		String sql="DELETE FROM employees WHERE emp_id=4";
		int result = statement.executeUpdate(sql);
		
		//process result
		if(result==0)
			System.out.println("Delete Operation Failed");
		else
			System.out.println("Deleted Successfully");
		
		//close resources
		statement.close();
		connect.close();
		
		
	}

}
