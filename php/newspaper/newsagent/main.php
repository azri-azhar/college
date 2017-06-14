<?php

session_start();

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
// File Name: main.php
//
// Purpose: Display main menu for newsagent.
//
///////////////////////////////////////////////////

$menu = <<< STARTMENU

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Newsagent: Main Menu</title>
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
    <p><b>Newsagent Main Menu</b></p>
  </div>
  <table width="100%"  border="0">
    <tr align="left">
      <td width="27%"><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="edit_newsagent.php">Edit Company Information </a> </td>
      <td width="73%">Edit your company information such as address, telephone number and etc. </td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="delivery_boy.php">Delivery Boy Information </a> </td>
      <td>Assign task, add and remove your delivery boy information.</td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="product.php">Add or Remove Product </a> </td>
      <td>Add or remove product for your customers' subscription. </td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="pay.php">Billing Informtion </a> </td>
      <td>Manage bills and payment of you customers. </td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="customer.php">Customer Information </a> </td>
      <td>View your customers information.</td>
    </tr>
  </table>
  <br>
  <div align="left"><a href="../index.php">Back to Home</a></div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
</div>
</body>
</html>
STARTMENU;

$error = <<< ERRORSTART

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Newsagent: Unauthorized</title>
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
          <p>Unauthorized. Please check your username and password.</b><br><br> Click <a href="javascript: history.go(-1)">here</a> to go the previous page.</p>

		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
</div>
</body>
</html>
ERRORSTART;


if ( ($_SESSION['newsagent_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { ?>

<?php echo $menu ?>

<?php } ?>