
package org.azri.estore.ejb;


/**
 * This is the business interface for Postage enterprise bean.
 */
public interface PostageLocalBusiness {
    String getId();

    String getLocation();

    void setLocation(String location);

    Double getRate();

    void setRate(Double rate);
    
}
