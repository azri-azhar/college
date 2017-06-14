
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for CategoryProcess enterprise bean.
 */
public interface CategoryProcessRemoteHome extends EJBHome {
    
    CategoryProcessRemote create()  throws CreateException, RemoteException;
    
    
}
