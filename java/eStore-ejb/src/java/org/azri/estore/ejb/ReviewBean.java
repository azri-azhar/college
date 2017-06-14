package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the ReviewBean enterprise bean.
 * Created Dec 28, 2005 5:41:27 AM
 * @author Mohamad Azri
 */
public abstract class ReviewBean implements EntityBean, ReviewLocalBusiness {
    private EntityContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click on the + sign on the left to edit the code.">
    // TODO Consider creating Transfer Object to encapsulate data
    // TODO Review finder methods
    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context = null;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }
    // </editor-fold>
    
    
    public abstract String getId();
    public abstract void setId(String id);
    
    public abstract String getReview();
    public abstract void setReview(String review);
    
    public abstract Integer getRating();
    public abstract void setRating(Integer rating);
    
    public abstract String getProductId();
    public abstract void setProductId(String productId);
    
    public abstract String getCustomerId();
    public abstract void setCustomerId(String customerId);
    
    
    public String ejbCreate(String id, String review, Integer rating, String productId, String customerId)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (review == null) {
            throw new CreateException("The field \"review\" must not be null");
        }
        if (rating == null) {
            throw new CreateException("The field \"rating\" must not be null");
        }
        if (productId == null) {
            throw new CreateException("The field \"productId\" must not be null");
        }
        if (customerId == null) {
            throw new CreateException("The field \"customerId\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setId(id);
        setReview(review);
        setRating(rating);
        setProductId(productId);
        setCustomerId(customerId);
        
        return null;
    }
    
    public void ejbPostCreate(String id, String review, Integer rating, String productId, String customerId) {
        // TODO populate relationships here if appropriate
        
    }
}
