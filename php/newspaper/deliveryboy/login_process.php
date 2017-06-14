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
// File Name: login_process.php
//
// Purpose: Processing logic for login process.
//
///////////////////////////////////////////////////

$username = $_POST['txtUsername'];
$password = md5( $_POST['txtPassword'] ) ;

$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
$sqlDb = mysql_select_db('azri') or die("Can select db");
$sqlQuery = "SELECT * FROM deliveryboy WHERE username = '$username' AND password = '$password' ";

$sqlResult = mysql_query($sqlQuery) or die("Can't make query");
$worked = mysql_fetch_array($sqlResult);

$error = <<< ERRORSTART

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Delivery Boy: Unauthorized</title>
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

if (!$worked)
{
	echo $error;	

}

	else
	{
			session_start();
			$_SESSION['deliveryboy_username'] = $worked['username'];
			$_SESSION['deliveryboy_id'] = $worked['id'];			
			header("Location: main.php");
	}
	
?>	