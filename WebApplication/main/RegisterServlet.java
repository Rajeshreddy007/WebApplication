import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Util.DBUtil;

import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String uname=req.getParameter("userName");
		String name = req.getParameter("fullName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String password = req.getParameter("password");

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement(
					"INSERT INTO users (username, name, email, phone, gender, dob, password) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, uname);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, phone);
			pst.setString(5, gender);
			pst.setString(6, dob);
			pst.setString(7, password);

			int i = pst.executeUpdate();
			if (i > 0) {
				res.sendRedirect("/WebApplication/home.jsp");
			} else {
				req.setAttribute("error", "Registration failed");
				res.sendRedirect("/WebApplication/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Registration failed");
			res.sendRedirect("/WebApplication/error.jsp");
		} finally {
			DBUtil.close(con, pst, null);
		}
	}
}
