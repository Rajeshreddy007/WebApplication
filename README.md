# User Registration and Login Web Application




https://github.com/user-attachments/assets/981564da-1ca6-46f2-8169-c84bf9d4e8f5


This is a Java-based web application that allows users to **register, log in, and view their details** through a clean and intuitive interface. It uses Java Servlets, JSP, JDBC, and MySQL for backend operations, with HTML, CSS, and Bootstrap for frontend design. This project demonstrates a practical, full-stack implementation of user authentication and session management.

---

## 🚀 Features

✅ **User Registration**  
- New users can register by providing their username, full name, email, phone, gender, date of birth, and password.  
- User data is stored securely in a MySQL database.  
- On successful registration, users are redirected to a home page.

✅ **User Login**  
- Authenticates users against stored credentials using their username and password.  
- On success, a session is created to track the user.  
- Redirects users to a personalized dashboard displaying their details.

✅ **Database Utility Layer**  
- Centralized `DBUtil` class to manage database connections and safely close resources.  
- Simplifies and standardizes database access.

✅ **Error Handling**  
- Provides consistent error pages for registration or login failures.  
- Gracefully handles exceptions and redirects users to informative error messages.

✅ **Responsive UI**  
- Built with Bootstrap 4 for responsiveness across devices.  
- Features a tab-based interface for easy switching between login and registration forms.  
- Clean, modern, and user-friendly design.

---

## 🛠️ Tech Stack

- **Java (Servlets & JSP)** for server-side logic  
- **MySQL** for database storage  
- **JDBC** for database communication  
- **Bootstrap 4** & custom CSS for responsive design  
- **HTML5** for markup structure  
- **JSP** for dynamic content rendering  

---

## 📐 Architecture Overview

- **Presentation Layer**: HTML, JSP, Bootstrap for user interface and user interactions.  
- **Controller Layer**: Servlets handle business logic, manage form submissions, and handle redirects.  
- **Data Access Layer**: JDBC-based interactions handled via a reusable `DBUtil` class for connection management.  
- **Database**:  
  - MySQL database `userdb` with a `users` table.  
  - Fields include: username, name, email, phone, gender, date of birth, and password.

---

## 👥 User Journey

1. **Landing Page**  
   - Tab navigation for Login and Registration.

2. **Registration**  
   - Users complete a form with their details.  
   - Data is inserted into the database on submission.  
   - Redirects to a success page or home page.

3. **Login**  
   - Users enter their credentials.  
   - If correct, session attributes are created, and the user is redirected to a personalized dashboard.  
   - If incorrect, redirected to an error page.

4. **Dashboard**  
   - Displays user details fetched from the database.

5. **Logout**  
   - Ends the session and returns the user to the index page.

---

## 🌟 Key Highlights

- Complete registration and login lifecycle with session management  
- Centralized database utilities  
- MVC-style separation of concerns  
- Simple, modern, and responsive design  
- Cleanly extensible for advanced features

---

## 🏗️ Possible Future Enhancements
  
- Add **Spring MVC** or Spring Boot for a robust framework  
- Implement **email verification** for new users  
- Add **forgot password** and **reset password** functionality  
- Add logging features  

---

## 🎯 Learning Outcomes

This project is an excellent demonstration of:

- Java EE fundamentals (Servlets & JSP)  
- JDBC database access  
- Session handling  
- Modular design principles  
- Bootstrap-based responsive UIs

It is a great starting point for further enhancements and learning full-stack Java development.

---

**Happy coding! 🚀**
