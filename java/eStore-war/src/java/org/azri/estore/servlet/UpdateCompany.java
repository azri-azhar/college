/*
 * UpdateCompany.java
 *
 * Created on January 6, 2006, 7:59 AM
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
public class UpdateCompany extends HttpServlet {
    
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
            request.setAttribute("forwardedTitle", new String("eStore - Company Details"));
            request.setAttribute("forwardedHeader", new String("Company Details"));
            request.setAttribute("forwardedMessage", new String("You must log-in before you can edit your company details"));            
        } else if ("Form".equals(path)) {
            org.azri.estore.ejb.CompanyProcessRemote companyProcess = lookupCompanyProcessBean();        
            String[] companyDetails = companyProcess.getCompanyDetails(username);
            request.setAttribute("company", companyDetails);
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/company/editcompany.jsp");
            requestDispatcher.forward(request, response);   
        } else if("Save".equals(path)) {
            org.azri.estore.ejb.CompanyProcessRemote companyProcess = lookupCompanyProcessBean();
            String companyId = request.getParameter("companyid");
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
            companyProcess.updateCompanyDetails(companyId, username, password, companyName, address, city, state, zip, country, contactName, email, phone, title);
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Company Details"));
            request.setAttribute("forwardedHeader", new String("eStore - Company Details"));
            request.setAttribute("forwardedMessage", new String("The company details has been updated."));
            requestDispatcher.forward(request, response);             
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher("/company/processed.jsp");
            request.setAttribute("forwardedTitle", new String("eStore - Company Details"));
            request.setAttribute("forwardedHeader", new String("eStore - Company Details"));
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

    private org.azri.estore.ejb.CompanyProcessRemote lookupCompanyProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/CompanyProcessBean");
            org.azri.estore.ejb.CompanyProcessRemoteHome rv = (org.azri.estore.ejb.CompanyProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.CompanyProcessRemoteHome.class);
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
