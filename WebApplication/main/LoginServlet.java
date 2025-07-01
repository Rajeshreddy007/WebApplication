import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Util.DBUtil;

import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();

			if (rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("User", username);
				res.sendRedirect("/WebApplication/dashboard.jsp");
			} else {
				req.setAttribute("error", "Invalid credentials");
				res.sendRedirect("/WebApplication/loginerror.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pst, rs);
		}
	}
}
