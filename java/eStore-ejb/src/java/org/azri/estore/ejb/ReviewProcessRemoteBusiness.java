
package org.azri.estore.ejb;

import java.util.ArrayList;


/**
 * This is the business interface for ReviewProcess enterprise bean.
 */
public interface ReviewProcessRemoteBusiness {
    void addReview(String review, Integer rating, String productId, String customerId) throws java.rmi.RemoteException;

    boolean isProductReceived(String productId, String customerId) throws java.rmi.RemoteException;

    ArrayList getProductReview(String productId) throws java.rmi.RemoteException;




    
}
