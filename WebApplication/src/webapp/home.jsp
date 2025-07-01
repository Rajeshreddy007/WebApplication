<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
    if (message == null) {
        message = "Action completed successfully!";
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #00b09b, #96c93d);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .success-container {
            background-color: #fff;
            padding: 40px 50px;
            border-radius: 15px;
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 90%;
            max-width: 400px;
            animation: fadeIn 0.6s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: scale(0.95); }
            to { opacity: 1; transform: scale(1); }
        }

        .success-container h1 {
            font-size: 28px;
            color: #2e7d32;
            margin-bottom: 15px;
        }

        .success-container p {
            font-size: 16px;
            color: #333;
            margin-bottom: 25px;
        }

        .login-btn {
            background-color: #2e7d32;
            color: #fff;
            padding: 12px 25px;
            text-decoration: none;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-btn:hover {
            background-color: #1b5e20;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h1>Success!</h1>
        <p><%= message %></p>
        <form action="index.html">
            <button class="login-btn">Go to Login Page</button>
        </form>
    </div>
</body>
</html>
