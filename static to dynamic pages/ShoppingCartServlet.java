import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if the user has a valid session
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionId".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                    break;
                }
            }
        }

        if (sessionId != null) {
            // Render the shopping cart page for the user
            response.setContentType("text/html");
            response.getWriter().println("<html><head><title>Shopping Cart</title></head><body>");
            response.getWriter().println("<h1>Welcome to Your Shopping Cart</h1>");
            response.getWriter().println("<p>User ID: " + sessionId + "</p>");
            response.getWriter().println("<p>Shopping Cart Contents: [Product 1, Product 2, ...]</p>");
            response.getWriter().println("</body></html>");
        } else {
            // Redirect to the login page if the user doesn't have a valid session
            response.sendRedirect("login.html");
        }
    }
}
