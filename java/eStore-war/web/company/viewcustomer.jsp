<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Your Customer Details</title>
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="/eStore-Web/company/images/header.jpg" width="935" height="98"></div></td>
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
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/LogOut/Company">Log-Out</a></font></p></td>
    <td width="76%" valign="baseline" bgcolor="#FFFFFF"><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Your Customer Details </strong></font><br>
      <br>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Username:</strong> ${requestScope.customer[1]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Password:</strong> ${requestScope.customer[2]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>First Name:</strong> ${requestScope.customer[3]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Last Name:</strong> ${requestScope.customer[4]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>IC Number:</strong> ${requestScope.customer[5]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Email:</strong> ${requestScope.customer[6]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Phone Number:</strong> ${requestScope.customer[7]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Address:</strong> ${requestScope.customer[8]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>City:</strong> ${requestScope.customer[9]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>State:</strong> ${requestScope.customer[10]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Zip Code:</strong> ${requestScope.customer[11]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Country:</strong> ${requestScope.customer[12]}</font></p>
	  <br>
	  <br>
      <p><font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;&nbsp;Shipping Information<br>
        <br>
        <br>
      </strong></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp; <strong>Address:</strong> ${requestScope.customer[13]}</font></p>      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>City:</strong> ${requestScope.customer[14]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>State:</strong> ${requestScope.customer[15]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Zip Code:</strong> ${requestScope.customer[16]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Country:</strong> ${requestScope.customer[17]}</font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Receiver Name:</strong> ${requestScope.customer[18]}</font></p></td>
  </tr>
</table>
</body>
</html>
