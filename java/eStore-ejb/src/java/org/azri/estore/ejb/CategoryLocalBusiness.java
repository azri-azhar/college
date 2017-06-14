
package org.azri.estore.ejb;


/**
 * This is the business interface for Category enterprise bean.
 */
public interface CategoryLocalBusiness {
    String getId();

    String getName();

    void setName(String name);
    
}
