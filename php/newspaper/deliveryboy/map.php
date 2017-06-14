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
// File Name: map.php
//
// Purpose: Display map for newsagent.
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


$header = <<< STARTHEADER
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Delivery Boy: Map</title>
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
    <p><b>Delivery Boy Map</b></p>
	
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

if ( ($_SESSION['deliveryboy_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { 

			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");	
			
			$deliveryboyId = $_SESSION['deliveryboy_id'];
			
			$sqlQuery = $sql = 'SELECT orderlist.id, orderlist.product_id, orderlist.customer_id, orderlist.quantity, product.name, product.type, product.price, customer.name, customer.address, customer.town, customer.state, customer.postcode, customer.telephone'
        . ' FROM orderlist, product, customer'
        . ' WHERE ( orderlist.product_id = product.id ) AND ( orderlist.deliveryboy_id ='. $deliveryboyId .' ) AND ( orderlist.customer_id = customer.id ) '; 
			
			$sqlResult =  mysql_query($sqlQuery) or die("Can't make query");
			
			
			$columnCount = mysql_num_fields($sqlResult);
			
	
			
			$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("After you click OK, the customers will be charged. Please get the newspapers from your newsagent and send it immediately. You need to click here only once a day. Continue?");
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
					
					echo '<center><img src="map.jpg"></center>';
						
						echo $footer;
						

}
 ?>