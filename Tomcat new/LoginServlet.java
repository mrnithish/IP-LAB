package com.yourpackage; 
  
import java.io.IOException; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
  
@WebServlet("/login") 
public class LoginServlet extends HttpServlet { 
  
    private static final long serialVersionUID = 1L; 
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        String userId = request.getParameter("userId"); 
        String password = request.getParameter("password"); 
  
        // In a real-world scenario, user information should be retrieved from a database 
        // For simplicity, we are hardcoding user information here 
        User user = new User("user123", "password123", "1234-5678-9012-3456"); 
  
        if (userId.equals(user.getUserId()) && password.equals(user.getPassword())) { 
            HttpSession session = request.getSession(true); 
            session.setAttribute("user", user); 
            response.sendRedirect("products"); 
        } else { 
            response.sendRedirect("index.html"); 
        } 
    } 
}