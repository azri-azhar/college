
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Category enterprise bean.
 */
public interface CategoryLocalHome extends EJBLocalHome {
    
    CategoryLocal findByPrimaryKey(String key)  throws FinderException;

    public CategoryLocal create(String id, String name) throws CreateException;

    org.azri.estore.ejb.CategoryLocal findById(java.lang.String id) throws FinderException;

    Collection findByName(String name) throws FinderException;

    java.util.Collection findAllCategory() throws javax.ejb.FinderException;
    
    
}
