package org.azri.estore.webservice;


/**
 * This is the implementation bean class for the OrderStatus web service.
 * Created Jan 9, 2006 4:07:25 AM
 * @author azri
 */
public class OrderStatusImpl implements OrderStatusSEI {
    /**
     * Web service operation
     */
    public java.lang.String getOrderStatus(String orderId) throws java.rmi.RemoteException {
        org.azri.estore.ejb.OrderProcessRemote orderProcess = lookupOrderProcessBean();
        String status = orderProcess.getOrderStatus(orderId);
        return status;
    }

    private org.azri.estore.ejb.OrderProcessRemote lookupOrderProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/OrderProcessBean");
            org.azri.estore.ejb.OrderProcessRemoteHome rv = (org.azri.estore.ejb.OrderProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.OrderProcessRemoteHome.class);
            return rv.create();
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
        catch(javax.ejb.CreateException ce) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ce);
            throw new RuntimeException(ce);
        }
        catch(java.rmi.RemoteException re) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,re);
            throw new RuntimeException(re);
        }
    }
}
