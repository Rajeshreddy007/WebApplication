package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/userdb";
	private static final String USER = "root";
	private static final String PASS = "Rajesh4795@";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load Driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ignored) {
		}
		try {
			if (st != null)
				st.close();
		} catch (Exception ignored) {
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ignored) {
		}
	}
}
