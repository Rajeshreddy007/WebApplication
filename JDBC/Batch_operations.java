import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch_operations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PreparedStatement pst = null;
		Connection connect = null;
		try {
			connect = REUSE.getConnection();
			String sql = "INSERT INTO employees Values(?,?,?,?,?)";
			pst = connect.prepareStatement(sql);
			
			//
			boolean status = true;
			while(status) {
				System.out.print("---Options---\n1.Insert Operation\n2.Exit\nEnter option : ");
				int n=sc.nextInt();
				switch(n) {
				case 1:
					System.out.print("Enter id : ");
					int id = sc.nextInt();
					System.out.print("Enter name : ");
					String name = sc.next();
					System.out.print("Enter age : ");
					int age = sc.nextInt();
					System.out.print("Enter Gender(M/F) : ");
					String gender = sc.next();
					System.out.print("Enter city : ");
					String city = sc.next();
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, age);
					pst.setString(4,gender);
					pst.setString(5, city);
					pst.addBatch();
					break;
				case 2:
					status=false;
					break;
				default:
					System.out.println("Enter valid Option");
				}
			}
	
			int[] result = pst.executeBatch();
			if (result[0]==0) {
				System.out.println("Unable to Insert");
			} else {
				System.out.println("Data Inserted Successfully");
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