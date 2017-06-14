/*
 * AddReview.java
 *
 * Created on January 2, 2006, 2:30 AM
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
public class AddReview extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        HttpSession session = request.getSession();
        String productId = request.getParameter("productid");
        String customerId = (String) session.getAttribute("customerId");
        org.azri.estore.ejb.ReviewProcessRemote reviewProcess = lookupReviewProcessBean();
        if (customerId == null) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product Review"));
            request.setAttribute("forwardedHeader", new String("Product Review"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can add a review"));
            requestDispatcher.forward(request, response);            
        } else if ("Add".equals(path)) {
            String review = request.getParameter("review");
            Integer rating = Integer.valueOf(request.getParameter("rating"));
            reviewProcess.addReview(review, rating, productId, customerId);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product Review"));
            request.setAttribute("forwardedHeader", new String("Product Review"));
            request.setAttribute("forwardedMessage", new String("The product review has been added."));
            requestDispatcher.forward(request, response);
        } else if (reviewProcess.isProductReceived(productId, customerId) == true) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/review.jsp?productid=" + productId + "&customerid=" + customerId);
            requestDispatcher.forward(request, response);            
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Product Review"));
            request.setAttribute("forwardedHeader", new String("Product Review"));
            request.setAttribute("forwardedMessage", new String("You are not allowed to review a product that you have not buy or received."));
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

    private org.azri.estore.ejb.ReviewProcessRemote lookupReviewProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/ReviewProcessBean");
            org.azri.estore.ejb.ReviewProcessRemoteHome rv = (org.azri.estore.ejb.ReviewProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.ReviewProcessRemoteHome.class);
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
