/*
 * ManageOrder.java
 *
 * Created on January 8, 2006, 12:14 PM
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
public class ManageOrder extends HttpServlet {
    
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
            request.setAttribute("forwardedTitle", new String("eStore - Manage Order"));
            request.setAttribute("forwardedHeader", new String("Manage Orders"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can manage orders"));            
            requestDispatcher.forward(request, response);             
        } else if ("ViewOutstandingOrders".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            ArrayList order = orderProcess.getCustomerListByStatus("Processing");
            request.setAttribute("order", order);
            request.setAttribute("title", "New Orders");
            request.setAttribute("description", "New orders. Please process the order and update the status");
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/vieworder.jsp");
            requestDispatcher.forward(request, response); 
        } else if ("ViewDeliveredItem".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            ArrayList order = orderProcess.getCustomerListByStatus("Received");
            request.setAttribute("order", order);
            request.setAttribute("title", "Delivered Items");
            request.setAttribute("description", "Orders that have been processed delivered to customers.");
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/vieworder.jsp");
            requestDispatcher.forward(request, response); 
        }  else if ("ViewAwaitingPayment".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            ArrayList order = orderProcess.getCustomerListByStatus("Awaiting for payment");
            request.setAttribute("order", order);
            request.setAttribute("title", "Awaiting Payment From Customers");
            request.setAttribute("description", "Orders made by customer using manual payment (check, bank-transfer, etc). Process the order after the payment is received.");
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/vieworder.jsp");
            requestDispatcher.forward(request, response); 
        }  else if ("ViewOtherStatus".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
            ArrayList order = orderProcess.getCustomerListByOtherStatus();
            request.setAttribute("order", order);
            request.setAttribute("title", "Orders With Various Status");
            request.setAttribute("description", "Orders that have been processed and marked with various status.");
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/vieworder.jsp");
            requestDispatcher.forward(request, response);            
        } else if ("StatusForm".equals(path)) {
            String orderId = request.getParameter("orderid");
            request.setAttribute("orderid", orderId);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/changestatus.jsp");
            requestDispatcher.forward(request, response); 
        } else if ("ChangeStatus".equals(path)) {
            org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();            
            String orderId = request.getParameter("orderid");
            String status = request.getParameter("status");
            orderProcess.setOrderStatus(orderId, status);
            
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Order Status"));
            request.setAttribute("forwardedHeader", new String("Order Status"));
            request.setAttribute("forwardedMessage", new String("The order status has been change."));            
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
}
