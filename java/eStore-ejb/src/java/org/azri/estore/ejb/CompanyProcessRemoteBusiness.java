
package org.azri.estore.ejb;


/**
 * This is the business interface for CompanyProcess enterprise bean.
 */
public interface CompanyProcessRemoteBusiness {
    void registerCompany(String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) throws java.rmi.RemoteException;

    boolean isUsernameExists(String username) throws java.rmi.RemoteException;

    boolean isLoginValid(String username, String password) throws java.rmi.RemoteException;

    java.lang.String[] getCompanyDetails(String companyId) throws java.rmi.RemoteException;

    void updateCompanyDetails(String companyId, String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) throws java.rmi.RemoteException;

    
}
