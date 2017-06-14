package org.azri.estore.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.*;

/**
 * This is the bean class for the PostageProcessBean enterprise bean.
 * Created Dec 31, 2005 3:54:23 AM
 * @author Mohamad Azri
 */
public class PostageProcessBean implements SessionBean, PostageProcessRemoteBusiness {
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

    private org.azri.estore.ejb.PostageLocalHome lookupPostageBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.PostageLocalHome rv = (org.azri.estore.ejb.PostageLocalHome) c.lookup("java:comp/env/ejb/PostageBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public void addPostageRate(String location, Double rate) {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            postageHome.create(id, location, rate);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updatePostageRate(String postageId, String location, String rate) {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        try {
            org.azri.estore.ejb.PostageLocal postageLocal = postageHome.findById(postageId);
            postageLocal.setLocation(location);
            postageLocal.setRate(Double.valueOf(rate));
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removePostage(String postageId) {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        try {
            org.azri.estore.ejb.PostageLocal postageLocal = postageHome.findById(postageId);
            postageHome.remove(postageId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (EJBException ex) {
            ex.printStackTrace();
        } catch (RemoveException ex) {
            ex.printStackTrace();
        }            
    }
    
    public ArrayList getAllPostageRate() {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        Collection postage = null;
        ArrayList allPostage = new ArrayList();
        try {
            postage = postageHome.findAllPostage();
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = postage.iterator();
        while(i.hasNext()) {
            String[] postageData = new String[3];
            org.azri.estore.ejb.PostageLocal postageLocal = (org.azri.estore.ejb.PostageLocal) (i.next());
            postageData[0] = postageLocal.getId();
            postageData[1] = postageLocal.getLocation();
            postageData[2] = String.valueOf(postageLocal.getRate());
            allPostage.add(postageData);
        }
        return allPostage;
    }
    
    public String getPostageRateById(String postageId) {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        String postageRate = null;
        try {
            org.azri.estore.ejb.PostageLocal postageLocal = postageHome.findById(postageId);
            postageRate = String.valueOf(postageLocal.getRate());
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return postageRate;
    }
    
    public String[] getPostageById(String postageId) {
        org.azri.estore.ejb.PostageLocalHome postageHome = lookupPostageBean();
        String[] postageRate = new String[2];
        try {
            org.azri.estore.ejb.PostageLocal postageLocal = postageHome.findById(postageId);
            postageRate[0] = postageLocal.getLocation();
            postageRate[1] = String.valueOf(postageLocal.getRate());
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return postageRate;
    }    
}
