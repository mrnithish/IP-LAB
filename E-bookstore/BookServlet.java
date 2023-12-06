import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String bookTitle = request.getParameter("bookTitle");
        String author = request.getParameter("author");

        // Update hit count using session tracking
        HttpSession session = request.getSession();
        Integer hitCount = (Integer) session.getAttribute("hitCount");
        if (hitCount == null) {
            hitCount = 1;
        } else {
            hitCount++;
        }
        session.setAttribute("hitCount", hitCount);

        // Display results
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Book Information</title></head><body>");
        response.getWriter().println("<h2>Book Information:</h2>");
        response.getWriter().println("<p><strong>Title:</strong> " + bookTitle + "</p>");
        response.getWriter().println("<p><strong>Author:</strong> " + author + "</p>");
        response.getWriter().println("<p><strong>Hit Count:</strong> " + hitCount + "</p>");
        response.getWriter().println("</body></html>");
    }
}
