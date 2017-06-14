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
// File Name: register_process.php
//
// Purpose: Processing logic for customer registration. 
//
///////////////////////////////////////////////////

$username = $_POST['txtUsername'];
$password = $_POST['txtPassword'];
$name = $_POST['txtName'];
$ic = $_POST['txtIc'];
$address = $_POST['txtAddress'];
$state = $_POST['txtState'];
$town = $_POST['txtTown'];
$postcode = $_POST['txtPostcode'];
$telephone = $_POST['txtTelephone'];
$email = $_POST['txtEmail'];

$password = md5($password);

$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");

$sqlDb = mysql_select_db('azri') or die("Can't select database");

$sqlQuery = "INSERT INTO customer(username, password, name, ".
			"ic, address, state, town, postcode, telephone, email)".
			" values('$username', '$password', '$name', '$ic', ".
			"'$address', '$state', '$town', '$postcode', '$telephone', '$email')";

$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

$registerComplete = <<< REGISTER

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Subscriber: Registration Complete</title>
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
        <td><b>
          <p>Subscriber Registration Complete.</b><br><br> Click <a href="login.php">here</a> to log-in.</p>

		
		
		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>
REGISTER;

if ($sqlResult)
{
	echo $registerComplete;
}

?>