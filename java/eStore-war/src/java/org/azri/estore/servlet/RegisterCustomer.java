/*
 * RegisterCustomer.java
 *
 * Created on December 31, 2005, 5:04 AM
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
public class RegisterCustomer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String ic = request.getParameter("ic");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String shippingAddress = request.getParameter("shippingaddress");
        String shippingCity = request.getParameter("shippingcity");
        String shippingState = request.getParameter("shippingstate");
        String shippingZip = request.getParameter("shippingzip");
        String shippingCountry = request.getParameter("shippingcountry");
        String shippingName = request.getParameter("shippingname");
        org.azri.estore.ejb.CustomerProcessRemote customerProcess = lookupCustomerProcessBean();
        if ( (customerProcess.isUsernameExists(userName)) == true )
        {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Customer Registration"));
            request.setAttribute("forwardedHeader", new String("Customer Registration"));
            request.setAttribute("forwardedMessage", new String("The selected username is already in use. Please select a new username and try again"));            
            requestDispatcher.forward(request, response);
        } else {
            customerProcess.registerCustomer(userName, password, firstName, lastName, ic, email, phone, address, city, state, zip, country, shippingName, shippingAddress, shippingCity, shippingState, shippingZip, shippingCountry);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Customer Registration"));
            request.setAttribute("forwardedHeader", new String("Customer Registration"));
            request.setAttribute("forwardedMessage", new String("Registration successful. <a href=\"/eStore-Web/customer/customerlogin.jsp\">Click here to log-in</a> "));            
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
