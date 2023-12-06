import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameter
        String inputData = request.getParameter("inputData");

        // Process the data (you can perform any action here)
        String result = "Processed data: " + inputData;

        // Send the result back to the client
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Servlet Result</title></head><body>");
        response.getWriter().println("<h2>Result:</h2>");
        response.getWriter().println("<p>" + result + "</p>");
        response.getWriter().println("</body></html>");
    }
}

