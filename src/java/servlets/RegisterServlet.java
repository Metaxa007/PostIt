package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Die Klasse prueft Daten bei der Registration
 * @author matthiasseeber
 * 
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Wenn alle Daten bei der Registration in Ordnung sind, macht "redirect" auf _RegComplete_
     * Wenn nicht, zeigt passenden Fehler
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
                
           String name=request.getParameter("nachname");
           String vorname=request.getParameter("vorname");
           String email=request.getParameter("email");
           String password1 = request.getParameter("password1");
           String password2 = request.getParameter("password2");          
           boolean exestiert=false;
           boolean admin=false;
           boolean scientist=false;
           
           
           
          
           
           for(int i=0;i<UserArrayList.userListe.size();i++)
           {
               if(email.equals(UserArrayList.userListe.get(i).getEmail()))                   
                   exestiert=true;
                   
            }
           
           if(exestiert==true)
           {              
                           
                   out.println("Users mit dieser Email schon exestiert");
                  
                   out.print("<p>Zur <a href=\"register.jsp\">Anmeldung</a></p>");}
                   
                   else{          
           if(name.equals("") || vorname.equals("") || email.equals("") || password1.length()<6 || !password1.equals(password2))
           {out.print("Geben Sie korrekte Daten ein oder Passwoerte sind nicht gleich");
           
           out.print("<p>Zur <a href=\"register.jsp\">Anmeldung</a></p>");
           }
           
           else
           {    
          
            if(request.getParameter("rights")==null){           
            
            User userTest=new User(name, vorname, email, password1, admin, scientist);
            UserArrayList.userListe.add(userTest);     
      
            request.getRequestDispatcher("RegComplete").forward(request,response);}
           
            else{
            if(request.getParameter("rights").equals("Scientist")){
            scientist=true;
            User userTest=new User(name, vorname, email, password1, admin, scientist);
            UserArrayList.userListe.add(userTest);     
      
            request.getRequestDispatcher("RegComplete").forward(request,response);
            }  
            else
               {
                   admin=true;
                if(request.getParameter("rights").equals("Admin")){
            User userTest=new User(name, vorname, email, password1, admin, scientist);
            UserArrayList.userListe.add(userTest);     
      
            request.getRequestDispatcher("RegComplete").forward(request,response);}
            }
           }   
               
           }
           }
            
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
