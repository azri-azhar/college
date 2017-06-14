package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the BuyProcessBean enterprise bean.
 * Created Jan 2, 2006 7:30:41 AM
 * @author azri
 */
public class BuyProcessBean implements SessionBean, BuyProcessRemoteBusiness {
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
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
    }
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")

    private org.azri.estore.ejb.BuyLocalHome lookupBuyBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.BuyLocalHome rv = (org.azri.estore.ejb.BuyLocalHome) c.lookup("java:comp/env/ejb/BuyBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public void addOrder() {
        org.azri.estore.ejb.BuyLocalHome buyHome = lookupBuyBean();
        try {
            buyHome.create("asdaddasdf", new Integer(1), new Double(2.5), "adfasdf", "adfadf", "adfdasf", "adfasdf", "adfaf", "dsfsdf");
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
