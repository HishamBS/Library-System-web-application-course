/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.http.HttpSession;


/**
 *
 * @author MSI GT72 DRAGON
 */
public class browse_books extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost/project";
        Connection conn=null;
        HttpSession session = request.getSession();
        String usr = (String)session.getAttribute("user");
        
        request.getRequestDispatcher("header.html").include(request, response);
        request.getRequestDispatcher("body.html").include(request, response);
        if(usr != null){
        out.println("<h1 class=\"gen\">These are the available books</h1>");
        
        String q = "select * from books order by title asc;";
         try{
        Class.forName("com.mysql.jdbc.Driver"); 
        conn = DriverManager.getConnection(connectionURL, "admin", "123456"); 
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(q);
        out.println("<table style=\"font-weight:bold;font-size:x-large;background:lightgray;color:darkblue;text-align:center;\"border=1 align=\"center\"");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        out.println("<tr class=\"browsebooks\">");
        
             for (int i = 1; i <= columnCount; i++) {
                 out.println("<th >"+rsmd.getColumnName(i)+"</th>");
             }
             
             out.println("</tr>");
             
             while(rs.next())
             {
                 out.println("<tr>");
                 for (int i = 1; i <= columnCount; i++) {
                  out.println("<td>"+rs.getString(i));
                 }
                 out.println("</tr");
             }
             out.println("</table>");
             rs.close();
             stmt.close();
             conn.close();
             request.getRequestDispatcher("footer.html").include(request, response);
             
             
             
                    }
                    catch(ClassNotFoundException e){
  out.println("Couldn't load database driver: " 
  + e.getMessage());
  }
  catch(SQLException e){
  out.println("SQLException caught: " 
  + e.getMessage());
  }
  catch (Exception e){
  out.println(e);
  }
    }
    
    else
    {
        out.println("<h1 class=\"gen\">you can't view the available books unless you are logged in , please login and try again </h1>");
                    request.getRequestDispatcher("footer.html").include(request, response);
                    out.println("<script>\n" +
"    setTimeout(function(){location.href=\"http://localhost:8084/WebApplication_project1/index.html/login.html\"} , 3000);\n" +
"</script>");
        
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
