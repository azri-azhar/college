
package org.azri.estore.ejb;


/**
 * This is the business interface for Company enterprise bean.
 */
public interface CompanyLocalBusiness {
    String getId();

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getCompanyName();

    void setCompanyName(String companyName);

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

    String getContactName();

    void setContactName(String contactName);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getTitle();

    void setTitle(String title);
    
}
