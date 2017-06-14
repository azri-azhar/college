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
// File Name: delivery_boy.php
//
// Purpose: Main menu for delivery_boy related process.
//
///////////////////////////////////////////////////

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
  <p>&nbsp;</p>
</div>
</body>
</html>
ERRORSTART;

$menu = <<< STARTMENU

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Newsagent: Delivery Boy</title>
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
    <br>
  </div>
  <table width="100%"  border="0">
    <tr align="left">
      <td width="27%"><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="add_deliveryboy.php">Add Or Remove Delivery Boy </a> </td>
      <td width="73%">Add all your delivery boy here so you can assign task to them. You can remove them when they're not available.</td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="assign_deliveryboy.php">Assign Task To Delivery Boy</a> </td>
      <td>Assign which task or order needs to be send by which delivery boy.</td>
    </tr>
  </table>
  <br>
     <p align = "left">Click <a href="main.php">here</a> to go back to the main menu.</p>
     <br>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
</div>
</body>
</html>
STARTMENU;

if ( ($_SESSION['newsagent_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { ?>

<?php echo $menu ?>

<?php } ?>