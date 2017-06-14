
package org.azri.estore.ejb;


/**
 * This is the business interface for ProductProcess enterprise bean.
 */
public interface ProductProcessRemoteBusiness {
    void addProduct(String name, Double price, Integer quantity, Double weight, String dimension, String brand, String details, String description, String image, String categoryId) throws java.rmi.RemoteException;

    java.util.ArrayList getProductDetails(String productId) throws java.rmi.RemoteException;

    java.util.ArrayList getAllProductCategory() throws java.rmi.RemoteException;

    java.util.ArrayList getAllProduct() throws java.rmi.RemoteException;

    void removeProduct(String productId) throws java.rmi.RemoteException;

    void updateProduct(String productId, String name, String price, String quantity, String weight, String dimension, String brand, String details, String description, String image, String categoryId) throws java.rmi.RemoteException;

    java.util.ArrayList getAllProductByCategory(String categoryId) throws java.rmi.RemoteException;
    
}
