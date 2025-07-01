<%@ page import="java.sql.*" %>
<%@ page import="Util.DBUtil" %>

<%
    String User = (String) session.getAttribute("User");
    if (User == null) response.sendRedirect("/WebApplication/index.html");
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
        }

        .container {
            width: 70%;
            margin: 50px auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }

        h2, h3 {
            text-align: center;
            color: #333;
        }

        .user-info {
            margin-top: 30px;
            font-size: 18px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .user-info strong {
            color: #0062cc;
            font-size: 20px;
        }

        .logout-btn {
            display: block;
            width: fit-content;
            margin: 30px auto 0 auto;
            padding: 10px 20px;
            background-color: #0062cc;
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            transition: background 0.3s;
        }

        .logout-btn:hover {
            background-color: #004a99;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= User %>!</h2>
        <h3>Your Details</h3>
        <%
            Connection con = null;
            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                con = DBUtil.getConnection();
                st = con.prepareStatement("SELECT * FROM users WHERE username=?");
                st.setString(1, User);
                rs = st.executeQuery();

                while (rs.next()) {
        %>
            <div class="user-info">
                <p><strong><%= rs.getString("name") %></strong></p>
                <p>Email: <%= rs.getString("email") %></p>
                <p>Phone: <%= rs.getString("phone") %></p>
                <p>Gender: <%= rs.getString("gender") %></p>
                <p>DOB: <%= rs.getDate("dob") %></p>
            </div>
        <%
                }
            } catch (Exception e) {
                out.println("<p>Error loading user data: " + e.getMessage() + "</p>");
            } finally {
                DBUtil.close(con, st, rs);
            }
        %>
        <a class="logout-btn" href="/WebApplication/index.html">Logout</a>
    </div>
</body>
</html>
