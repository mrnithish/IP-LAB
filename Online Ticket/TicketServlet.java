import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String destination = request.getParameter("destination");
        String date = request.getParameter("date");

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
        response.getWriter().println("<html><head><title>Ticket Information</title></head><body>");
        response.getWriter().println("<h2>Ticket Information:</h2>");
        response.getWriter().println("<p><strong>Destination:</strong> " + destination + "</p>");
        response.getWriter().println("<p><strong>Date:</strong> " + date + "</p>");
        response.getWriter().println("<p><strong>Hit Count:</strong> " + hitCount + "</p>");
        response.getWriter().println("</body></html>");
    }
}

