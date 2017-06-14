package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the CustomerBean enterprise bean.
 * Created Dec 28, 2005 5:41:27 AM
 * @author Mohamad Azri
 */
public abstract class CustomerBean implements EntityBean, CustomerLocalBusiness {
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
    
    public abstract String getFirstName();
    public abstract void setFirstName(String firstName);
    
    public abstract String getLastName();
    public abstract void setLastName(String lastName);
    
    public abstract String getIc();
    public abstract void setIc(String ic);
    
    public abstract String getEmail();
    public abstract void setEmail(String email);
    
    public abstract String getPhone();
    public abstract void setPhone(String phone);
    
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
    
    public abstract String getShippingName();
    public abstract void setShippingName(String shippingName);
    
    public abstract String getShippingAddress();
    public abstract void setShippingAddress(String shippingAddress);
    
    public abstract String getShippingCity();
    public abstract void setShippingCity(String shippingCity);
    
    public abstract String getShippingState();
    public abstract void setShippingState(String shippingState);
    
    public abstract String getShippingZip();
    public abstract void setShippingZip(String shippingZip);
    
    public abstract String getShippingCountry();
    public abstract void setShippingCountry(String shippingCountry);
    
    
    public String ejbCreate(String id, String username, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry)  throws CreateException {
        if (id == null) {
            throw new CreateException("The field \"id\" must not be null");
        }
        if (username == null) {
            throw new CreateException("The field \"username\" must not be null");
        }
        if (password == null) {
            throw new CreateException("The field \"password\" must not be null");
        }
        if (firstName == null) {
            throw new CreateException("The field \"firstName\" must not be null");
        }
        if (lastName == null) {
            throw new CreateException("The field \"lastName\" must not be null");
        }
        if (ic == null) {
            throw new CreateException("The field \"ic\" must not be null");
        }
        if (email == null) {
            throw new CreateException("The field \"email\" must not be null");
        }
        if (phone == null) {
            throw new CreateException("The field \"phone\" must not be null");
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
        if (shippingName == null) {
            throw new CreateException("The field \"shippingName\" must not be null");
        }
        if (shippingAddress == null) {
            throw new CreateException("The field \"shippingAddress\" must not be null");
        }
        if (shippingCity == null) {
            throw new CreateException("The field \"shippingCity\" must not be null");
        }
        if (shippingState == null) {
            throw new CreateException("The field \"shippingState\" must not be null");
        }
        if (shippingZip == null) {
            throw new CreateException("The field \"shippingZip\" must not be null");
        }
        if (shippingCountry == null) {
            throw new CreateException("The field \"shippingCountry\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setId(id);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setIc(ic);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setCountry(country);
        setShippingName(shippingName);
        setShippingAddress(shippingAddress);
        setShippingCity(shippingCity);
        setShippingState(shippingState);
        setShippingZip(shippingZip);
        setShippingCountry(shippingCountry);
        
        return null;
    }
    
    public void ejbPostCreate(String id, String username, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) {
        // TODO populate relationships here if appropriate
        
    }
}
