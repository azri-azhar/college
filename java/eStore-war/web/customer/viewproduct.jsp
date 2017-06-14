<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Our Product</title>
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF" alink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="/eStore-Web/customer/images/header.jpg" width="935" height="98"></div></td>
  </tr>
</table>
<br>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="23%" height="472" valign="top" bgcolor="#003366"><br>
      <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#000033">
          <tr>
            <td><div align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Navigation</strong></font></div></td>
          </tr>
      </table>
        <p><font size="2"><a href="/eStore-Web/ViewProduct"><font face="Verdana, Arial, Helvetica, sans-serif"> 
        </font></a></font><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/customer/main.jsp">Home</a></font></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewProduct">Browse Product</a></font></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCategory/Customer">Browse Product By Category</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/View">View Your Shopping Cart</a></font></p>
        <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/CustomerViewOrder">View Your Order Status</a></font></p>
        <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/UpdateCustomer/EditForm">Edit Your Personal Details</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCustomer/Customer">View Your Personal Details</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewPostage/CustomerAll">View Postage Rate</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/LogOut/Customer">Log-Out</a></font></p></td><td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>    
      &nbsp;&nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>Our Product </strong></font><br>
      <br>
      <table width="100%" border="1" cellpadding="10">
  <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Name</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Brand</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Price</font></strong></div></td>
      <td><div align="center"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Details</font></strong></div></td>
      <c:forEach var="item" items="${requestScope.product}">
    <tr>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[1]}</font></div></td>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[6]}</font></div></td>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${item[2]}</font></div></td>
      <td><div align="center"><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewProductDetails?productid=${item[0]}"><strong>View Product Details</strong></a></font></div></td>
    </tr>
  </c:forEach>
        </table></td>
  </tr>
</table>
</body>
</html>
