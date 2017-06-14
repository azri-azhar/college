
package org.azri.estore.ejb;


/**
 * This is the business interface for Review enterprise bean.
 */
public interface ReviewLocalBusiness {
    String getId();

    String getReview();

    void setReview(String review);

    Integer getRating();

    void setRating(Integer rating);

    String getProductId();

    void setProductId(String productId);

    String getCustomerId();

    void setCustomerId(String customerId);
    
}
