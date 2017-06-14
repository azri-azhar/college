/*
 * UpdateCategory.java
 *
 * Created on January 7, 2006, 5:20 AM
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
public class UpdateCategory extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");        
        if (username == null) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Category"));
            request.setAttribute("forwardedHeader", new String("Category"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can update the category"));            
            requestDispatcher.forward(request, response);
        } else if ("Edit".equals(path)) { 
           org.azri.estore.ejb.CategoryProcessRemote categoryProcess = lookupCategoryProcessBean();
           String categoryId = request.getParameter("categoryid");
           String name = request.getParameter("name");
           categoryProcess.updateCategory(categoryId, name);
           ServletContext context = getServletContext();
           RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
           request.setAttribute("forwardedTitle", new String("eStore - Product Category"));
           request.setAttribute("forwardedHeader", new String("Product Category"));
           request.setAttribute("forwardedMessage", new String("The product category has been updated."));              
           requestDispatcher.forward(request, response);            
        } else if ("Remove".equals(path)) {
           String categoryId = request.getParameter("categoryid");
           org.azri.estore.ejb.CategoryProcessRemote categoryProcess = lookupCategoryProcessBean();
           categoryProcess.removeCategory(categoryId);
           ServletContext context = getServletContext();
           RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
           request.setAttribute("forwardedTitle", new String("eStore - Product Category"));
           request.setAttribute("forwardedHeader", new String("Product Category"));
           request.setAttribute("forwardedMessage", new String("The product category has been deleted"));              
           requestDispatcher.forward(request, response); 
        } else if ("EditForm".equals(path)) {
           String categoryId = request.getParameter("categoryid");
           String name = request.getParameter("name");
           request.setAttribute("name", name);
           request.setAttribute("categoryid", categoryId);
           ServletContext context = getServletContext();
           RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/editcategory.jsp");             
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

    private org.azri.estore.ejb.CategoryProcessRemote lookupCategoryProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/CategoryProcessBean");
            org.azri.estore.ejb.CategoryProcessRemoteHome rv = (org.azri.estore.ejb.CategoryProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.CategoryProcessRemoteHome.class);
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
