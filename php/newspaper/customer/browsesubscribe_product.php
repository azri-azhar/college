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
// File Name: browsesubscribe_product.php
//
// Purpose: Display products for subscription and
// browsing to the customer. 
//
///////////////////////////////////////////////////


$error = <<< ERRORSTART

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer: Unauthorized</title>
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


$chooseError = <<< CHOOSEERRORSTART

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer: Error</title>
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
          <p>Please select your newsagent first.</b><br><br> Click <a href="main.php">here</a> to go back to the main menu.</p>
		
		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>
CHOOSEERRORSTART;

	$header = <<< STARTHEADER
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<title>Customer: Browse or Subscribe Products</title>
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
	    <p>These are the product that are availabe for subscription. Click Subscribe to subscribe.</p>
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
			
			$customer_username = $_SESSION['customer_username'];
			
			$sqlQuery = "SELECT newsagent_id FROM customer WHERE username = '$customer_username' " ;
			
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			$sqlValues = mysql_fetch_array($sqlResult);
			
			
		
				if ( ($sqlValues['newsagent_id'] > 0) )
				{
				
						$newsagentId = $sqlValues['newsagent_id'];
						
						$sqlQuery = "SELECT id, name, type, price FROM product WHERE newsagent_id = $newsagentId ";
			
						$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
						
						$columnCount = mysql_num_fields($sqlResult);
						
					echo $header;
					
					echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
					echo "<br>";
					echo "<tr>";
						echo "<td>Product Name</td>";
						echo "<td>Product Type</td>";
						echo "<td>Product Price</td>";
						echo "<td>Subscribe</td>";
						
						while($sqlValues = mysql_fetch_array($sqlResult))
						{
							echo "<tr>";
							
								for($column = 3; $column < $columnCount; $column++)
								{
									echo "<td>$sqlValues[1]</td>\n";
									echo "<td>$sqlValues[2]</td>\n";
									echo "<td>RM ". "$sqlValues[3]</td>\n";
		
									echo "<td> <a href=\"subscribe_product.php?productid=";
									echo "$sqlValues[0]\"";
									echo ">Subscribe</a>";
								
								}
							echo "</tr>";
						}
					
						echo "</table>";
						
						echo $footer;

					}
					
					else 
					{
							echo $chooseError;
									
									
					}
}			

?>