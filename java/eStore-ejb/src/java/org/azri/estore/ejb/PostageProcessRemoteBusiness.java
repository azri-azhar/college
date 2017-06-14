
package org.azri.estore.ejb;


/**
 * This is the business interface for PostageProcess enterprise bean.
 */
public interface PostageProcessRemoteBusiness {
    void addPostageRate(String location, Double rate) throws java.rmi.RemoteException;

    java.util.ArrayList getAllPostageRate() throws java.rmi.RemoteException;

    void updatePostageRate(String postageId, String location, String rate) throws java.rmi.RemoteException;

    void removePostage(String postageId) throws java.rmi.RemoteException;

    java.lang.String getPostageRateById(String postageId) throws java.rmi.RemoteException;

    java.lang.String[] getPostageById(String postageId) throws java.rmi.RemoteException;
    
}
