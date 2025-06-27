import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepared_Statement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PreparedStatement pst = null;
		Connection connect = null;
		try {
			connect = REUSE.getConnection();
			String sql = "UPDATE employees SET emp_address=? WHERE emp_id=?";
			pst = connect.prepareStatement(sql);
			System.out.print("Enter City to Update : ");
			String city = sc.next();
			System.out.print("Enter Emp id : ");
			int id = sc.nextInt();
			pst.setString(1, city);
			pst.setInt(2, id);
			int result = pst.executeUpdate();
			if (result == 0) {
				System.out.println("Unable to UPDATE");
			} else {
				System.out.println("Updated Successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				REUSE.getClose(connect, pst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
