import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
*
* @authorpraka
*/
public class WelcomeServlet1 extends HttpServlet {
/**
* Processes requests for both HTTP <code>GET</code> and <code>POST</code>
* methods.
*
* @paramrequestservlet request
* @paramresponseservlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String name =request.getParameter("name");
String age=request.getParameter("age");
String dept=request.getParameter("dept");
String gender=request.getParameter("gender");
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false","root","root");
//here sonoo is database name, root is username and password
PreparedStatement st = con.prepareStatement("insert into student values(?,?,?,?)");
st.setString(1,name);
st.setString(2,age);
st.setString(3,dept);
st.setString(4,gender);
st.executeUpdate();
// Close all the connections
//st.close();
//con.close();
// Get awriter pointer
// to display the successful result
//PrintWriter out = response.getWriter();
out.println("<html><body><b>SUCCESSFULLY INSERTED"
+ "</b></body></html>");
out.println("<br></br>");
out.println("DATA ARE AS FOLLOWS");
out.println("<br></br>");
//Statement stmt=con.createStatement();
//stmt.executeUpdate("insert into emp values('name')");
ResultSet rs=st.executeQuery("select * from student");
out.println("<table border=1>");
out.println("<tr><th>STUDENT NAME</th><th>AGE</th><th>DEPT</th><th>GENDER</th><tr>");
while(rs.next())
out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td
><td>"+rs.getString(4)+"</td></tr>");
st.close();
con.close();
}
catch(Exception e)
{ System.out.println(e);}
}
}