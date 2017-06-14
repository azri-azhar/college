<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Manage Order</title>
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="/eStore-Web/company/images/header.jpg" width="935" height="98"></div></td>
  </tr>
</table>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#003366" bgcolor="#000033">
  <tr>
    <td bgcolor="#003366"><div align="center"><font color="#FFFFFF" face="Verdana, Arial, Helvetica, sans-serif"><strong>Navigation</strong></font></div></td>
  </tr>
</table>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11%" height="217" valign="top" bgcolor="#003366">        <p><font size="2"><a href="/eStore-Web/ViewProduct"><font face="Verdana, Arial, Helvetica, sans-serif"> </font></a><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"></font></font><font face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/company/main.jsp">Home</a></font></font></p>
    <p><font size="2"><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/company/addcategory.jsp">Add New Product Category</a></font></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/company/addpostage.jsp">Add New Postage Rate</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/AddProduct/AddProductForm">Add New Product</a></font></p>
      <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewCompany">View Maintainer Details</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/UpdateCompany/Form">Edit Maintainer Details</a></font></p>
      <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewPostage/Company">View, Edit and Delete Postage</a></font></p>    </td>
  <td width="12%" valign="top" bgcolor="#003366"><p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/UpdateProduct/View">View, Edit and Delete Product</a></font> </p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewCategory/Company">View, Edit and Delete Category</a></font></p>
    <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewOutstandingOrders">View New Orders</a></font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewAwaitingPayment">View Awaiting Payment Orders </a> </font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewDeliveredItem">View Delivered Item</a></font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewOtherStatus">View Other Orders Status</a></font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/LogOut/Company">Log-Out</a></font></p></td>
  </tr>
</table>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="95%" height="472" valign="baseline" bgcolor="#FFFFFF"><p><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;${requestScope.title}</strong></font></p>
      <p>&nbsp;&nbsp;&nbsp;<font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.description}</font><br>
      </p>
      <table border="1">
  <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Order Id</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Order Date</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Details</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Name</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Price</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Shipping Weight</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Shipping Charge</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Shipping Details</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total Price</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Order Status</font></strong></div></td>
      <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Customer Details</font></strong></td>
      <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Change Status</font></strong></td>
      <c:forEach var="item" items="${requestScope.order}">
    <tr>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[5]}</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[11]}</font></td>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewProductDetailsCompany?productid=${item[0]}"><strong>View</strong></a></font></div></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[1]}</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${item[2]}</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[3]}</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[7]} g</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${item[8]}</font></td>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewPostage/CompanyById?postageid=${item[6]}"><strong>View</strong></a></font></div></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${item[4]}</font></td>
      <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[9]}</font></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCustomer/Company?customerid=${item[10]}">View</a></font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ManageOrder/StatusForm?orderid=${item[5]}">Change</a></font></strong></div></td>
    </tr>
  <strong></c:forEach>
  </strong>
      </table></td>
  </tr>
</table>
</body>
</html>
