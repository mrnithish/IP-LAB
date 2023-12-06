import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // Validate user credentials (in a real application, this should be done securely)
        if ("user123".equals(userId) && "password123".equals(password)) {
            // Create a session ID (for simplicity, using the user ID as the session ID)
            String sessionId = userId;

            // Set a cookie for session tracking
            Cookie sessionCookie = new Cookie("sessionId", sessionId);
            response.addCookie(sessionCookie);

            response.sendRedirect("shopping-cart");
        } else {
            response.sendRedirect("login.html");
        }
    }
}

