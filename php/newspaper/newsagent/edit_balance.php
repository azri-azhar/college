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
// File Name: edit_balance.php
//
// Purpose: Display page for editing customer's balance.
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
	<title>Newsagent: Edit Balance</title>
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
	    <p>When your customer make a payment, enter the ammount recieved and click Paid. The customer balance will be updated automatically.</p>	
STARTHEADER;


$footer = <<< STARTFOOTER
<br>
    <p>Click <a href="main.php">here</a> to go back to the main menu.</p>
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

else { ?>


<?php

$customerId = $_GET['customerId'];

$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
$sqlDb = mysql_select_db('azri') or die("Can't select database");
	
$sqlQuery = "SELECT name, price FROM customer WHERE id = $customerId" ;
			
$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

$sqlValues = mysql_fetch_array($sqlResult);

			$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Please make sure everything is correct. Continue?");
						if (agree)
							return true ;
						else
							return false ;
						}
						// -->
					</script>
STARTJAVA;

					echo $header;
					echo $javascript;
					
					echo '<form name="formAssign" method="post" action="editbalance_process.php">';
					
					echo "<p>Customer Name: $sqlValues[0]</p>";
					echo "<p>Account Balance: <b>RM $sqlValues[1]</b></p>";
					
					echo '<p>Ammount Receive: <b>RM </b> <input type="text" name="txtPaid"></input></p>';
					
					echo "<input type='hidden' name = 'txtCustomerId' value = $customerId>";
					
					echo "<input type='hidden' name = 'txtBalance' value = $sqlValues[1]>";
					
					echo '<input type="submit" name="btnLogin" value="Paid" onClick="return confirmSubmit()" />';				
					
					echo $footer;
?>					

<?php } ?>