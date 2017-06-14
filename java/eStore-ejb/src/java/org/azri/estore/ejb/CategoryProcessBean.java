package org.azri.estore.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.*;

/**
 * This is the bean class for the CategoryProcessBean enterprise bean.
 * Created Dec 29, 2005 5:01:08 AM
 * @author Mohamad Azri
 */
public class CategoryProcessBean implements SessionBean, CategoryProcessRemoteBusiness {
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
    
    private org.azri.estore.ejb.CategoryLocalHome lookupCategoryBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.CategoryLocalHome rv = (org.azri.estore.ejb.CategoryLocalHome) c.lookup("java:comp/env/ejb/CategoryBean");
            return rv;
        } catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void addCategory(String categoryName) {
        org.azri.estore.ejb.CategoryLocalHome categoryHome = lookupCategoryBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            categoryHome.create(id, categoryName);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateCategory(String categoryId, String name) {
        org.azri.estore.ejb.CategoryLocalHome categoryHome = lookupCategoryBean();
        try {
            org.azri.estore.ejb.CategoryLocal categoryLocal = categoryHome.findById(categoryId);
            categoryLocal.setName(name);            
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeCategory(String categoryId) {
        org.azri.estore.ejb.CategoryLocalHome categoryHome = lookupCategoryBean();
        org.azri.estore.ejb.CategoryLocal categoryLocal;
        try {
            categoryLocal = categoryHome.findById(categoryId);
            categoryLocal.remove();            
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (EJBException ex) {
            ex.printStackTrace();
        } catch (RemoveException ex) {
            ex.printStackTrace();
        }        
    }
}
