package org.azri.estore.ejb;

import javax.ejb.*;

/**
 * This is the bean class for the CustomerProcessBean enterprise bean.
 * Created Dec 31, 2005 4:23:28 AM
 * @author Mohamad Azri
 */
public class CustomerProcessBean implements SessionBean, CustomerProcessRemoteBusiness {
    private SessionContext context;
    private String customerId;
    private String customerName;
    
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

    private org.azri.estore.ejb.CustomerLocalHome lookupCustomerBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.CustomerLocalHome rv = (org.azri.estore.ejb.CustomerLocalHome) c.lookup("java:comp/env/ejb/CustomerBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }   
    
    public void registerCustomer(String username, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            customerHome.create(id, username, password, firstName, lastName, ic, email, phone, address, city, state, zip, country, shippingName, shippingAddress, shippingCity, shippingState, shippingZip, shippingCountry);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean isUsernameExists(String username) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        try {      
            org.azri.estore.ejb.CustomerLocal newUsername = customerHome.findByUsername(username);
            String customerId = newUsername.getId();
            if (customerId != null)
                return true;
            else
                return false;          
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        return false;
    }
    
    public boolean isLoginValid(String username, String password) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        try {      
            org.azri.estore.ejb.CustomerLocal customerLocal = customerHome.findByUsername(username);
            String customerId = customerLocal.getId();
            String customerUsername = customerLocal.getUsername();
            String customerPassword = customerLocal.getPassword();
            String customerFirstName = customerLocal.getFirstName();
            String customerLastName = customerLocal.getLastName();
            if ( (customerId != null) && (customerUsername.equals(username)) && (customerPassword.equals(password)) ) {
                setCustomerId(customerId);
                setCustomerName(customerFirstName, customerLastName);
                return true;
            } else {
                return false;
            }
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        return false;        
    }    

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerName(String firstName, String lastName) {
        this.customerName = firstName + " " + lastName;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public String getCustomerNameById(String customerId) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        String customerName = null;
        try {
            org.azri.estore.ejb.CustomerLocal customerLocal = customerHome.findById(customerId);
            customerName = customerLocal.getFirstName() + " " + customerLocal.getLastName();
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return customerName;
    }
    
    public void updateCustomerDetails(String customerId, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        try {
            org.azri.estore.ejb.CustomerLocal customer = customerHome.findById(customerId);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setCountry(country);
            customer.setEmail(email);
            customer.setFirstName(firstName);
            customer.setIc(ic);
            customer.setLastName(lastName);
            customer.setPassword(password);
            customer.setPhone(phone);
            customer.setShippingAddress(shippingAddress);
            customer.setShippingCity(shippingCity);
            customer.setShippingCountry(shippingCountry);
            customer.setShippingName(shippingName);
            customer.setShippingState(shippingState);
            customer.setShippingZip(shippingZip);
            customer.setState(state);
            customer.setZip(zip);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
    }
    
    public String[] getCustomerDetails(String customerId) {
        org.azri.estore.ejb.CustomerLocalHome customerHome = lookupCustomerBean();
        String[] customerDetails = new String[19];
        try {
            org.azri.estore.ejb.CustomerLocal customer = customerHome.findById(customerId);            
            customerDetails[0] = customer.getId();
            customerDetails[1] = customer.getUsername();
            customerDetails[8] = customer.getAddress();
            customerDetails[9] = customer.getCity();
            customerDetails[12] = customer.getCountry();
            customerDetails[6] = customer.getEmail();
            customerDetails[3] = customer.getFirstName();
            customerDetails[5] = customer.getIc();
            customerDetails[4] = customer.getLastName();
            customerDetails[2] = customer.getPassword();
            customerDetails[7] = customer.getPhone();
            customerDetails[13] = customer.getShippingAddress();
            customerDetails[14] = customer.getShippingCity();
            customerDetails[17] = customer.getShippingCountry();
            customerDetails[18] = customer.getShippingName();
            customerDetails[15] = customer.getShippingState();
            customerDetails[16] = customer.getShippingZip();
            customerDetails[10] = customer.getState();
            customerDetails[11] = customer.getZip();            
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return customerDetails;
    }
}
