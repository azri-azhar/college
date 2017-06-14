<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Product Details</title>
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="/eStore-Web/customer/images/header.jpg" width="935" height="98"></div></td>
  </tr>
</table>
<br>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="24%" height="472" valign="top" bgcolor="#003366"><br>
      <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#000033">
      <tr>
        <td><div align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Navigation</strong></font></div></td>
      </tr>
    </table>
    <p><font size="2"><a href="/eStore-Web/ViewProduct"><font face="Verdana, Arial, Helvetica, sans-serif"> 
      </font></a><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"></font></font><font face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/company/main.jsp">Home</a></font></font></p>
      <p><font size="2"><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/company/addcategory.jsp">Add New Product Category</a></font></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/company/addpostage.jsp">Add New Postage Rate</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/AddProduct/AddProductForm">Add New Product</a></font></p>
      <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewCompany">View Maintainer Details</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/UpdateCompany/Form">Edit Maintainer Details</a></font></p>
      <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewPostage/Company">View, Edit and Delete Postage</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/UpdateProduct/View">View, Edit and Delete Product</a></font> </p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewCategory/Company">View, Edit and Delete Category</a></font></p>
      <p> <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewOutstandingOrders">View New Orders</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewAwaitingPayment">View Awaiting Payment Orders </a> </font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewDeliveredItem">View Delivered Item</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"> <img src="/eStore-Web/company/images/button.gif" width="13" height="10"><a href="/eStore-Web/ManageOrder/ViewOtherStatus">View Other Orders Status</a></font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/LogOut/Company">Log-Out</a></font></p>
      <p>&nbsp;</p></td>
    <td width="76%" valign="baseline" bgcolor="#FFFFFF"><p><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Product Details</strong></font></p>
      <p align="center"><br>
        <br>
        <img src="/eStore-Web/company/images/${requestScope.product[0][9]}"></p>
      <p><br>
        <font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;&nbsp;Category: <a href="/eStore-Web/ViewCategory/ViewProductByCategoryCompany?categoryid=${requestScope.product[0][10]}">${requestScope.product[0][11]}</a></strong></font></p>
      <table width="100%" height="324"  border="0" cellpadding="10" cellspacing="0">
  <tr>
    <td width="23%" height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Name:</font></strong></td>
    <td width="77%"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][1]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Price:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${requestScope.product[0][2]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Available Quantity:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][3]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Weight:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][4]} g</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Dimension:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][5]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Brand: </font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][6]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Technical Details:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][7]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Description:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][8]}</font></td>
  </tr>
  <tr>
    <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Image Location:</font></strong></td>
    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][9]}</font></td>
  </tr>
</table> 
      <p>&nbsp;&nbsp;<strong><font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>Customers Review </strong></font></strong> </p>
<table width="100%" height="108"  border="0" cellpadding="10" cellspacing="0">
<c:forEach var="item" items="${requestScope.review}">
  <tr>
    <td width="23%" height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Customer Name:</font></strong></td>
    <td width="77%"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${item[0]}</font></td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Review:</font></strong></td>
    <td>${item[1]}</td>
  </tr>
  <tr>
    <td height="36"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Rating:</font></strong></td>
    <td>${item[2]}</td>
  </tr>
  <tr>
  	<td>-----------------------</td>
	<td>-------------------------------------</td>
  </tr>
  </c:forEach>
</table><p>&nbsp;</p></td>
  </tr>
</table>
</body>
</html>
