
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for ReviewProcess enterprise bean.
 */
public interface ReviewProcessRemoteHome extends EJBHome {
    
    ReviewProcessRemote create()  throws CreateException, RemoteException;
    
    
}
