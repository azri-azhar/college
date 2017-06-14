/*
 * UpdateProduct.java
 *
 * Created on January 7, 2006, 2:50 AM
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
public class UpdateProduct extends HttpServlet {
    
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
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can view or update the product"));            
            requestDispatcher.forward(request, response);
        } else if ("View".equals(path)) {        
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            ArrayList product = productProcess.getAllProduct();
            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher;
            ServletContext servletContext = getServletContext();
            requestDispatcher = servletContext.getRequestDispatcher("/company/viewproduct.jsp");
            requestDispatcher.forward(request, response);
        } else if ("EditForm".equals(path)) {
            String productId = request.getParameter("productid");
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            ArrayList productDetails = productProcess.getProductDetails(productId);
            ArrayList category = productProcess.getAllProductCategory();
            request.setAttribute("category", category);
            request.setAttribute("product", productDetails);            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/editproduct.jsp");
            requestDispatcher.forward(request, response);            
        } else if ("Remove".equals(path)) {
            String productId = request.getParameter("productid");
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            productProcess.removeProduct(productId);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("The product has been deleted"));            
            requestDispatcher.forward(request, response);
        } else if ("Edit".equals(path)) {
            String productId = request.getParameter("productid");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");
            String weight = request.getParameter("weight");
            String dimension = request.getParameter("dimension");
            String brand = request.getParameter("brand");
            String details = request.getParameter("details");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String categoryId = request.getParameter("categoryId");            
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            productProcess.updateProduct(productId, name, price, quantity, weight, dimension, brand, details, description, image, categoryId);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product"));
            request.setAttribute("forwardedHeader", new String("Product"));
            request.setAttribute("forwardedMessage", new String("The product details has been updated."));            
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
