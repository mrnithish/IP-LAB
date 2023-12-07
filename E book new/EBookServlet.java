package com.yourpackage; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import java.io.IOException; 
import java.io.PrintWriter; 
  
@WebServlet("/EBookstoreServlet") 
public class EBookstoreServlet extends HttpServlet { 
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
  
        // Retrieve or create the user's shopping cart 
        Cart cart = (Cart) session.getAttribute("cart"); 
        if (cart == null) { 
            cart = new Cart(); 
            session.setAttribute("cart", cart); 
        } 
  
        // Handle different actions based on the request parameter 
        String action = request.getParameter("action"); 
        if (action != null) { 
            switch (action) { 
                case "addBook": 
                    // Add book to the cart 
                    String bookTitle = request.getParameter("bookTitle"); 
                    double bookPrice = Double.parseDouble(request.getParameter("bookPrice")); 
                    Book book = new Book(bookTitle, bookPrice); 
                    cart.addBook(book); 
                    break; 
                // Add more actions as needed 
            } 
        } 
  
        // Display the HTML page with book list and shopping cart 
        out.println("<html><head><title>E-Bookstore</title></head><body>"); 
        out.println("<h1>Welcome to E-Bookstore</h1>"); 
  
        // Display book list 
        out.println("<h2>Book List</h2>"); 
        out.println("<form action='EBookstoreServlet' method='post'>"); 
        out.println("Title: <input type='text' name='bookTitle'><br>"); 
        out.println("Price: <input type='text' name='bookPrice'><br>"); 
        out.println("<input type='hidden' name='action' value='addBook'>"); 
        out.println("<input type='submit' value='Add to Cart'>"); 
        out.println("</form>"); 
  
        // Display shopping cart 
        out.println("<h2>Shopping Cart</h2>"); 
        out.println("<ul>"); 
        for (Book cartBook : cart.getBooks()) { 
            out.println("<li>" + cartBook.getTitle() + " - $" + cartBook.getPrice() + "</li>"); 
        } 
        out.println("</ul>"); 
        out.println("<p>Total: $" + cart.getTotal() + "</p>"); 
  
        // Display hit count 
        int hitCount = 0; 
        if (session.getAttribute("hitCount") != null) { 
            hitCount = (Integer) session.getAttribute("hitCount"); 
        } 
        hitCount++; 
        session.setAttribute("hitCount", hitCount); 
        out.println("<p>Page Visits: " + hitCount + "</p>"); 
  
        out.println("</body></html>"); 
    } 
} 
