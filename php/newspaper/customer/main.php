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
// Purpose: Main customer's menu page. 
//
///////////////////////////////////////////////////


$error = <<< ERRORSTART

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Subscriber: Unauthorized</title>
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
<title>Subscriber: Main Menu</title>
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
    <p><b>Subscriber Main Menu</b></p>
  </div>
  <table width="100%"  border="0">
    <tr align="left">
      <td width="27%"><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="select_newsagent.php">Select and Search Newsagent</a></td>
      <td width="73%">Locate and select newsagent near you.</td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="browsesubscribe_product.php">Browse and Subscribe Product</a></td>
      <td>Browse and subscribe products that are being offered by the newsagent.</td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="edit_subscription.php">Change or Edit Subscription</a></td>
      <td>Change or edit your subscription if you're away on holiday, business or you are no logger wish to subscribe. </td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="edit_customer.php">Change or Edit Your Personal Details</a></td>
      <td>Change or edit your personal details such as address, phone number, password and etc. </td>
    </tr>
    <tr align="left">
      <td><img src="../images/bullet.gif" width="10" height="12">&nbsp;<a href="bill.php">View Bill</a></td>
      <td>View your current bill and payment. This is updated daily. </td>
        
    </tr>
    
  </table>
  <br>
  <div align="left"><a href="../index.php">Back to Home</a></div>
  <br>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>

STARTMENU;

if ( ($_SESSION['customer_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { ?>

<?php echo $menu; ?>

<?php } ?>