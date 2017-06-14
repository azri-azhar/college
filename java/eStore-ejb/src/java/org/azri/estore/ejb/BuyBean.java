package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the BuyBean enterprise bean.
 * Created Jan 2, 2006 7:09:09 AM
 * @author azri
 */
public abstract class BuyBean implements EntityBean, BuyLocalBusiness {
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
    
    public abstract Integer getQuantity();
    public abstract void setQuantity(Integer quantity);
    
    public abstract Double getPrice();
    public abstract void setPrice(Double price);
    
    public abstract String getDay();
    public abstract void setDay(String day);
    
    public abstract String getMonth();
    public abstract void setMonth(String month);
    
    public abstract String getYear();
    public abstract void setYear(String year);
    
    public abstract String getStatus();
    public abstract void setStatus(String status);
    
    public abstract String getProductId();
    public abstract void setProductId(String productId);
    
    public abstract String getCustomerId();
    public abstract void setCustomerId(String customerId);
    
    
    public String ejbCreate(String id, Integer quantity, Double price, String day, String month, String year, String status, String productId, String customerId)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (quantity == null) {
            throw new CreateException("The field \"quantity\" must not be null");
        }
        if (price == null) {
            throw new CreateException("The field \"price\" must not be null");
        }
        if (day == null) {
            throw new CreateException("The field \"day\" must not be null");
        }
        if (month == null) {
            throw new CreateException("The field \"month\" must not be null");
        }
        if (year == null) {
            throw new CreateException("The field \"year\" must not be null");
        }
        if (status == null) {
            throw new CreateException("The field \"status\" must not be null");
        }
        if (productId == null) {
            throw new CreateException("The field \"productId\" must not be null");
        }
        if (customerId == null) {
            throw new CreateException("The field \"customerId\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setDay(day);
        setMonth(month);
        setYear(year);
        setStatus(status);
        setProductId(productId);
        setCustomerId(customerId);
        
        return null;
    }
    
    public void ejbPostCreate(String id, Integer quantity, Double price, String day, String month, String year, String status, String productId, String customerId) {
        // TODO populate relationships here if appropriate
        
    }
}
