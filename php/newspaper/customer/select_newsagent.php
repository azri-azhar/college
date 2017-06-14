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
// File Name: select_newsagent.php
//
// Purpose: Display page for customer's choosing
// and selecting their newsagent. 
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

	$header = <<< STARTHEADER
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<title>Customer: Edit Subscription</title>
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
		<p>Please select the newsagent company you want to subscribe from. Choose the one that is on you area to avoid late deliveries.</p>
STARTHEADER;

		$footer = <<< STARTFOOTER
		
	   <br>
	      <p>Click <a href="main.php">here</a> to go back to the main menu.</p>
	      <br>
	   </div>
	  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
	</div>
	</body>
	</html>
STARTFOOTER;

if ( ($_SESSION['customer_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else
{				
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('azri') or die("Can't select database");
			
				$sqlQuery = "SELECT id, company_name, registration_number, address, town, state, postcode, telephone, fax, email FROM newsagent";
	
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				
				$columnCount = mysql_num_fields($sqlResult);
				
			echo $header;
			
			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";			
			
			
					echo "<tr>";
						echo "<td>	Newsagent Name</td>";
						echo "<td>Reg. Number</td>";
						echo "<td>Address</td>";
						echo "<td>Town</td>";
						echo "<td>State</td>";
						echo "<td>Postcode</td>";
						echo "<td>Telephone</td>";
						echo "<td>Fax</td>";
						echo "<td>E-Mail</td>";
						echo "<td>Select</td>";
						
					echo "</tr>";
					
				
				while($sqlValues = mysql_fetch_array($sqlResult))
				{
					echo "<tr>";
					
						for($column = 9; $column < $columnCount; $column++)
						{
							echo "<td>$sqlValues[1]</td>\n";
							echo "<td>$sqlValues[2]</td>\n";
							echo "<td>$sqlValues[3]</td>\n";
							echo "<td>$sqlValues[4]</td>\n";
							echo "<td>$sqlValues[5]</td>\n";
							echo "<td>$sqlValues[6]</td>\n";
							echo "<td>$sqlValues[7]</td>\n";
							echo "<td>$sqlValues[8]</td>\n";
							echo "<td>$sqlValues[9]</td>\n";

							echo "<td> <a href=\"selectnewsagent_process.php?newsagentid=";
							echo "$sqlValues[0]\"";
							echo ">Select</a>";
						
						}
					echo "</tr>";
				}
			
				echo "</table>";
				
				echo $footer;

}

?>