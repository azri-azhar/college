
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for ProductProcess enterprise bean.
 */
public interface ProductProcessRemoteHome extends EJBHome {
    
    ProductProcessRemote create()  throws CreateException, RemoteException;
    
    
}
