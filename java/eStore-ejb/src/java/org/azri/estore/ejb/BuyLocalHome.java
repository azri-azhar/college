
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Buy enterprise bean.
 */
public interface BuyLocalHome extends EJBLocalHome {
    
    BuyLocal findByPrimaryKey(String key)  throws FinderException;

    public BuyLocal create(String id, Integer quantity, Double price, String day, String month, String year, String status, String productId, String customerId) throws CreateException;

    Collection findById(String id) throws FinderException;

    Collection findByQuantity(Integer quantity) throws FinderException;

    Collection findByPrice(Double price) throws FinderException;

    Collection findByDay(String day) throws FinderException;

    Collection findByMonth(String month) throws FinderException;

    Collection findByYear(String year) throws FinderException;

    Collection findByStatus(String status) throws FinderException;

    Collection findByProductId(String productId) throws FinderException;

    Collection findByCustomerId(String customerId) throws FinderException;

    void create(String string, Integer integer, Double aDouble, String string0, String string1, String string2, String string3, String string4);
    
    
}
