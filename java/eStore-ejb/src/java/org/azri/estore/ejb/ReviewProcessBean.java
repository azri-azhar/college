package org.azri.estore.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.*;

/**
 * This is the bean class for the ReviewProcessBean enterprise bean.
 * Created Jan 2, 2006 12:30:05 AM
 * @author Mohamad Azri
 */
public class ReviewProcessBean implements SessionBean, ReviewProcessRemoteBusiness {
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

    private org.azri.estore.ejb.ReviewLocalHome lookupReviewBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.ReviewLocalHome rv = (org.azri.estore.ejb.ReviewLocalHome) c.lookup("java:comp/env/ejb/ReviewBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private org.azri.estore.ejb.OderLocalHome lookupOderBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.OderLocalHome rv = (org.azri.estore.ejb.OderLocalHome) c.lookup("java:comp/env/ejb/OderBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
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
    
    public void addReview(String review, Integer rating, String productId, String customerId) {
        org.azri.estore.ejb.ReviewLocalHome reviewHome = lookupReviewBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            reviewHome.create(id, review, rating, productId, customerId);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isProductReceived(String productId, String customerId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        try {
            org.azri.estore.ejb.OderLocal delivered = orderHome.findByProductReceived(productId, customerId);
            String orderedId = delivered.getId();
            if (orderedId != null ) {
                return true;
            } else {
                return false;
            }
        } catch (FinderException ex) {
            ex.printStackTrace();
        }       
        return false;
    }
    
    public ArrayList getProductReview(String productId) {
        org.azri.estore.ejb.ReviewLocalHome reviewHome = lookupReviewBean();
        org.azri.estore.ejb.CustomerProcessRemote customerRemote = lookupCustomerProcessBean();
        Collection review = null;
        ArrayList allReview = new ArrayList();
        try {
            review = reviewHome.findByProductId(productId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = review.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.ReviewLocal reviewLocal = (org.azri.estore.ejb.ReviewLocal) (i.next());
            String[] reviewData = new String[3];
            try {
                reviewData[0] = customerRemote.getCustomerNameById(reviewLocal.getCustomerId());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            reviewData[1] = String.valueOf(reviewLocal.getRating());
            reviewData[2] = reviewLocal.getReview();
            allReview.add(reviewData);
        }
        return allReview;
    }
}

