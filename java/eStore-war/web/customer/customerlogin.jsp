<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore - Customer Login</title>
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="images/header.jpg" width="935" height="98"></div></td>
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
      <p><font size="2"> 
      <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/">Back to previous page </a></font></font></p>
    </td>
    <td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Customer Login </strong></font> <br>
      <br>
      <form action="/eStore-Web/CustomerLogin" method="POST">
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
