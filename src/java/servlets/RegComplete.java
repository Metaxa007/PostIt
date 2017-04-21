package servlets;

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
import javax.servlet.http.HttpSession;

/**
 * Die Klasse mit Information, wenn die Registration erfolgreich war
 * @author Metaxa
 * 
 */
public class RegComplete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Wenn die Registration erfolgreich war,bietet an, auf die homepage zurückzukehren
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>\n" +
        "<title>Login</title>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "<link href=\"css/normalize.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
        "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
        "</head>\n" +
        "<body>\n" +
        "<div class=\"wrapper-mother\">\n" +
        "<header>\n" +
        "<a href=\"\" class=\"logo-a\">#PostIt</a>\n" +
        "</header>");
        out.println("<div class='wrapper-main'>");
            
            out.println("<h3>Regestration complete</h3>");
            out.println("<a href='index.html'>Startseite</a>"); 
            
          out.println("</div>");
          out.println("</div>"); 
          out.println("</body>");
          out.println("</html>"); 
           
    }
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
