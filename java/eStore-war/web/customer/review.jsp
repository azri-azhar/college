<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Add Product Review</title>
		<script type="text/javascript">
			function validateForm(form) {
				if (isNaN(form.elements.rating.value)) {
					alert("Invalid rating. Only numbers are allowed");
					return false;						
				}  else if (form.elements.review.value == "") {
					alert("Please enter the review");
					return false;			
				}  else if (form.elements.rating.value == "") {
					alert("Please enter the rating");
					return false;
				}
				return true;
			}
		</script>		
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
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Add Product Review </strong></font> <br>
      <br>
      <form onsubmit="return validateForm(this)" action="/eStore-Web/AddReview/Add" method="POST">
        <table border="0" cellpadding="10">
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Review:</font></strong></td>
            <td><textarea name="review" cols="50" rows="5"></textarea></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Rating:</font></strong></td>
            <td><input type="text" name="rating" value="" /> 
              <strong>out of 10</strong> </td>
          </tr>
          <tr>
            <td><br>
                <input name="submit" type="submit" value="Submit" />
                <input name="reset" type="reset" value="Reset" /></td>
            <td></td>
          </tr>
          <tr>
            <td>
              <input type="hidden" name="productid" value="${param.productid}" />
              <input type="hidden" name="customerid" value="${param.customerid}" />
            </td>
          </tr>
        </table>
    </form></td>
  </tr>
</table>
</body>
</html>
