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
// File Name: bill.php
//
// Purpose: Display bills for customer
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

	$header = <<< STARTHEADER
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<title>Customer: Bill</title>
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
			
			$customerId = $_SESSION['customer_id'];
			
			$sqlQuery = 'SELECT orderlist.product_id, orderlist.quantity, product.name, product.price, customer.price, customer.recieve, customer.paid'
        . ' FROM orderlist, product, customer'
        . ' WHERE orderlist.customer_id = ' . $customerId . ' AND orderlist.product_id = product.id AND customer.id = ' . $customerId . '';
			
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			$columnCount =  mysql_num_fields($sqlResult);
			
					echo $header;
								
					echo "<p>These are the newspapers that you subscribed daily.</p>";
					
					echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
					echo "<br>";
					echo "<tr>";
						echo "<td>Product Name</td>";
						echo "<td>Quantity</td>";
						echo "<td>Product Price</td>";
						
					echo "</tr>";
						
						while($sqlValues = mysql_fetch_array($sqlResult))
						{
							echo "<tr>";
							
								for($column = 6; $column < $columnCount; $column++)
								{
									echo "<td>$sqlValues[2]</td>\n";
									echo "<td>$sqlValues[1]</td>\n";
									echo "<td>RM ". "$sqlValues[3]</td>\n";
									
									$totalPrice = $sqlValues[4];
									$totalPaid = $sqlValues[6];
									$totalRecieve = $sqlValues[5];
								
								}
							echo "</tr>";
						}
					
						echo "</table>";

						echo "<p>Total newspaper recieved: <b>$totalRecieve</b></p>";
						echo "<p>Total price that you have to pay (account balance): <b>RM $totalPrice</b></p>";
						echo "<p>You have paid: <b>RM $totalPaid</b></p>";						
						
						echo $footer;
					
}			

?>