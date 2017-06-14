<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Edit Your Personal Details</title>
		<script type="text/javascript">
			function validateForm(form) {
				for (var i = 0; i < form.elements.length; i++) {
					if (form.elements[i].value == "") {					
						alert("Please fill out ALL fields");
						return false;
					} else if (isNaN(form.elements.zip.value)) {
						alert("Invalid zip code. Only numbers are allowed");
						return false;						
					} else if (isNaN(form.elements.phone.value)) {
						alert("Invalid phone number. Only numbers are allowed");
						return false;						
					} else if ( (form.elements.email.value.indexOf("@")) < 1 ) {
						alert("Invalid email address. Please try again");
						return false;
					} else if ( form.elements.password.value.length < 4 ) {
						alert("Password must be at least 4 characters long. Please try again");
						return false;
					} else if (isNaN(form.elements.shippingzip.value)) {
						alert("Invalid shipping zip code. Only numbers are allowed");
						return false;						
					}
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
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Edit Your Personal Details </strong></font> <br>
      <br>
      <form  onsubmit="return validateForm(this)" action="/eStore-Web/UpdateCustomer/Edit" method="POST">
        <table border="0" cellpadding="10">
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Username:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.customer[1]}</font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Password:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="password" name="password" value="${requestScope.customer[2]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">First Name:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="firstname" value="${requestScope.customer[3]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Last Name:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="lastname" value="${requestScope.customer[4]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">IC or Passport:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="ic" value="${requestScope.customer[5]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Email:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="email" value="${requestScope.customer[6]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Phone Number:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="phone" value="${requestScope.customer[7]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Address:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="address" value="${requestScope.customer[8]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">City:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="city" value="${requestScope.customer[9]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">State:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="state" value="${requestScope.customer[10]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Zip Code:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="zip" value="${requestScope.customer[11]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Country:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="country" value="${requestScope.customer[12]}" />
            </font></td>
          </tr>
          <tr>
            <td><p>            <font size="4" face="Verdana, Arial, Helvetica, sans-serif"><br>
              <strong>Shipping Address </strong><br>
              <br> 
            </font></p>            </td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Address:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingaddress" value="${requestScope.customer[13]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">City:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingcity" value="${requestScope.customer[14]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">State:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingstate" value="${requestScope.customer[15]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Zip Code:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingzip" value="${requestScope.customer[16]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Country:</font></strong></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingcountry" value="${requestScope.customer[17]}" />
            </font></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Receiver Name:</font></strong></td>
            <td>
              <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="shippingname" value="${requestScope.customer[18]}" />
              <input type="hidden" name="customerid" value="${requestScope.customer[0]}" />
              </font></td>
          </tr>
          <tr>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><br>
              <input name="submit" type="submit" value="Submit" />
                <input name="reset" type="reset" value="Reset" />
            </font></td>
            <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;</font></td>
          </tr>
        </table>
    </form></td>
  </tr>
</table>
</body>
</html>
