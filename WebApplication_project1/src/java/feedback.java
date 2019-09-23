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

/**
 *
 * @author MSI GT72 DRAGON
 */
public class feedback extends HttpServlet {

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
        
        request.getRequestDispatcher("header.html").include(request, response);
        request.getRequestDispatcher("body.html").include(request, response);
        out.println("<h1 class=\"gen\">Thank you for your feedback</h1>");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String subject = request.getParameter("subject");
                String type = request.getParameter("type");
                String message = request.getParameter("message");
                String creationDateTime = dtf.format(now);
                String sql = "insert into feedback(id,name,phone,email,subject,type,message,creation_date_time) values(?,?,?,?,?,?,?,?)";
                
                try{
        Class.forName("com.mysql.jdbc.Driver"); 
        conn = DriverManager.getConnection(connectionURL, "admin", "123456"); 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, subject);
            ps.setString(6, type);
            ps.setString(7, message);
            ps.setString(8, creationDateTime);
            ps.executeUpdate();
            ps.close();
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
