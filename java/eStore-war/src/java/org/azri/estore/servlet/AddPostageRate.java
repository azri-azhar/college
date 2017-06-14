/*
 * AddPostageRate.java
 *
 * Created on December 31, 2005, 4:02 AM
 */

package org.azri.estore.servlet;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author azri
 * @version
 */
public class AddPostageRate extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");        
        if (username == null) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Postage"));
            request.setAttribute("forwardedHeader", new String("Postage"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can add a new postage rate"));            
            requestDispatcher.forward(request, response);
        } else {        
        String location = request.getParameter("location");
        Double rate = Double.valueOf( request.getParameter("rate") );
        org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
        postageProcess.addPostageRate(location, rate);
        ServletContext servletContext = getServletContext();        
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");        
        request.setAttribute("forwardedTitle", new String("eStore - Postage Rate"));
        request.setAttribute("forwardedHeader", new String("Postage Rate"));
        request.setAttribute("forwardedMessage", new String("The new postage rate has been added."));
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

    private org.azri.estore.ejb.PostageProcessRemote lookupPostageProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/PostageProcessBean");
            org.azri.estore.ejb.PostageProcessRemoteHome rv = (org.azri.estore.ejb.PostageProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.PostageProcessRemoteHome.class);
            return rv.create();
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
        catch(javax.ejb.CreateException ce) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ce);
            throw new RuntimeException(ce);
        }
        catch(java.rmi.RemoteException re) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,re);
            throw new RuntimeException(re);
        }
    }
}
