
package org.azri.estore.ejb;


/**
 * This is the business interface for CustomerProcess enterprise bean.
 */
public interface CustomerProcessRemoteBusiness {
    void registerCustomer(String username, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) throws java.rmi.RemoteException;

    boolean isUsernameExists(String username) throws java.rmi.RemoteException;

    void setCustomerId(String customerId) throws java.rmi.RemoteException;

    String getCustomerId() throws java.rmi.RemoteException;

    boolean isLoginValid(String username, String password) throws java.rmi.RemoteException;

    String getCustomerName() throws java.rmi.RemoteException;

    void setCustomerName(String firstName, String lastName) throws java.rmi.RemoteException;

    java.lang.String getCustomerNameById(String customerId) throws java.rmi.RemoteException;

    void updateCustomerDetails(String customerId, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) throws java.rmi.RemoteException;

    java.lang.String[] getCustomerDetails(String customerId) throws java.rmi.RemoteException;

    
}
