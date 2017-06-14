
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Product enterprise bean.
 */
public interface ProductLocalHome extends EJBLocalHome {
    
    ProductLocal findByPrimaryKey(String key)  throws FinderException;

    public ProductLocal create(String id, String name, Double price, Integer quantity, Double weight, String dimension, String brand, String details, String description, String image, String categoryId) throws CreateException;

    org.azri.estore.ejb.ProductLocal findById(java.lang.String id) throws FinderException;

    Collection findByName(String name) throws FinderException;

    Collection findByPrice(Double price) throws FinderException;

    Collection findByQuantity(Integer quantity) throws FinderException;

    Collection findByWeight(Double weight) throws FinderException;

    Collection findByDimension(String dimension) throws FinderException;

    Collection findByBrand(String brand) throws FinderException;

    Collection findByDetails(String details) throws FinderException;

    Collection findByDescription(String description) throws FinderException;

    Collection findByImage(String image) throws FinderException;

    Collection findByCategoryId(String categoryId) throws FinderException;

    Collection findAllProduct() throws javax.ejb.FinderException;
    
    
}
