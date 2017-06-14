<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eStore</title>
    </head>
    <body>

    <h1>Welcome to eStore</h1>
    <p><a href="company/companylogin.jsp">Company Login</a>    
    <p><a href="company/registercompany.jsp">New Company Registration and Setup</a>
    <p><a href="company/addcategory.jsp">Add New Product Category</a>
    <p><a href="company/addpostage.jsp">Add New Postage Rate</a>
    <p><a href="/eStore-Web/AddProduct/AddProductForm">Add New Product</a>
    <p><a href="/eStore-Web/ViewCompany">View Company Details</a>
    <p><a href="/eStore-Web/UpdateCompany/Form">Edit Company Details</a>
    <p><a href="/eStore-Web/ViewPostage/Company">View, Edit and Delete Postage</a>
    <p><a href="/eStore-Web/UpdateProduct/View">View, Edit and Delete Product</a> 
    <p><a href="/eStore-Web/ViewCategory/Company">View, Edit and Delete Category</a>    
    <p><a href="/eStore-Web/ViewCustomer/Company?customerid=1135978992828">View Customer Details</a></p>     
    <p><a href="/eStore-Web/ManageOrder/ViewOutstandingOrders">View New Orders</a>
    <p><a href="/eStore-Web/ManageOrder/ViewAwaitingPayment">View Awaiting Payment</a>    
    <p><a href="/eStore-Web/ManageOrder/ViewDeliveredItem">View Delivered Item</a></p>
    <p><a href="/eStore-Web/ManageOrder/ViewOtherStatus">View Other Orders Status</a></p>    
    <p><a href="/eStore-Web/ManageOrder/StatusForm?orderid=1136664066527">Change Order Status</a></p>
    <br>
    <br>
    <p><a href="customer/customerlogin.jsp">Customer Login</a></p>    
    <p><a href="customer/registercustomer.jsp">New Customer Registration</a></p>
    <p><a href="/eStore-Web/AddReview/Validate?productid=1136074970797">Add Product Review</a>
    <p><a href="/eStore-Web/ViewProduct">View Product</a>
    <p><a href="/eStore-Web/ViewProductDetails?productid=1136074970797">View Product Details</a>    
    <p><a href="/eStore-Web/ShoppingCart/Add?productid=1136074970797">Add to Shopping Cart</a>    
    <p><a href="/eStore-Web/ShoppingCart/View">View Shopping Cart</a> 
    <p><a href="/eStore-Web/ViewCategory/Customer">View Product By Category</a></p>
    <p><a href="/eStore-Web/UpdateCustomer/EditForm">Edit Customer Details</a></p>
    <p><a href="/eStore-Web/ViewCustomer/Customer">View Customer Details</a></p> 
    <p><a href="/eStore-Web/ShoppingCart/CheckOutByOther">Check out and pay via check, money order, or bank transfer</a></p>
    <p><a href="/eStore-Web/ShoppingCart/CheckOutByCreditCard">Check out and pay via credit card</a></p>
    <p><a href="/eStore-Web/ShoppingCart/CustomerViewOrder">View Order</a></p>     
    <p><a href="/eStore-Web/ShoppingCart/ValidateCreditCard">Validate Credit Card</a></p>    
    
    </body>
</html>
