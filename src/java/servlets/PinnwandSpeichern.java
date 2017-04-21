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
 * Klasse speichert Eintrage der Pinnwand
 * @author Metaxa
 */
public class PinnwandSpeichern extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *Speichert Eintrage, Name und Vorname des Absenders.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String eintrag=request.getParameter("eintrag");
            int numInArr=Integer.parseInt(request.getParameter("numInArr"));
            int otherInArr=Integer.parseInt(request.getParameter("otherInArr"));
            

            if(numInArr>=0){
            String name=UserArrayList.userListe.get(numInArr).getName();
            String vorname=UserArrayList.userListe.get(numInArr).getVorname();
            PinnwandDaten pinEintrag=new PinnwandDaten(name,vorname,eintrag);
            UserArrayList.userListe.get(numInArr).eintragListe.add(pinEintrag);
            request.getRequestDispatcher("main.jsp").forward(request, response);
            }
            else
            {    
            int myNumInArr=Integer.parseInt(request.getParameter("myNumInArr"));
            String emailOther=UserArrayList.userListe.get(otherInArr).getEmail();
            String name=UserArrayList.userListe.get(myNumInArr).getName();
            String vorname=UserArrayList.userListe.get(myNumInArr).getVorname();
            PinnwandDaten pinEintrag=new PinnwandDaten(name,vorname,eintrag);
            UserArrayList.userListe.get(otherInArr).eintragListe.add(pinEintrag);
            response.sendRedirect("pageother.jsp?id="+emailOther);
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
