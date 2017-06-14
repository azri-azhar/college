package org.azri.estore.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.*;

/**
 * This is the bean class for the ProductProcessBean enterprise bean.
 * Created Jan 1, 2006 5:00:08 AM
 * @author Mohamad Azri
 */
public class ProductProcessBean implements SessionBean, ProductProcessRemoteBusiness {
    private SessionContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">
    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations
    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    // </editor-fold>
    
    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        
    }
    
    private org.azri.estore.ejb.ProductLocalHome lookupProductBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.ProductLocalHome rv = (org.azri.estore.ejb.ProductLocalHome) c.lookup("java:comp/env/ejb/ProductBean");
            return rv;
        } catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private org.azri.estore.ejb.CategoryLocalHome lookupCategoryBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.CategoryLocalHome rv = (org.azri.estore.ejb.CategoryLocalHome) c.lookup("java:comp/env/ejb/CategoryBean");
            return rv;
        } catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void addProduct(String name, Double price, Integer quantity, Double weight, String dimension, String brand, String details, String description, String image, String categoryId) {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        String id = String.valueOf( System.currentTimeMillis() );
        try {
            productHome.create(id, name, price, quantity, weight, dimension, brand, details, description, image, categoryId);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList getAllProductCategory() {
        org.azri.estore.ejb.CategoryLocalHome categoryHome = lookupCategoryBean();
        Collection category = null;
        ArrayList allCategory = new ArrayList();        
        try {
            category = categoryHome.findAllCategory();
            
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = category.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.CategoryLocal categoryLocal = (org.azri.estore.ejb.CategoryLocal) i.next();
            String[] categoryData = new String[2];
            categoryData[0] = categoryLocal.getId();
            categoryData[1] = categoryLocal.getName();
            allCategory.add(categoryData);
        }        
        return allCategory;
    }

    public ArrayList getAllProduct() {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        Collection product = null;
        ArrayList allProduct = new ArrayList();
        try {
            product = productHome.findAllProduct();        
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        Iterator i = product.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.ProductLocal productLocal = (org.azri.estore.ejb.ProductLocal) (i.next());
            String[] productData = new String[11];
            productData[0] = productLocal.getId();
            productData[1] = productLocal.getName();
            productData[2] = String.valueOf(productLocal.getPrice());
            productData[3] = String.valueOf(productLocal.getQuantity());
            productData[4] = String.valueOf(productLocal.getWeight());
            productData[5] = productLocal.getDimension();
            productData[6] = productLocal.getBrand();
            productData[7] = productLocal.getDetails();
            productData[8] = productLocal.getDescription();
            productData[9] = productLocal.getImage();
            productData[10] = productLocal.getCategoryId();
            allProduct.add(productData);
        }
        return allProduct;
    }    

    public ArrayList getProductDetails(String productId) {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        ArrayList productDetails = new ArrayList();
        try {
            org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(productId);
            String[] productData = new String[12];
            productData[0] = productLocal.getId();
            productData[1] = productLocal.getName();
            productData[2] = String.valueOf(productLocal.getPrice());
            productData[3] = String.valueOf(productLocal.getQuantity());
            productData[4] = String.valueOf(productLocal.getWeight());
            productData[5] = productLocal.getDimension();
            productData[6] = productLocal.getBrand();
            productData[7] = productLocal.getDetails();
            productData[8] = productLocal.getDescription();
            productData[9] = productLocal.getImage();
            productData[10] = productLocal.getCategoryId();
            productData[11] = getProductCategory(productData[10]);
            productDetails.add(productData);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        return productDetails;
    }
    
    public String getProductCategory(String categoryId) {
        org.azri.estore.ejb.CategoryLocalHome categoryHome = lookupCategoryBean();
        String categoryName = null;
        try {
            org.azri.estore.ejb.CategoryLocal categoryLocal = categoryHome.findById(categoryId);
            categoryName = categoryLocal.getName();
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return categoryName;
    }
    
    public void removeProduct(String productId) {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        try {
            org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(productId);
            productLocal.remove();
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (EJBException ex) {
            ex.printStackTrace();
        } catch (RemoveException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateProduct(String productId, String name, String price, String quantity, String weight, String dimension, String brand, String details, String description, String image, String categoryId) {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        try {
            org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(productId);
            productLocal.setName(name);
            productLocal.setPrice(Double.valueOf(price));
            productLocal.setQuantity(Integer.valueOf(quantity));
            productLocal.setWeight(Double.valueOf(weight));
            productLocal.setDimension(dimension);
            productLocal.setBrand(brand);
            productLocal.setDetails(details);
            productLocal.setDescription(description);
            productLocal.setImage(image);
            productLocal.setCategoryId(categoryId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList getAllProductByCategory(String categoryId) {
        org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
        Collection product = null;
        ArrayList allProduct = new ArrayList();
        try {
            product = productHome.findByCategoryId(categoryId);        
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
        Iterator i = product.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.ProductLocal productLocal = (org.azri.estore.ejb.ProductLocal) (i.next());
            String[] productData = new String[11];
            productData[0] = productLocal.getId();
            productData[1] = productLocal.getName();
            productData[2] = String.valueOf(productLocal.getPrice());
            productData[3] = String.valueOf(productLocal.getQuantity());
            productData[4] = String.valueOf(productLocal.getWeight());
            productData[5] = productLocal.getDimension();
            productData[6] = productLocal.getBrand();
            productData[7] = productLocal.getDetails();
            productData[8] = productLocal.getDescription();
            productData[9] = productLocal.getImage();
            productData[10] = productLocal.getCategoryId();
            allProduct.add(productData);
        }
        return allProduct;
    }    
}
