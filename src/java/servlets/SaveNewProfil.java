/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Die Klasse Speichert Daten Des neuen Profils
 * @author Metaxa
 * 
 */
public class SaveNewProfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Daten fuer neues Profil werden gespeichert. Danach macht "redirect" auf userspage
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
            HttpSession ses=request.getSession();
                    
            String email=(String) ses.getAttribute("emailLogin");
            int numInArr=0;
            
            for(int i=0; i<UserArrayList.userListe.size();i++)
            {
                if(email.equals(UserArrayList.userListe.get(i).getEmail()))
                numInArr=i;
            }
            
            for(int i=0; i<UserArrayList.userListe.size();i++)
            {
                out.println(UserArrayList.userListe.get(i).getEmail());
            }
            
           
                       
            if(request.getParameter("sprache")!="")
            {
                UserArrayList.userListe.get(numInArr).setSprache(request.getParameter("sprache"));
            }  
            
            if(request.getParameter("name")!="")
            {
                UserArrayList.userListe.get(numInArr).setName(request.getParameter("name"));
            }  
           
            if(request.getParameter("vorname")!="")
            {
                UserArrayList.userListe.get(numInArr).setVorname(request.getParameter("vorname"));

            }
            
            if(request.getParameter("studium")!="")
            {
                UserArrayList.userListe.get(numInArr).setStudium(request.getParameter("studium"));

            }
            
            if(request.getParameter("geburtsdatum")!="")
            {
                UserArrayList.userListe.get(numInArr).setGebDatum(request.getParameter("geburtsdatum"));

            }
            
            if(request.getParameter("password").length()>5)
            {
                UserArrayList.userListe.get(numInArr).setPassword(request.getParameter("password"));              
                ses.invalidate();
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            else 
            {
                request.getRequestDispatcher("main.jsp").forward(request, response);
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
