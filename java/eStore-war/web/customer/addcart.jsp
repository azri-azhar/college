<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Shopping Cart</title>
		<script type="text/javascript">
			function validateForm(form) {
				if (isNaN(form.elements.quantity.value)) {
					alert("Invalid quantity. Only numbers are allowed");
					return false;						
				}  else if (form.elements.quantity.value == "") {
					alert("Please enter the quantity");
					return false;			
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
        </font></a></font><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/customer/main.jsp">Home</a></font></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewProduct">Browse Product</a></font></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCategory/Customer">Browse Product By Category</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/View">View Your Shopping Cart</a></font></p>
        <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/CustomerViewOrder">View Your Order Status</a></font></p>
        <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/UpdateCustomer/EditForm">Edit Your Personal Details</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCustomer/Customer">View Your Personal Details</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewPostage/CustomerAll">View Postage Rate</a></font></p>
        <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/LogOut/Customer">Log-Out</a></font></p></td><td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Add to Shopping Cart</strong></font> <br>
      <br>      <form onsubmit="return validateForm(this)" action="/eStore-Web/ShoppingCart/Save" method="POST">
<table border="0" cellpadding="10">
                <tr>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Product Name:</strong></font></td>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.product[0][1]}</font></td>
            </tr>      
                <tr>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Product Price:</strong></font></td>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">RM ${requestScope.product[0][2]}</font></td>
            </tr>
                <tr>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Quantity:</strong></font></td>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                    <input type="text" name="quantity" value="1" />
                    </font></td>
                    <input type="hidden" name="productid" value="${requestScope.product[0][0]}" />
                    <input type="hidden" name="price" value="${requestScope.product[0][2]}" />
                    <input type="hidden" name="weight" value="${requestScope.product[0][4]}" />                    
                </tr>
                <tr>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Shipping Option:</strong></font></td>
                    <td>
                        <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
                        <select name="postageid">
                            <c:forEach var="item" items="${requestScope.postage}">
                                <option value=${item[0]}>${item[1]}</option>
                            </c:forEach>
                        </select>
                        </font></td>
            </tr>
                <tr>
                    <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><br>
                    <input type="submit" value="Add to Cart" />
                    <input type="reset" value="Reset" />
                    </font></td>
                    <td><font size="2">&nbsp;</font></td>
            </tr>
        </table>
        </form></td>
  </tr>
</table>
</body>
</html>
