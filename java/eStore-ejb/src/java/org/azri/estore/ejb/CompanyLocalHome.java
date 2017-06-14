
package org.azri.estore.ejb;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Company enterprise bean.
 */
public interface CompanyLocalHome extends EJBLocalHome {
    
    CompanyLocal findByPrimaryKey(String key)  throws FinderException;

    public CompanyLocal create(String id, String username, String password, String companyName, String address, String city, String state, String zip, String country, String contactName, String email, String phone, String title) throws CreateException;

    org.azri.estore.ejb.CompanyLocal findById(java.lang.String id) throws FinderException;

    org.azri.estore.ejb.CompanyLocal findByUsername(java.lang.String username) throws FinderException;

    Collection findByPassword(String password) throws FinderException;

    Collection findByCompanyName(String companyName) throws FinderException;

    Collection findByAddress(String address) throws FinderException;

    Collection findByCity(String city) throws FinderException;

    Collection findByState(String state) throws FinderException;

    Collection findByZip(String zip) throws FinderException;

    Collection findByCountry(String country) throws FinderException;

    Collection findByContactName(String contactName) throws FinderException;

    Collection findByEmail(String email) throws FinderException;

    Collection findByPhone(String phone) throws FinderException;

    Collection findByTitle(String title) throws FinderException;
    
    
}
