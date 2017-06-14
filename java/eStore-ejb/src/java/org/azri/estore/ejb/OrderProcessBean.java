package org.azri.estore.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.ejb.*;

/**
 * This is the bean class for the OrderProcessBean enterprise bean.
 * Created Jan 2, 2006 6:30:39 AM
 * @author azri
 */
public class OrderProcessBean implements SessionBean, OrderProcessRemoteBusiness {
    private SessionContext context;
    private double totalCart;
    
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

    public void addCart(String quantity, String price, String productId, String customerId, String weight, String postageId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        org.azri.estore.ejb.PostageProcessRemote postageHome = lookupPostageProcessBean();
        String id = String.valueOf( System.currentTimeMillis() );
        int quantityTemp = Integer.parseInt(quantity);
        double priceTemp = Double.parseDouble(price);
        double postageRate = 0.0;
        double weightTemp = Double.parseDouble(weight);
        try {
            postageRate = Double.parseDouble(postageHome.getPostageRateById(postageId));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        double totalWeight = weightTemp * quantityTemp;
        double totalShipping = totalWeight * postageRate;        
        double totalPrice = (quantityTemp * priceTemp) + totalShipping;
        Calendar cal = new GregorianCalendar();
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(cal.get(Calendar.MONTH));
        String year = String.valueOf(cal.get(Calendar.YEAR)); 
        try {
            orderHome.create(id, new Integer(quantityTemp), new Double(totalPrice), day, month, year, "Cart", productId, customerId, postageId, String.valueOf(totalWeight), String.valueOf(totalShipping));
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeFromCart(String orderId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        try {
            org.azri.estore.ejb.OderLocal orderLocal = orderHome.findById(orderId);
            orderLocal.remove();

        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (EJBException ex) {
            ex.printStackTrace();
        } catch (RemoveException ex) {
            ex.printStackTrace();
        }     
    }
    
    public ArrayList getAllCart(String customerId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection cart = null;
        ArrayList allCart = new ArrayList();
        double totalCart = 0.0;
        try {
            cart = orderHome.findByProductInCart(customerId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = cart.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.OderLocal order = (org.azri.estore.ejb.OderLocal)i.next();
            String[] cartData = new String[9];
            org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
            try {
                org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(order.getProductId());               
                cartData[0] = productLocal.getId();
                cartData[1] = productLocal.getName(); 
                cartData[2] =  String.valueOf(productLocal.getPrice());
                cartData[3] = String.valueOf(order.getQuantity());
                cartData[4] = String.valueOf(order.getPrice());
                cartData[5] = order.getId();
                cartData[6] = order.getPostageId();
                cartData[7] = order.getTotalWeight();
                cartData[8] = order.getTotalShipping();
                totalCart = totalCart + Double.parseDouble(String.valueOf(order.getPrice()));
            } catch (FinderException ex) {
                ex.printStackTrace();
            }            
            allCart.add(cartData);
        }
        setTotalCart(totalCart);
        return allCart;
    }

    private void setTotalCart(double cart) {
        this.totalCart = cart;
    }
    
    public String getTotalCart() {
        return String.valueOf(this.totalCart);
    }

    public void checkOutByCreditCard(String customerId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection cart = null;
        try {
            cart = orderHome.findByProductInCart(customerId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = cart.iterator();
        while(i.hasNext()) {
            org.azri.estore.ejb.OderLocal order = (org.azri.estore.ejb.OderLocal)i.next();
            order.setStatus("Processing");
        }
    }
    
    public void checkOutByOther(String customerId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection cart = null;
        try {
            cart = orderHome.findByProductInCart(customerId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = cart.iterator();
        while(i.hasNext()) {
            org.azri.estore.ejb.OderLocal order = (org.azri.estore.ejb.OderLocal)i.next();
            order.setStatus("Awaiting for payment");
        }
    }
    
    public ArrayList getCustomerOrderList(String customerId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection order = null;
        ArrayList allOrder = new ArrayList();
        try {
            order = orderHome.findByCustomerId(customerId);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = order.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.OderLocal orderLocal = (org.azri.estore.ejb.OderLocal)i.next();
            String[] orderData = new String[11];
            org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
            try {
                if ((orderLocal.getStatus()).equals("Cart"))
                {
                    continue;
                }
                org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(orderLocal.getProductId());               
                orderData[0] = productLocal.getId();
                orderData[1] = productLocal.getName(); 
                orderData[2] =  String.valueOf(productLocal.getPrice());
                orderData[3] = String.valueOf(orderLocal.getQuantity());
                orderData[4] = String.valueOf(orderLocal.getPrice());
                orderData[5] = orderLocal.getId();
                orderData[6] = orderLocal.getPostageId();
                orderData[7] = orderLocal.getTotalWeight();
                orderData[8] = orderLocal.getTotalShipping();
                orderData[9] = orderLocal.getStatus();
                orderData[10] = orderLocal.getDay() + "-" + String.valueOf((Integer.parseInt(orderLocal.getMonth()) + 1)) + "-" + orderLocal.getYear();
            } catch (FinderException ex) {
                ex.printStackTrace();
            }            
            allOrder.add(orderData);
        }
        return allOrder;
    }
      
    public ArrayList getCustomerListByStatus(String status) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection order = null;
        ArrayList allOrder = new ArrayList();
        try {
            order = orderHome.findByStatus(status);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = order.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.OderLocal orderLocal = (org.azri.estore.ejb.OderLocal)i.next();
            String[] orderData = new String[12];
            org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
            try {
                org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(orderLocal.getProductId());               
                orderData[0] = productLocal.getId();
                orderData[1] = productLocal.getName(); 
                orderData[2] =  String.valueOf(productLocal.getPrice());
                orderData[3] = String.valueOf(orderLocal.getQuantity());
                orderData[4] = String.valueOf(orderLocal.getPrice());
                orderData[5] = orderLocal.getId();
                orderData[6] = orderLocal.getPostageId();
                orderData[7] = orderLocal.getTotalWeight();
                orderData[8] = orderLocal.getTotalShipping();
                orderData[9] = orderLocal.getStatus();
                orderData[10] = orderLocal.getCustomerId();
                orderData[11] = orderLocal.getDay() + "-" + String.valueOf((Integer.parseInt(orderLocal.getMonth()) + 1)) + "-" + orderLocal.getYear();                
            } catch (FinderException ex) {
                ex.printStackTrace();
            }            
            allOrder.add(orderData);
        }
        return allOrder;
    }
    
    public ArrayList getCustomerListByOtherStatus() {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        Collection order = null;
        ArrayList allOrder = new ArrayList();
        try {
            order = orderHome.findByOtherStatus();
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        Iterator i = order.iterator();
        while (i.hasNext()) {
            org.azri.estore.ejb.OderLocal orderLocal = (org.azri.estore.ejb.OderLocal)i.next();
            String[] orderData = new String[12];
            org.azri.estore.ejb.ProductLocalHome productHome = lookupProductBean();
            try {
                org.azri.estore.ejb.ProductLocal productLocal = productHome.findById(orderLocal.getProductId());               
                if (orderLocal.getStatus().equals("Received") )
                    continue;
                orderData[0] = productLocal.getId();
                orderData[1] = productLocal.getName(); 
                orderData[2] =  String.valueOf(productLocal.getPrice());
                orderData[3] = String.valueOf(orderLocal.getQuantity());
                orderData[4] = String.valueOf(orderLocal.getPrice());
                orderData[5] = orderLocal.getId();
                orderData[6] = orderLocal.getPostageId();
                orderData[7] = orderLocal.getTotalWeight();
                orderData[8] = orderLocal.getTotalShipping();
                orderData[9] = orderLocal.getStatus();
                orderData[10] = orderLocal.getCustomerId();
                orderData[11] = orderLocal.getDay() + "-" + String.valueOf((Integer.parseInt(orderLocal.getMonth()) + 1)) + "-" + orderLocal.getYear();                
            } catch (FinderException ex) {
                ex.printStackTrace();
            }            
            allOrder.add(orderData);
        }
        return allOrder;
    }
  
    public String getOrderStatus(String orderId) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        String status = "";
        try {
            org.azri.estore.ejb.OderLocal orderLocal = orderHome.findById(orderId);
            if ((orderLocal.getStatus()).equals("Processing"))
            {
                status = "Your order is being processed and will shortly progress towards dispatch";
            } else if ((orderLocal.getStatus()).equals("Received")) {
                status = "You have received the product. Please contact us if there is a mistake";
            } else if ((orderLocal.getStatus()).equals("Awaiting for payment")) {
                status = "We are waiting for your payment. Once we receive it, we will process your order immediately.";
            }
            else {
                status = orderLocal.getStatus();
            }
        } catch (FinderException ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public void setOrderStatus(String orderId, String status) {
        org.azri.estore.ejb.OderLocalHome orderHome = lookupOderBean();
        try {
            org.azri.estore.ejb.OderLocal orderLocal = orderHome.findById(orderId); 
            orderLocal.setStatus(status);
        } catch (FinderException ex) {
            ex.printStackTrace();
        }        
    }
    
    private org.azri.estore.ejb.OderLocalHome lookupOderBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.OderLocalHome rv = (org.azri.estore.ejb.OderLocalHome) c.lookup("java:comp/env/ejb/OderBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }   

    private org.azri.estore.ejb.ProductLocalHome lookupProductBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            org.azri.estore.ejb.ProductLocalHome rv = (org.azri.estore.ejb.ProductLocalHome) c.lookup("java:comp/env/ejb/ProductBean");
            return rv;
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    private org.azri.estore.ejb.PostageProcessRemote lookupPostageProcessBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            Object remote = c.lookup("java:comp/env/ejb/PostageProcessBean");
            org.azri.estore.ejb.PostageProcessRemoteHome rv = (org.azri.estore.ejb.PostageProcessRemoteHome) javax.rmi.PortableRemoteObject.narrow(remote, org.azri.estore.ejb.PostageProcessRemoteHome.class);
            return rv.create();
        }
        catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
        catch(javax.ejb.CreateException ce) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ce);
            throw new RuntimeException(ce);
        }
        catch(java.rmi.RemoteException re) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,re);
            throw new RuntimeException(re);
        }
    }
}
