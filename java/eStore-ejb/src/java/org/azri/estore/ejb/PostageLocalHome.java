
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Postage enterprise bean.
 */
public interface PostageLocalHome extends EJBLocalHome {
    
    PostageLocal findByPrimaryKey(String key)  throws FinderException;

    public PostageLocal create(String id, String location, Double rate) throws CreateException;

    org.azri.estore.ejb.PostageLocal findById(java.lang.String id) throws FinderException;

    Collection findByLocation(String location) throws FinderException;

    Collection findByRate(Double rate) throws FinderException;

    Collection findAllPostage() throws javax.ejb.FinderException;
    
    
}
