
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for BuyProcess enterprise bean.
 */
public interface BuyProcessRemoteHome extends EJBHome {
    
    BuyProcessRemote create()  throws CreateException, RemoteException;
    
    
}
