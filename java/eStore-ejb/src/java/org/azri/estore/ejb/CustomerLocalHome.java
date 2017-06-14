
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Customer enterprise bean.
 */
public interface CustomerLocalHome extends EJBLocalHome {
    
    CustomerLocal findByPrimaryKey(String key)  throws FinderException;

    public CustomerLocal create(String id, String username, String password, String firstName, String lastName, String ic, String email, String phone, String address, String city, String state, String zip, String country, String shippingName, String shippingAddress, String shippingCity, String shippingState, String shippingZip, String shippingCountry) throws CreateException;

    org.azri.estore.ejb.CustomerLocal findById(java.lang.String id) throws FinderException;

    org.azri.estore.ejb.CustomerLocal findByUsername(java.lang.String username) throws FinderException;

    Collection findByPassword(String password) throws FinderException;

    Collection findByFirstName(String firstName) throws FinderException;

    Collection findByLastName(String lastName) throws FinderException;

    Collection findByIc(String ic) throws FinderException;

    Collection findByEmail(String email) throws FinderException;

    Collection findByPhone(String phone) throws FinderException;

    Collection findByAddress(String address) throws FinderException;

    Collection findByCity(String city) throws FinderException;

    Collection findByState(String state) throws FinderException;

    Collection findByZip(String zip) throws FinderException;

    Collection findByCountry(String country) throws FinderException;

    Collection findByShippingName(String shippingName) throws FinderException;

    Collection findByShippingAddress(String shippingAddress) throws FinderException;

    Collection findByShippingCity(String shippingCity) throws FinderException;

    Collection findByShippingState(String shippingState) throws FinderException;

    Collection findByShippingZip(String shippingZip) throws FinderException;

    Collection findByShippingCountry(String shippingCountry) throws FinderException;
    
    
}
