package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Die Klasse prueft Logindaten
 * @author matthiasseeber
 * 
 */
public class LoginCheck extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *Prueft Logindaten. Wenn alles in Ordnung macht "redirect" auf userspage. Wenn nicht auf homepage
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
           
            boolean adminExists = false;
            for(int i=0;i<UserArrayList.userListe.size();i++){
                if(!UserArrayList.userListe.get(i).getEmail().equals("admin")){
                    adminExists = true;
                }
            }
            
            if(!adminExists){
                User admin=new User("Admin","Admin","admin@admin.com","123456", true,false);
                User scientist=new User("scientist","scientist","sc@sc.com","123456", false,true);
                UserArrayList.userListe.add(admin);
                UserArrayList.userListe.add(scientist);
            }
            
            for(int i=0;i<UserArrayList.userBlock.size();i++){
                if(UserArrayList.userBlock.get(i).equals(request.getParameter("login"))){
                    request.getRequestDispatcher("block.jsp").forward(request,response);
                }
            }
            
            
            HttpSession ses=request.getSession();
            boolean wrongPass=true;
            
            ses.setAttribute("emailLogin", request.getParameter("login"));
            ses.setAttribute("passwordSessia", request.getParameter("passwordLog"));
            
            String login=request.getParameter("login"); 
            String passwordLog=request.getParameter("passwordLog");
      
            for(int i=0;i<UserArrayList.userListe.size();i++){
                if(passwordLog.equals(UserArrayList.userListe.get(i).getPassword()) && 
                        login.equals(UserArrayList.userListe.get(i).getEmail())) {
                    wrongPass=false;
                   
                    request.getRequestDispatcher("main.jsp").forward(request,response);
                }//MAIN LINK      
            }
            
           
            if(wrongPass==true)
            { 
                request.getRequestDispatcher("index.html").forward(request,response);
            }
            
            
            
            
            
            
            //End
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
