import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppletServlet")
public class AppletServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Read data from the applet
        BufferedReader reader = request.getReader();
        StringBuilder data = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            data.append(line);
        }

        // Process the data (you can perform any action here)
        String result = "Processed data from Applet: " + data.toString();

        // Send the result back to the applet
        response.setContentType("text/plain");
        response.getWriter().write(result);
    }
}

