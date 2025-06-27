import java.sql.*;
public class JDBC_INSERT {

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
		String sql="INSERT INTO employees (emp_id,emp_name,emp_age,emp_gender,emp_address) "
				+ "VALUES (1,'RAJESH',21,'M','NALGONDA'), (2,'RAM',23,'M','HYDERABAD'), (3,'SHIVA',25,'M','VIZAG'), (4,'KRISHNA',22,'M','WARANGAL'), (5,'SITHA',22,'F','SURYAPET');";
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
