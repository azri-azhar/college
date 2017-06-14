
package org.azri.estore.ejb;


/**
 * This is the business interface for Product enterprise bean.
 */
public interface ProductLocalBusiness {
    String getId();

    String getName();

    void setName(String name);

    Double getPrice();

    void setPrice(Double price);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    Double getWeight();

    void setWeight(Double weight);

    String getDimension();

    void setDimension(String dimension);

    String getBrand();

    void setBrand(String brand);

    String getDetails();

    void setDetails(String details);

    String getDescription();

    void setDescription(String description);

    String getImage();

    void setImage(String image);

    String getCategoryId();

    void setCategoryId(String categoryId);
    
}
