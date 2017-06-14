<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore -Your Personal Details</title>
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
      <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/LogOut/Customer">Log-Out</a></font></p>
      <p>&nbsp;</p></td>
    <td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Your Personal Details</strong></font><br>
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
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<font size="4"><br>
      &nbsp;&nbsp;<strong>Your shipping address:</strong></font> <br>
      </font></p>      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Address:</strong> ${requestScope.customer[13]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>City:</strong> ${requestScope.customer[14]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;<strong>&nbsp;State:</strong> ${requestScope.customer[15]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Zip Code:</strong> ${requestScope.customer[16]}</font></p>
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Country:</strong> ${requestScope.customer[17]}</font></p>
    <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;&nbsp;<strong>Receiver Name:</strong> ${requestScope.customer[18]}</font></p>
    <p>&nbsp;</p></td>
  </tr>
</table>
</body>
</html>
