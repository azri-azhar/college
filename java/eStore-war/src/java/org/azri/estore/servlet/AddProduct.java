/*
 * AddProduct.java
 *
 * Created on January 1, 2006, 5:07 AM
 */

package org.azri.estore.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mohamad Azri
 * @version
 */
public class AddProduct extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        ServletContext servletContext = getServletContext();
        String path = request.getPathInfo();
        path = path.substring(1);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can a new product"));            
            requestDispatcher.forward(request, response);
        } else if ("Add".equals(path)) {
            String name = request.getParameter("name");
            Double price = Double.valueOf(request.getParameter("price"));
            Integer quantity = Integer.valueOf(request.getParameter("quantity"));
            Double weight = Double.valueOf(request.getParameter("weight"));
            String dimension = request.getParameter("dimension");
            String brand = request.getParameter("brand");
            String details = request.getParameter("details");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String categoryId = request.getParameter("categoryId");
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            productProcess.addProduct(name, price, quantity, weight, dimension, brand, details, description, image, categoryId);
            requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("The new product has been added."));
            requestDispatcher.forward(request, response);
        } else if ("AddProductForm".equals(path)) {
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            ArrayList category = productProcess.getAllProductCategory();
            request.setAttribute("category", category);
            requestDispatcher = servletContext.getRequestDispatcher("/company/addproduct.jsp");
            requestDispatcher.forward(request, response);
        } else {
            requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("Invalid request."));
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
