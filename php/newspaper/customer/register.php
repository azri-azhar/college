<?php

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
// File Name: register.php
//
// Purpose: Display forms for customer  registration. 
//
///////////////////////////////////////////////////

$header = <<< STARTHEAD

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Subscriber: Register</title>
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
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Please make sure everything is correct. Continue to register?");
						if (agree)
							return true ;
						else
							return false ;
						}
						// -->
					</script>
	
					
		<p><b>Subscriber registration.</b></p>
		<form name="formRegister" method="post" action="register_process.php" />
	
		<table>
		
			<tr>
				<td>Username</td>
				<td><input  type="text" name="txtUsername" /></td>
			</tr>
			
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtPassword" /></td>
			</tr>
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="txtConfirmPassword" />
			</tr>			
			
			<tr>
				<td>Full Name </td>
				<td><input type="text" name="txtName" />
			</tr>
			
			
			<tr>
				<td>IC Number </td>
				<td><input type="text" name="txtIc" />
			<tr>
			
			
			<tr>
				<td>Address</td>
				<td><input type="text" name="txtAddress" />
			</td>
			
			
			<tr>
				<td>State</td>
				<td><input type="text" name="txtState" /></td>
			</tr>
			
			
			<tr>
				<td>Town</td>
				<td><input type="text" name="txtTown" /></td>
			
			</tr>

			
			<tr>
				<td>Postcode</td>
				<td><input type="text" name="txtPostcode" /></td>
			</tr>
			
			<tr>
				<td>Telephone</td>
				<td><input type="text" name="txtTelephone" /></td>	
			</tr>
			
			
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="txtEmail" /></td>
			</td>

			
			<tr>
				<td>
				<br />
				<input type="submit" name="btnRegister" value="Submit"  onClick="return confirmSubmit()"/>
				<input type="reset" name="btnReset" value="Reset" />
				</td>
			</tr>
				
		</table>
		
STARTBODY;

$footer = <<< STARTFOOTER

		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
</div>
</body>
</html>
STARTFOOTER;

echo $header;
echo $body;
echo $footer;
?>