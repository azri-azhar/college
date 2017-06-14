/*
 * ShoppingCart.java
 *
 * Created on January 6, 2006, 12:55 AM
 */

package org.azri.estore.servlet;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mohamad Azri
 * @version
 */
public class ShoppingCart extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String path = request.getPathInfo();
        path = path.substring(1);
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        if (customerId == null) {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Shopping Cart"));
            request.setAttribute("forwardedHeader", new String("Shopping Cart"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can use the shopping cart"));
            requestDispatcher.forward(request, response);
        } else if ("Add".equals(path)) {
            String productId = request.getParameter("productid");
            org.azri.estore.ejb.ProductProcessRemote productProcess = lookupProductProcessBean();
            org.azri.estore.ejb.PostageProcessRemote postageProcess = lookupPostageProcessBean();
            ArrayList productDetails = productProcess.getProductDetails(productId);
            ArrayList postageDetails = postageProcess.getAllPostageRate();            
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/addcart.jsp");
            request.setAttribute("product", productDetails);
            request.setAttribute("postage", postageDetails);
            requestDispatcher.forward(request, response);    
        } else if("Save".equals(path)) {
            String newProductId = request.getParameter("productid");
            String newCustomerId = (String) session.getAttribute("customerId");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");    
            String postage = request.getParameter("postageid");
            String weight = request.getParameter("weight");
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            orderProcess.addCart(quantity, price, newProductId, newCustomerId, weight, postage);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Shopping Cart"));
            request.setAttribute("forwardedHeader", new String("Shopping Cart"));
            request.setAttribute("forwardedMessage", new String("The product has been added to your shopping cart"));
            requestDispatcher.forward(request, response);
        } else if("Remove".equals(path)) {
            String orderId = request.getParameter("orderid");
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            orderProcess.removeFromCart(orderId);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Shopping Cart"));
            request.setAttribute("forwardedHeader", new String("Shopping Cart"));
            request.setAttribute("forwardedMessage", new String("The product has been removed from your shopping cart"));
            requestDispatcher.forward(request, response);
        } else if("View".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();      
            ArrayList allCart = orderProcess.getAllCart(customerId);
            String totalCart = orderProcess.getTotalCart();
            request.setAttribute("cart", allCart);
            request.setAttribute("totalcart", totalCart);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/viewcart.jsp");
            requestDispatcher.forward(request, response); 
        } else if("CheckOutByOther".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();      
            orderProcess.checkOutByOther(customerId);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Order"));
            request.setAttribute("forwardedHeader", new String("Order"));
            request.setAttribute("forwardedMessage", new String("Thank you for shopping with us. Once we have received your payment, we will process your order immediately. You can check you order status on this website or via your mobile phone by entering the Order Id."));
            requestDispatcher.forward(request, response); 
        } else if("CheckOutByCreditCard".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();      
            orderProcess.checkOutByCreditCard(customerId);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Order"));
            request.setAttribute("forwardedHeader", new String("Order"));
            request.setAttribute("forwardedMessage", new String("Your order is being processed and will shortly progress towards dispatch. You can check you order status on this website or via your mobile phone by entering the Order Id."));
            requestDispatcher.forward(request, response); 
        } else if("ValidateCreditCard".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();      
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/validatecreditcard.jsp");
            requestDispatcher.forward(request, response);            
        } else if("CustomerViewOrder".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();      
            ArrayList allOrder = orderProcess.getCustomerOrderList(customerId);
            request.setAttribute("order", allOrder);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/vieworder.jsp");
            requestDispatcher.forward(request, response);         
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Shopping Cart"));
            request.setAttribute("forwardedHeader", new String("Shopping Cart"));
            request.setAttribute("forwardedMessage", new String("Invalid Request"));
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

    private org.azri.estore.ejb.OrderProcessRemote lookupOrderProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/OrderProcessBean");
            org.azri.estore.ejb.OrderProcessRemoteHome rv = (org.azri.estore.ejb.OrderProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.OrderProcessRemoteHome.class);
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
