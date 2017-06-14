/*
 * ViewPostage.java
 *
 * Created on January 6, 2006, 10:35 AM
 */

package org.azri.estore.servlet;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mohamad Azri
 * @version
 */
public class ViewPostage extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        if ("Company".equals(path)) {         
        org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
        ArrayList postage = postageProcess.getAllPostageRate();
        request.setAttribute("postage", postage);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/viewpostage.jsp");
        requestDispatcher.forward(request, response);        
        }
        else if ("Customer".equals(path)) {
        org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
        String postageId = request.getParameter("postageid");
        String[] postage = postageProcess.getPostageById(postageId);
        request.setAttribute("postage", postage);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/viewpostage.jsp");
        requestDispatcher.forward(request, response);            
        }
        else if ("CompanyById".equals(path)) {
        org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
        String postageId = request.getParameter("postageid");
        String[] postage = postageProcess.getPostageById(postageId);
        request.setAttribute("postage", postage);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/viewcustomerpostage.jsp");
        requestDispatcher.forward(request, response);        
        } else if ("CustomerAll".equals(path)) {
        org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
        ArrayList postage = postageProcess.getAllPostageRate();
        request.setAttribute("postage", postage);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/viewpostageall.jsp");
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
