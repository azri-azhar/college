
package org.azri.estore.ejb;


/**
 * This is the business interface for CategoryProcess enterprise bean.
 */
public interface CategoryProcessRemoteBusiness {
    void addCategory(String categoryName) throws java.rmi.RemoteException;

    void updateCategory(String categoryId, String name) throws java.rmi.RemoteException;

    void removeCategory(String categoryId) throws java.rmi.RemoteException;

    
}
