import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppletExample extends Applet {
    private static final long serialVersionUID = 1L;

    public void init() {
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // URL of the servlet
                    URL url = new URL(getCodeBase(), "AppletServlet");

                    // Open a connection to the servlet
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // Set the request method to POST
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);

                    // Send data to the servlet
                    OutputStream out = connection.getOutputStream();
                    out.write("Data from Applet".getBytes());
                    out.close();

                    // Read the response from the servlet
                    // (In a real-world scenario, you might want to handle the response)
                    int responseCode = connection.getResponseCode();
                    System.out.println("Response Code: " + responseCode);

                    connection.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(submitButton);
    }
}
