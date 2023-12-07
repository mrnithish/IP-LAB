package com.yourpackage; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import java.io.IOException; 
import java.io.PrintWriter; 
  
@WebServlet("/ReservationServlet") 
public class ReservationServlet extends HttpServlet { 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
  
    private void processRequest(HttpServletRequest request, HttpServletResponse 
response) 
            throws ServletException, IOException { 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
  
        HttpSession session = request.getSession(true); 
  
        // Retrieve or create the user's booking 
        Booking booking = (Booking) session.getAttribute("booking"); 
        if (booking == null) { 
            // Sample ticket for demonstration purposes 
            Ticket ticket = new Ticket("Movie ABC", "A1", 10.99); 
            booking = new Booking(ticket); 
            session.setAttribute("booking", booking); 
        } 
  
        // Handle different actions based on the request parameter 
        String action = request.getParameter("action"); 
        if (action != null) { 
            switch (action) { 
                case "changeSeat": 
                    // Sample action to change the seat 
                    String newSeat = request.getParameter("newSeat"); 
                    booking.getTicket().seat = newSeat; 
                    break; 
                // Add more actions as needed 
            } 
        } 
  
        // Display the HTML page with ticket details 
        out.println("<html><head><title>Online Ticket Reservation</title></head><body>"); 
        out.println("<h1>Welcome to Online Ticket Reservation</h1>"); 
  
        // Display ticket details 
        out.println("<h2>Ticket Details</h2>"); 
        out.println("<p>Movie: " + booking.getTicket().getMovie() + "</p>"); 
        out.println("<p>Seat: " + booking.getTicket().getSeat() + "</p>"); 
        out.println("<p>Price: $" + booking.getTicket().getPrice() + "</p>"); 
  
        // Display hit count 
        int hitCount = 0; 
        if (session.getAttribute("hitCount") != null) { 
            hitCount = (Integer) session.getAttribute("hitCount"); 
        } 
        hitCount++; 
        session.setAttribute("hitCount", hitCount); 
        out.println("<p>Page Visits: " + hitCount + "</p>"); 
  
        // Display form to change seat 
        out.println("<h2>Change Seat</h2>"); 
        out.println("<form action='ReservationServlet' method='post'>"); 
        out.println("New Seat: <input type='text' name='newSeat'><br>"); 
        out.println("<input type='hidden' name='action' value='changeSeat'>"); 
        out.println("<input type='submit' value='Change Seat'>"); 
        out.println("</form>"); 
  
        out.println("</body></html>"); 
    } 
}