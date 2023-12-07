 
import java.applet.Applet; 
import java.awt.Button; 
import java.awt.Label; 
import java.awt.TextField; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.IOException; 
import java.io.InputStream; 
import java.net.HttpURLConnection; 
import java.net.MalformedURLException; 
import java.net.URL; 
  
public class HelloApplet extends Applet implements ActionListener { 
    private TextField nameField; 
    private Button submitButton; 
    private Label resultLabel; 
  
    public void init() { 
        nameField = new TextField("Enter your name"); 
        submitButton = new Button("Submit"); 
        resultLabel = new Label(""); 
  
        submitButton.addActionListener(this); 
  
        add(nameField); 
        add(submitButton); 
        add(resultLabel); 
    } 
  
    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() == submitButton) { 
            String name = nameField.getText(); 
            try { 
                URL url = new 
URL("http://localhost:8080/YourWebAppName/HelloServlet?name=" + name); 
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
                InputStream responseStream = connection.getInputStream(); 
                byte[] buffer = new byte[1024]; 
                int bytesRead; 
                StringBuilder response = new StringBuilder(); 
  
                while ((bytesRead = responseStream.read(buffer)) != -1) { 
                    response.append(new String(buffer, 0, bytesRead)); 
                } 
  
                resultLabel.setText(response.toString()); 
                responseStream.close(); 
            } catch (MalformedURLException e) { 
                e.printStackTrace(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
}
