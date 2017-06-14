<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>${requestScope.forwardedTitle}</title>
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
    </td><td width="77%" valign="baseline" bgcolor="#FFFFFF"><p><br>      
    &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;${requestScope.forwardedHeader}</strong></font><br>
</p>
      <table width="100%"  border="0" cellspacing="0" cellpadding="10">
        <tr>
          <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">${requestScope.forwardedMessage}</font></td>
        </tr>
      </table>      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif"></font></p></td>
  </tr>
</table>
</body>
</html>
