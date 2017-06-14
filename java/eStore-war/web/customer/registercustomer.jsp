<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - New Customer Registration</title>
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
					} else if ( form.elements.username.value.length < 4 ) {
						alert("Username must be at least 4 characters long. Please try again");
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
        </font></a><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="javascript: history.go(-1)">Back to previous page</a></font></font></p>
    </td><td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>      
    &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;New Customer Registration</strong> </font><br>
      <br>      
      <form onsubmit="return validateForm(this)" action="/eStore-Web/RegisterCustomer" method="POST">
        <table border="0" cellpadding="10">
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Username:</font></strong></td>
            <td><input type="text" name="username" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Password:</font></strong></td>
            <td><input type="password" name="password" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">First Name:</font></strong></td>
            <td><input type="text" name="firstname" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Last Name:</font></strong></td>
            <td><input type="text" name="lastname" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">IC or Passport:</font></strong></td>
            <td><input type="text" name="ic" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Email:</font></strong></td>
            <td><input type="text" name="email" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Phone Number:</font></strong></td>
            <td><input type="text" name="phone" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Address:</font></strong></td>
            <td><input type="text" name="address" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">City:</font></strong></td>
            <td><input type="text" name="city" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">State:</font></strong></td>
            <td><input type="text" name="state" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Zip Code:</font></strong></td>
            <td><input type="text" name="zip" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Country:</font></strong></td>
            <td><input type="text" name="country" value="" /></td>
          </tr>
          <tr>
            <td><font size="4" face="Verdana, Arial, Helvetica, sans-serif"><br>
                <strong>    Shipping address</strong><br>
            <br>
            </font></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Address:</font></strong></td>
            <td><input type="text" name="shippingaddress" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">City:</font></strong></td>
            <td><input type="text" name="shippingcity" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">State:</font></strong></td>
            <td><input type="text" name="shippingstate" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Zip Code:</font></strong></td>
            <td><input type="text" name="shippingzip" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Country:</font></strong></td>
            <td><input type="text" name="shippingcountry" value="" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Receiver Name:</font></strong></td>
            <td><input type="text" name="shippingname" value="" /></td>
          </tr>
          <tr>
            <td><br>
                <input name="submit" type="submit" value="Submit" />
                <input name="reset" type="reset" value="Reset" /></td>
            <td></td>
          </tr>
        </table>
      </form></td>
  </tr>
</table>
</body>
</html>
