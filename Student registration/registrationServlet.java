import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
  
@WebServlet("/RegistrationServlet") 
public class RegistrationServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
  
    // JDBC database URL, username, and password 
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/yourdatabase"; 
    private static final String JDBC_USER = "yourusername"; 
    private static final String JDBC_PASSWORD = "yourpassword"; 
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        // Retrieve form data 
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName"); 
        String email = request.getParameter("email"); 
        String phone = request.getParameter("phone"); 
        String event = request.getParameter("event"); 
  
        // Database connection and insertion 
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, 
JDBC_PASSWORD)) { 
            String sql = "INSERT INTO registrations (first_name, last_name, email, phone, event) 
VALUES (?, ?, ?, ?, ?)"; 
            try (PreparedStatement statement = connection.prepareStatement(sql)) { 
                statement.setString(1, firstName); 
                statement.setString(2, lastName); 
                statement.setString(3, email); 
                statement.setString(4, phone); 
                statement.setString(5, event); 
                statement.executeUpdate(); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
  
        // Display registration success message 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("<html><head><title>Registration Success</title></head><body>"); 
        out.println("<h2>Registration Successful</h2>"); 
        out.println("<p>Thank you, " + firstName + " " + lastName + ", for registering for " + 
event + ".</p>"); 
        out.println("</body></html>"); 
    } 
} 

