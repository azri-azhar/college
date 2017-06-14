
package org.azri.estore.ejb;


/**
 * This is the business interface for Oder enterprise bean.
 */
public interface OderLocalBusiness {
    String getId();

    Integer getQuantity();

    void setQuantity(Integer quantity);

    Double getPrice();

    void setPrice(Double price);

    String getDay();

    void setDay(String day);

    String getMonth();

    void setMonth(String month);

    String getYear();

    void setYear(String year);

    String getStatus();

    void setStatus(String status);

    String getProductId();

    void setProductId(String productId);

    String getCustomerId();

    void setCustomerId(String customerId);

    void setPostageId(java.lang.String postageId);

    java.lang.String getPostageId();

    void setTotalShipping(java.lang.String totalShipping);

    java.lang.String getTotalShipping();

    void setTotalWeight(java.lang.String totalWeight);

    java.lang.String getTotalWeight();
    
}
