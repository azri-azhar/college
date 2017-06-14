
package org.azri.estore.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


/**
 * This is the home interface for CompanyProcess enterprise bean.
 */
public interface CompanyProcessRemoteHome extends EJBHome {
    
    CompanyProcessRemote create()  throws CreateException, RemoteException;
    
    
}
