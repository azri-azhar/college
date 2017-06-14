package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the CompanyBean enterprise bean.
 * Created Dec 28, 2005 5:41:27 AM
 * @author Mohamad Azri
 */
public abstract class CompanyBean implements EntityBean, CompanyLocalBusiness {
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
    
    public abstract String getUsername();
    public abstract void setUsername(String username);
    
    public abstract String getPassword();
    public abstract void setPassword(String password);
    
    public abstract String getCompanyName();
    public abstract void setCompanyName(String companyName);
    
    public abstract String getAddress();
    public abstract void setAddress(String address);
    
    public abstract String getCity();
    public abstract void setCity(String city);
    
    public abstract String getState();
    public abstract void setState(String state);
    
    public abstract String getZip();
    public abstract void setZip(String zip);
    
    public abstract String getCountry();
    public abstract void setCountry(String country);
    
    public abstract String getContactName();
    public abstract void setContactName(String contactName);
    
    public abstract String getEmail();
    public abstract void setEmail(String email);
    
    public abstract String getPhone();
    public abstract void setPhone(String phone);
    
    public abstract String getTitle();
    public abstract void setTitle(String title);
        
    public String ejbCreate(String id, String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (username == null) {
            throw new CreateException("The field \"username\" must not be null");
        }
        if (password == null) {
            throw new CreateException("The field \"password\" must not be null");
        }
        if (companyName == null) {
            throw new CreateException("The field \"companyName\" must not be null");
        }
        if (address == null) {
            throw new CreateException("The field \"address\" must not be null");
        }
        if (city == null) {
            throw new CreateException("The field \"city\" must not be null");
        }
        if (state == null) {
            throw new CreateException("The field \"state\" must not be null");
        }
        if (zip == null) {
            throw new CreateException("The field \"zip\" must not be null");
        }
        if (country == null) {
            throw new CreateException("The field \"country\" must not be null");
        }
        if (contactName == null) {
            throw new CreateException("The field \"contactName\" must not be null");
        }
        if (email == null) {
            throw new CreateException("The field \"email\" must not be null");
        }
        if (phone == null) {
            throw new CreateException("The field \"phone\" must not be null");
        }
        if (title == null) {
            throw new CreateException("The field \"title\" must not be null");
        }
        
        setId(id);
        setUsername(username);
        setPassword(password);
        setCompanyName(companyName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setCountry(country);
        setContactName(contactName);
        setEmail(email);
        setPhone(phone);
        setTitle(title);
        
        return null;
    }
    
    public void ejbPostCreate(String id, String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) {
       
    }
}
