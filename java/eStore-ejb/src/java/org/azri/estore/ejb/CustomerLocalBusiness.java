
package org.azri.estore.ejb;


/**
 * This is the business interface for Customer enterprise bean.
 */
public interface CustomerLocalBusiness {
    String getId();

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getIc();

    void setIc(String ic);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getAddress();

    void setAddress(String address);

    String getCity();

    void setCity(String city);

    String getState();

    void setState(String state);

    String getZip();

    void setZip(String zip);

    String getCountry();

    void setCountry(String country);

    String getShippingName();

    void setShippingName(String shippingName);

    String getShippingAddress();

    void setShippingAddress(String shippingAddress);

    String getShippingCity();

    void setShippingCity(String shippingCity);

    String getShippingState();

    void setShippingState(String shippingState);

    String getShippingZip();

    void setShippingZip(String shippingZip);

    String getShippingCountry();

    void setShippingCountry(String shippingCountry);
    
}
