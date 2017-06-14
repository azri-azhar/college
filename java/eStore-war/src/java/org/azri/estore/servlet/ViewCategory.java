/*
 * ViewCategory.java
 *
 * Created on January 7, 2006, 4:42 AM
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
public class ViewCategory extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        if ("Company".equals(path)) { 
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            ArrayList category = productProcess.getAllProductCategory();
            request.setAttribute("category", category);            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/viewcategory.jsp");
            requestDispatcher.forward(request, response);            
        } else if ("ViewProductByCategory".equals(path)) {
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            String categoryId = request.getParameter("categoryid");
            ArrayList product = productProcess.getAllProductByCategory(categoryId);
            request.setAttribute("product", product);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/viewproduct.jsp");
            requestDispatcher.forward(request, response);
        } else if ("ViewProductByCategoryCompany".equals(path)) {
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            String categoryId = request.getParameter("categoryid");
            ArrayList product = productProcess.getAllProductByCategory(categoryId);
            request.setAttribute("product", product);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/viewproduct.jsp");
            requestDispatcher.forward(request, response);            
        } else if ("Customer".equals(path)) {
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            ArrayList category = productProcess.getAllProductCategory();
            request.setAttribute("category", category);            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/viewcategory.jsp");
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

    private org.azri.estore.ejb.ProductProcessRemote lookupProductProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/ProductProcessBean");
            org.azri.estore.ejb.ProductProcessRemoteHome rv = (org.azri.estore.ejb.ProductProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.ProductProcessRemoteHome.class);
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
