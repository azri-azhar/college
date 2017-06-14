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
// File Name: main_process.php
//
// Purpose: Processing logic for main menu for
// delivery boy.
//
///////////////////////////////////////////////////

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



$confirmDelivery = <<< CONFIRMDELIVERY

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Delivery Boy: Delivery Confirmation</title>
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
          <p>The customer has been charged for today's delivery. Please get the newspaper and send it immediately. Thank you.</b><br><br> Click <a href="javascript: history.go(-1)">here</a> to go the previous page.</p>

		
		
		</td>
      </tr>
    </table>
  </div>
  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
  <p>&nbsp;</p>
</div>
</body>
</html>
CONFIRMDELIVERY;


if ( ($_SESSION['deliveryboy_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { 

			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");	
			
			$deliveryboyId = $_SESSION['deliveryboy_id'];
			
			$sqlQuery = "SELECT product_id, customer_id, quantity FROM orderlist WHERE deliveryboy_id = $deliveryboyId";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't make query");
			$columnCount = mysql_num_fields($sqlResult);
			
			
						while($sqlValues = mysql_fetch_array($sqlResult))
						{

							
								for($column = 2; $column < $columnCount; $column++)
								{			
									$productId = $sqlValues['product_id'];
									$productQuantity = $sqlValues['quantity'];
									$customerId = $sqlValues['customer_id'];
																	
									$sqlQueryPrice = "SELECT price FROM product WHERE id = $productId";
									$sqlResultPrice =  mysql_query($sqlQueryPrice) or die("Can't make query");			
									$sqlValuesPrice = mysql_fetch_array($sqlResultPrice );
									
									
									$sqlQueryPreviousPrice = "SELECT price FROM customer WHERE  id = $customerId";
									$sqlResultPreviousPrice = mysql_query($sqlQueryPreviousPrice) or die ("Can't make query");
									$sqlValuesPreviousPrice = mysql_fetch_array($sqlResultPreviousPrice);																		
									
									$sqlQueryPreviousRecieve = "SELECT recieve FROM customer WHERE  id = $customerId";
									$sqlResultPreviousRecieve = mysql_query($sqlQueryPreviousRecieve) or die ("Can't make query");
									$sqlValuesPreviousRecieve = mysql_fetch_array($sqlResultPreviousRecieve);
									
									$totalPrice = ($sqlValuesPrice['price'] * $productQuantity) + $sqlValuesPreviousPrice['price'];
									$totalRecieve = $sqlValuesPreviousRecieve['recieve'] + $productQuantity;
									
										
									$sqlQueryUpdate = "UPDATE customer SET price = $totalPrice, recieve = $totalRecieve WHERE id = $customerId";
									$sqlResultUpdate = mysql_query($sqlQueryUpdate) or die ("Can't make query");
									
									
									

								}
						}
			
			
				echo $confirmDelivery;
			
			

			
}



?>