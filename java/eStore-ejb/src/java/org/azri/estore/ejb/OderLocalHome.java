
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Oder enterprise bean.
 */
public interface OderLocalHome extends EJBLocalHome {
    
    OderLocal findByPrimaryKey(String key)  throws FinderException;

    org.azri.estore.ejb.OderLocal findById(java.lang.String id) throws FinderException;

    Collection findByQuantity(Integer quantity) throws FinderException;

    Collection findByPrice(Double price) throws FinderException;

    Collection findByDay(String day) throws FinderException;

    Collection findByMonth(String month) throws FinderException;

    Collection findByYear(String year) throws FinderException;

    Collection findByStatus(String status) throws FinderException;

    Collection findByProductId(String productId) throws FinderException;

    Collection findByCustomerId(String customerId) throws FinderException;

    org.azri.estore.ejb.OderLocal findByProductReceived(java.lang.String productId, java.lang.String customerId) throws javax.ejb.FinderException;

    public OderLocal create(String id, Integer quantity, Double price, String day, String month, String year, String status, String productId, String customerId, String postageId, String totalWeight, String totalShipping) throws CreateException;

    Collection findByProductInCart(String customerId) throws javax.ejb.FinderException;

    java.util.Collection findByOtherStatus() throws javax.ejb.FinderException;
    
    
}
