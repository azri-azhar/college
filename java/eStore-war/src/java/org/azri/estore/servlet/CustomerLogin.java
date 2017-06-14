/*
 * CustomerLogin.java
 *
 * Created on December 31, 2005, 6:01 AM
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
public class CustomerLogin extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        org.azri.estore.ejb.CustomerProcessRemote customerProcess = lookupCustomerProcessBean();        
        if ( customerProcess.isLoginValid(username, password) == true ) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/main.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("isCustomerLoggedIn", new String("true"));
            session.setAttribute("customerId", customerProcess.getCustomerId());
            session.setAttribute("customerName", customerProcess.getCustomerName());
            requestDispatcher.forward(request, response);            
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");            
            request.setAttribute("forwardedTitle", new String("eStore - Customer Login"));
            request.setAttribute("forwardedHeader", new String("Customer Login"));
            request.setAttribute("forwardedMessage", new String("Invalid username or password. Please try again."));
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

    private org.azri.estore.ejb.CustomerProcessRemote lookupCustomerProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/CustomerProcessBean");
            org.azri.estore.ejb.CustomerProcessRemoteHome rv = (org.azri.estore.ejb.CustomerProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.CustomerProcessRemoteHome.class);
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
