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
// File Name: edit_newsagent.php
//
// Purpose: Display page for editing newsagent information.
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

	$header = <<< STARTHEADER
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<title>Newsagent: Change Personal Detail</title>
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
	    <p>You can change or update your personal details here. Click Submit when you're done or Reset to start over.</p>	
STARTHEADER;

	$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Please make sure everything is correct. If you changed your password, please remember the new password. Continue?");
						if (agree)
							return true ;
						else
							return false ;
						}
						// -->
					</script>
STARTJAVA;



$footer = <<< STARTFOOTER
  </div>
  <br>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
</div>
</body>
</html>
STARTFOOTER;

if ( ($_SESSION['newsagent_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else
{
	
	$username = $_SESSION['newsagent_username'];
	
	$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
	$sqlDb = mysql_select_db('azri') or die("Can't select database");

	$sqlQuery = "SELECT * FROM newsagent WHERE username = '$username'";
	$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
	
	
	$sqlValues = mysql_fetch_array($sqlResult);
	
	$user = $sqlValues['username'];
	$password = $sqlValues['password'];
	$companyName = $sqlValues['company_name'];
	$registrationNumber = $sqlValues['registration_number'];
	$address = $sqlValues['address'];
	$state = $sqlValues['state'];
	$town = $sqlValues['town'];
	$postcode = $sqlValues['postcode'];
	$name = $sqlValues['name'];
	$telephone = $sqlValues['telephone'];
	$fax = $sqlValues['fax'];
	$email = $sqlValues['email'];
	$newsagentId = $sqlValues['id'];

	$display_page = <<< PAGE

	<html>
	
	<body>	
	
	<form name="formRegister" method="post" action="editnewsagent_process.php" />
	
		<table>
		
			<tr>
				<td>Username</td>
				<td><input type="text" name="txtUsername" value="$user" /></td>
			</tr>
			
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtPassword" value="$password"/></td>
			</tr>
			
			
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="txtConfirmPassword" value="$password"/>
			</tr>
			
			
			<tr>
				<td>Company Name</td>
				<td><input type="text" name="txtCompanyName" value="$companyName"/>
			<tr>
			
			
			<tr>
				<td>Registration Number</td>
				<td><input type="text" name="txtRegistrationNumber" value="$registrationNumber"/>
			</td>
			
			
			<tr>
				<td>Address</td>
				<td><input type="text" name="txtAddress" value="$address"/></td>
			</tr>
			
			
			<tr>
				<td>Town</td>
				<td><input type="text" name="txtTown" value="$town"/></td>
			
			</tr>

			
			<tr>
				<td>State</td>
				<td><input type="text" name="txtState" value="$state"/></td>
			</tr>
			
			<tr>
				<td>Postcode</td>
				<td><input type="text" name="txtPostcode" value="$postcode"/></td>	
			</tr>
			
			
			<tr>
				<td>Contact Name</td>
				<td><input type="text" name="txtName" value="$name"/></td>
			</td>
			
			
			<tr>
				<td>Telephone</td>
				<td><input type="text" name="txtTelephone" value="$telephone"/></td>
			</tr>
			
			
			<tr>
				<td>Fax Number</td>
				<td><input type="text" name="txtFax" value="$fax"/></td>
			<tr>
			
			
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="txtEmail" value="$email"/></td>
			</tr>
			
			<td><input type="hidden" name="txtNewsagentId" value="$newsagentId"/></td>
			
			<tr>
				<td>
				<br />
				<input type="submit" name="btnRegister" value="Submit"  onClick="return confirmSubmit()"/>
				<input type="reset" name="btnReset" value="Reset" />
				</td>
			</tr>
				
		</table>
		
	</form>
	
	</body>	
	
	</html>
PAGE;

echo $header;
echo $javascript;
echo $display_page;
echo $footer;

}

?>