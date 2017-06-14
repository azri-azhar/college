package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the ProductBean enterprise bean.
 * Created Dec 28, 2005 5:41:27 AM
 * @author Mohamad Azri
 */
public abstract class ProductBean implements EntityBean, ProductLocalBusiness {
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
    
    public abstract String getName();
    public abstract void setName(String name);
    
    public abstract Double getPrice();
    public abstract void setPrice(Double price);
    
    public abstract Integer getQuantity();
    public abstract void setQuantity(Integer quantity);
    
    public abstract Double getWeight();
    public abstract void setWeight(Double weight);
    
    public abstract String getDimension();
    public abstract void setDimension(String dimension);
    
    public abstract String getBrand();
    public abstract void setBrand(String brand);
    
    public abstract String getDetails();
    public abstract void setDetails(String details);
    
    public abstract String getDescription();
    public abstract void setDescription(String description);
    
    public abstract String getImage();
    public abstract void setImage(String image);
    
    public abstract String getCategoryId();
    public abstract void setCategoryId(String categoryId);
    
    
    public String ejbCreate(String id, String name, Double price, Integer quantity, Double weight, String dimension, String brand, String details, String description, String image, String categoryId)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (name == null) {
            throw new CreateException("The field \"name\" must not be null");
        }
        if (price == null) {
            throw new CreateException("The field \"price\" must not be null");
        }
        if (quantity == null) {
            throw new CreateException("The field \"quantity\" must not be null");
        }
        if (weight == null) {
            throw new CreateException("The field \"weight\" must not be null");
        }
        if (dimension == null) {
            throw new CreateException("The field \"dimension\" must not be null");
        }
        if (brand == null) {
            throw new CreateException("The field \"brand\" must not be null");
        }
        if (details == null) {
            throw new CreateException("The field \"details\" must not be null");
        }
        if (description == null) {
            throw new CreateException("The field \"description\" must not be null");
        }
        if (categoryId == null) {
            throw new CreateException("The field \"categoryId\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setWeight(weight);
        setDimension(dimension);
        setBrand(brand);
        setDetails(details);
        setDescription(description);
        setImage(image);
        setCategoryId(categoryId);
        
        return null;
    }
    
    public void ejbPostCreate(String id, String name, Double price, Integer quantity, Double weight, String dimension, String brand, String details, String description, String image, String categoryId) {
        // TODO populate relationships here if appropriate
        
    }
}
