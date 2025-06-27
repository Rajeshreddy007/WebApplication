import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_EXCEPTIONALHANDLING {

	public static void main(String[] args) {
		Connection connect = null;
		Statement statement = null;
		try {
			connect = REUSE.getConnection();

			// create statement
			statement = connect.createStatement();

			// Execute SQL Query
			String sql = "UPDATE employees SET emp_name='RAJU' WHERE emp_id=4";
			int result = statement.executeUpdate(sql);

			// process result
			if (result == 0)
				System.out.println("Unable to execute Operation");
			else
				System.out.println("Operation Executed Successfully");

		} catch (SQLException e) {
			e.fillInStackTrace();
		} finally {
			try {
				REUSE.getClose(connect, statement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
