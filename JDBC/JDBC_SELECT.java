import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_SELECT {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Class loader and register
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establish Connection
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "Rajesh4795@";
		Connection connect = DriverManager.getConnection(url, username, password);

		// create statement
		Statement statement = connect.createStatement();

		// Execute SQL Query
		String sql = "SELECT * FROM employees";
		ResultSet result = statement.executeQuery(sql);

		// process result
		while (result.next()) {
			System.out.println(
					result.getInt("emp_id") + " " + result.getString("emp_name") + " " + result.getInt("emp_age") + " "
							+ result.getString("emp_gender") + " " + result.getString("emp_address"));
		}

		// close resources
		result.close();
		statement.close();
		connect.close();

	}

}
