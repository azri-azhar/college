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
// File Name: customer.php
//
// Purpose: Display customer information.
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
	<title>Newsagent: Customers Information</title>
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
	    <p>These are the customers who subcribe to you products.</p>	
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

else
{				
				
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");	
			
			$newsagentId = $_SESSION['newsagent_id'];
			
			$sqlQuery = "SELECT orderlist.id, orderlist.product_id, orderlist.customer_id, orderlist.quantity, product.name, product.type, product.price, customer.name, customer.address, customer.town, customer.state, customer.postcode, customer.telephone, deliveryboy.username FROM orderlist, product, customer, deliveryboy WHERE (orderlist.product_id = product.id) AND (orderlist.deliveryboy_id = deliveryboy.id) AND (product.newsagent_id = $newsagentId) AND (orderlist.customer_id = customer.id)" ;
			
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			
			$columnCount = mysql_num_fields($sqlResult);
			


			
			$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Please make sure everything is correct. Continue assigning?");
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
					
					echo '<form name="formAssign" method="post" action="assigndelivery_process.php">';
					
					echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
					echo "<br>";
					
					echo "<tr>";
						echo "<td>Product Name</td>";
						echo "<td>Quantity</td>";
						echo "<td>Type</td>";
						echo "<td>Price</td>";	
						echo "<td>Customer Name</td>";			
						echo "<td>Address</td>";	
						echo "<td>Town</td>";	
						echo "<td>State</td>";																			
						echo "<td>Postcode</td>";	
						echo "<td>Telephone</td>";	
						echo "<td>Delivery Boy</td>";					
					echo "</tr>";
						
						while($sqlValues = mysql_fetch_array($sqlResult))
						{
							echo "<tr>";
							
								for($column = 13; $column < $columnCount; $column++)
								{
								//	echo "<td>$sqlValues[0]</td>\n";
								//	echo "<td>$sqlValues[1]</td>\n";									
								//	echo "<td>$sqlValues[2]</td>\n";
								
									echo "<td>$sqlValues[4]</td>\n";
									echo "<td>$sqlValues[3]</td>\n";									
									echo "<td>$sqlValues[5]</td>\n";
									echo "<td>RM $sqlValues[6]</td>\n";
									echo "<td>$sqlValues[7]</td>\n";
									echo "<td>$sqlValues[8]</td>\n";
									echo "<td>$sqlValues[9]</td>\n";																					
									echo "<td>$sqlValues[10]</td>\n";			
									echo "<td>$sqlValues[11]</td>\n";
									echo "<td>$sqlValues[12]</td>\n";		
									echo "<td>$sqlValues[13]</td>\n";		
								}
								
							echo "</tr>";
						}
					
						echo "</table>";	
											

						
						echo "</form>";
						echo $footer;
}			

?>
