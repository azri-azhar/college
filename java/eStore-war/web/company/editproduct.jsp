<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Edit Product Information</title>
		<script type="text/javascript">
			function validateForm(form) {
				for (var i = 0; i < form.elements.length; i++) {
					if (form.elements[i].value == "") {					
						alert("Please fill out ALL fields");
						return false;
					} else if (isNaN(form.elements.price.value)) {
						alert("Invalid price. Only numbers are allowed");
						return false;
					} else if (isNaN(form.elements.quantity.value)) {
						alert("Invalid quantity. Only numbers are allowed");
						return false;
					} else if (isNaN(form.elements.weight.value)) {
						alert("Invalid weight. Only numbers are allowed");
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
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Edit Product Information </strong></font><br>
      <br>
      <form onsubmit="return validateForm(this)" action="/eStore-Web/UpdateProduct/Edit" method="POST">
        <table border="0" cellpadding="10">
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Product Name:</font></strong></td>
            <td><input type="text" name="name" value="${requestScope.product[0][1]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Price (RM):</font></strong></td>
            <td><input type="text" name="price" value="${requestScope.product[0][2]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity:</font></strong></td>
            <td><input type="text" name="quantity" value="${requestScope.product[0][3]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Weight (g):</font></strong></td>
            <td><input type="text" name="weight" value="${requestScope.product[0][4]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Dimension:</font></strong></td>
            <td><input type="text" name="dimension" value="${requestScope.product[0][5]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Brand:</font></strong></td>
            <td><input type="text" name="brand" value="${requestScope.product[0][6]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Technical Details:</font></strong></td>
            <td><input type="text" name="details" value="${requestScope.product[0][7]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Description:</font></strong></td>
            <td><input type="text" name="description" value="${requestScope.product[0][8]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Image Location:</font></strong></td>
            <td><input type="text" name="image" value="${requestScope.product[0][9]}" /></td>
            <td><input type="hidden" name="productid" value="${requestScope.product[0][0]}" /></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Category:</font></strong></td>
            <td>
              <select name="categoryId">
                <c:forEach var="item" items="${requestScope.category}">
                <option value=${item[0]}>${item[1]}</option>
                </c:forEach>
              </select>
            </td>
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
