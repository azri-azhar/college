
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for OrderProcess enterprise bean.
 */
public interface OrderProcessRemoteHome extends EJBHome {
    
    OrderProcessRemote create()  throws CreateException, RemoteException;
    
    
}
