
package org.azri.estore.ejb;


/**
 * This is the business interface for BuyProcess enterprise bean.
 */
public interface BuyProcessRemoteBusiness {
    void addOrder() throws java.rmi.RemoteException;
    
}
