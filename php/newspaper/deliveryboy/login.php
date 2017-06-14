<?PHP

///////////////////////////////////////////////////
//
// Programmed By: Mohamad Azri Bin Azhar
//
// Ideas By: Zuwairiie, Tan Yew Boon, Nur Fadzilah
//
// Copyrights: You may use, modify and distribute
// this code, as long as this notice remains intact.
//
// Last Modified: August 30 2004
// File Name: login.php
//
// Purpose: Display login page for delivery boy.
//
///////////////////////////////////////////////////

$header = <<< STARTHEAD

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Delivery Boy: Log-in</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body bgcolor="#663300" background="../images/bg.gif" text="#FFCC99" link="#FF6600" vlink="#666699" alink="#FF3300">
<div align="center">
  <table width="100%"  border="0">
    <tr>
      <td><div align="center"><img src="../images/header.jpg" width="636" height="80"></div></td>
    </tr>
  </table>
  <div align="left"><br>
    <br>
    <br>
    <img src="../images/div2.jpg" width="400" height="17"><br>
    <br>
    <table width="100%"  border="0">
      <tr>
        <td>
STARTHEAD;

$body = <<< STARTBODY

		<p><B>Delivery Boy Log-in.</B> If you don't have an account, please contact your supervisor.</p>
		
		<form name="formLogin" method="post" action="login_process.php">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="txtUsername" />
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtPassword" />
				</tr>
				
				<tr>
					<td>
						<br />
						<input type="submit" name="btnLogin" value="Login" />
					</td>
			</table>
STARTBODY;
	
$footer = <<< STARTFOOTER

		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>
STARTFOOTER;

echo $header;
echo $body;
echo $footer;
?>