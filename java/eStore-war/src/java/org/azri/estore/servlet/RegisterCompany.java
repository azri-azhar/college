/*
 * RegisterCompany.java
 *
 * Created on December 28, 2005, 5:53 AM
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
public class RegisterCompany extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String companyName = request.getParameter("companyname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String contactName = request.getParameter("contactname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String title = request.getParameter("title");
        org.azri.estore.ejb.CompanyProcessRemote companyProcess = lookupCompanyProcessBean();
        if ( (companyProcess.isUsernameExists(username)) == true ) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Company Registration"));
            request.setAttribute("forwardedHeader", new String("Company Registration"));
            request.setAttribute("forwardedMessage", new String("The selected username is already in use. Please select a new username and try again"));
            requestDispatcher.forward(request, response);
        } else {
            companyProcess.registerCompany(username, password, companyName, address, city, state, zip, country, contactName, email, phone, title);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Maintainer Registration"));
            request.setAttribute("forwardedHeader", new String("Maintainer Registration"));
            request.setAttribute("forwardedMessage", new String("Registration successful. <a href=\"/eStore-Web/company/companylogin.jsp\">Please click here to log-in</a>"));
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
    
    private org.azri.estore.ejb.CompanyProcessRemote lookupCompanyProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/CompanyProcessBean");
            org.azri.estore.ejb.CompanyProcessRemoteHome rv = (org.azri.estore.ejb.CompanyProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.CompanyProcessRemoteHome.class);
            return rv.create();
        } catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        } catch(javax.ejb.CreateException ce) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ce);
            throw new RuntimeException(ce);
        } catch(java.rmi.RemoteException re) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,re);
            throw new RuntimeException(re);
        }
    }
}
