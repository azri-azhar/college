
package org.azri.estore.ejb;


/**
 * This is the business interface for OrderProcess enterprise bean.
 */
public interface OrderProcessRemoteBusiness {

    void removeFromCart(String orderId) throws java.rmi.RemoteException;

    java.lang.String getTotalCart() throws java.rmi.RemoteException;

    java.util.ArrayList getAllCart(String customerId) throws java.rmi.RemoteException;

    void addCart(String quantity, String price, String productId, String customerId, String weight, String postageId) throws java.rmi.RemoteException;

    void checkOutByOther(String customerId) throws java.rmi.RemoteException;

    void checkOutByCreditCard(String customerId) throws java.rmi.RemoteException;

    java.util.ArrayList getCustomerOrderList(String customerId) throws java.rmi.RemoteException;

    java.lang.String getOrderStatus(String orderId) throws java.rmi.RemoteException;

    void setOrderStatus(String orderId, String status) throws java.rmi.RemoteException;

    java.util.ArrayList getCustomerListByStatus(String status) throws java.rmi.RemoteException;

    java.util.ArrayList getCustomerListByOtherStatus() throws java.rmi.RemoteException;

    
}
