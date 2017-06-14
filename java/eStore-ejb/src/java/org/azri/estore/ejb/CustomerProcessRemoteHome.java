
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for CustomerProcess enterprise bean.
 */
public interface CustomerProcessRemoteHome extends EJBHome {
    
    CustomerProcessRemote create()  throws CreateException, RemoteException;
    
    
}
