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
// File Name: editnewsagent_process.php
//
// Purpose: Processing logic for editing newsagent
// information.
//
///////////////////////////////////////////////////

$username = $_POST['txtUsername'];
$password = $_POST['txtPassword'];
$companyName = $_POST['txtCompanyName'];
$registrationNumber = $_POST['txtRegistrationNumber'];
$address = $_POST['txtAddress'];
$state = $_POST['txtState'];
$town = $_POST['txtTown'];
$postcode = $_POST['txtPostcode'];
$name = $_POST['txtName'];
$telephone = $_POST['txtTelephone'];
$fax = $_POST['txtFax'];
$email = $_POST['txtEmail'];
$newsagentId = $_POST['txtNewsagentId'];


$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");

$sqlDb = mysql_select_db('azri') or die("Can't select database");


	$sqlQueryPassword = "SELECT password FROM newsagent WHERE username = '$username'";
	$sqlResultPassword =  mysql_query($sqlQueryPassword) or die("Can't Make query");
	$sqlValuesPassword = mysql_fetch_array($sqlResultPassword);
	
	if ($sqlValuesPassword['password'] != $password)
	{
		$password = md5($password);
	}


$sqlQuery = "UPDATE newsagent SET username = '$username', fax = '$fax', password = '$password', company_name = '$companyName', registration_number = '$registrationNumber', address = '$address', state = '$state', town = '$town', postcode = '$postcode', telephone = '$telephone', email = '$email', name = '$name' WHERE id = '$newsagentId' ";


$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

$confirmEdit = <<< CONFIRMEDIT

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer: Edit Confirmation</title>
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
          <p>Your personal details has been updated.</b><br><br> Click <a href="main.php">here</a> to go back to the main menu.</p>		
		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>
CONFIRMEDIT;

if ($sqlResult)
{
	echo $confirmEdit;
}

?>