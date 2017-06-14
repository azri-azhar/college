/*
 * LogOut.java
 *
 * Created on January 11, 2006, 2:44 AM
 */

package org.azri.estore.servlet;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mohamad Azri
 * @version
 */
public class LogOut extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        if ("Company".equals(path)) {
            HttpSession session = request.getSession();
            session.removeAttribute("isCompanyLoggedIn");
            session.removeAttribute("username"); 
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/");            
            requestDispatcher.forward(request, response);            
        } else if ("Customer".equals(path)) {
            HttpSession session = request.getSession();
            session.removeAttribute("customerId");
            session.removeAttribute("isCustomerLoggedIn");
            session.removeAttribute("customerName"); 
            ServletContext context = getServletContext();            
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/");                      
            requestDispatcher.forward(request, response);            
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
