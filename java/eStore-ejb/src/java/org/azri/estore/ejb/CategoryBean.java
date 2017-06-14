package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the CategoryBean enterprise bean.
 * Created Dec 28, 2005 5:41:27 AM
 * @author Mohamad Azri
 */
public abstract class CategoryBean implements EntityBean, CategoryLocalBusiness {
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
    
    
    public String ejbCreate(String id, String name)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (name == null) {
            throw new CreateException("The field \"name\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setId(id);
        setName(name);
        
        return null;
    }
    
    public void ejbPostCreate(String id, String name) {
        // TODO populate relationships here if appropriate
        
    }
}
