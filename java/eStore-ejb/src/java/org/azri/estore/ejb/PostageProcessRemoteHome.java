
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for PostageProcess enterprise bean.
 */
public interface PostageProcessRemoteHome extends EJBHome {
    
    PostageProcessRemote create()  throws CreateException, RemoteException;
    
    
}
