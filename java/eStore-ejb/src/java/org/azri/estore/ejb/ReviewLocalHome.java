
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Review enterprise bean.
 */
public interface ReviewLocalHome extends EJBLocalHome {
    
    ReviewLocal findByPrimaryKey(String key)  throws FinderException;

    public ReviewLocal create(String id, String review, Integer rating, String productId, String customerId) throws CreateException;

    Collection findById(String id) throws FinderException;

    Collection findByReview(String review) throws FinderException;

    Collection findByRating(Integer rating) throws FinderException;

    Collection findByProductId(String productId) throws FinderException;

    Collection findByCustomerId(String customerId) throws FinderException;
    
    
}
