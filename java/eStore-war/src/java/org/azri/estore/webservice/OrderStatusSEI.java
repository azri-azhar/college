package org.azri.estore.webservice;


/**
 * This is the service endpoint interface for the OrderStatusweb service.
 * Created Jan 9, 2006 4:07:25 AM
 * @author azri
 */

public interface OrderStatusSEI extends java.rmi.Remote {
    /**
     * Web service operation
     */
    public java.lang.String getOrderStatus(String orderId) throws java.rmi.RemoteException;
    
}
