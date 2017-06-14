package org.azri.estore.ejb;

import java.util.ArrayList;
import javax.ejb.*;

/**
 * This is the bean class for the CompanyProcessBean enterprise bean.
 * Created Dec 28, 2005 5:45:11 AM
 * @author Mohamad Azri
 */
public class CompanyProcessBean implements SessionBean, CompanyProcessRemoteBusiness {
    private SessionContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">
    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations
    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    // </editor-fold>
    
    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {

    }

    private org.azri.estore.ejb.CompanyLocalHome lookupCompanyBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.CompanyLocalHome rv = (org.azri.estore.ejb.CompanyLocalHome) c.lookup("java:comp/env/ejb/CompanyBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    } 

    public void registerCompany(String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) {
        org.azri.estore.ejb.CompanyLocalHome companyHome = lookupCompanyBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            companyHome.create(id, username, password, companyName, address, city, state, zip, country, contactName, email, phone, title);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isUsernameExists(String username) {
        org.azri.estore.ejb.CompanyLocalHome companyHome = lookupCompanyBean();
        try {      
            org.azri.estore.ejb.CompanyLocal newUsername = companyHome.findByUsername(username);
            String companyId = newUsername.getId();
            if (companyId != null)
                return true;
            else
                return false;          
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        return false;
    }

    public boolean isLoginValid(String username, String password) {
        org.azri.estore.ejb.CompanyLocalHome companyHome = lookupCompanyBean();
        try {      
            org.azri.estore.ejb.CompanyLocal companyLocal = companyHome.findByUsername(username);
            String companyId = companyLocal.getId();
            String companyUsername = companyLocal.getUsername();
            String companyPassword = companyLocal.getPassword();            
            if ( (companyId != null) && (companyUsername.equals(username)) && (companyPassword.equals(password)) )
                return true;
            else
                return false;          
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        return false;        
    }
    
    public String[] getCompanyDetails(String username) {
        org.azri.estore.ejb.CompanyLocalHome companyHome = lookupCompanyBean();
        String[] companyData = new String[13];
        try {
            org.azri.estore.ejb.CompanyLocal companyLocal = companyHome.findByUsername(username);
            companyData[0] = companyLocal.getId();
            companyData[1] = companyLocal.getUsername();
            companyData[2] = companyLocal.getPassword();
            companyData[3] = companyLocal.getCompanyName();
            companyData[4] =  companyLocal.getAddress();
            companyData[5] = companyLocal.getCity();
            companyData[6] = companyLocal.getState();
            companyData[7] = companyLocal.getZip();
            companyData[8] = companyLocal.getCountry();
            companyData[9] = companyLocal.getContactName();
            companyData[10] = companyLocal.getEmail();
            companyData[11] = companyLocal.getPhone();
            companyData[12] = companyLocal.getTitle();
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return companyData;
    }
    
    public void updateCompanyDetails(String companyId, String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) {
        org.azri.estore.ejb.CompanyLocalHome companyHome = lookupCompanyBean();
        try {
            org.azri.estore.ejb.CompanyLocal companyLocal = companyHome.findById(companyId);
            companyLocal.setAddress(address);
            companyLocal.setCity(city);
            companyLocal.setCompanyName(companyName);
            companyLocal.setContactName(contactName);
            companyLocal.setCountry(country);
            companyLocal.setEmail(email);
            companyLocal.setPassword(password);
            companyLocal.setPhone(phone);
            companyLocal.setState(state);
            companyLocal.setTitle(title);
            companyLocal.setUsername(username);
            companyLocal.setZip(zip);       
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
    }
}
