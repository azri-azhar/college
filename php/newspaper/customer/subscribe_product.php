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
// File Name: subscribe_product.php
//
// Purpose: Display page for customer subscription. 
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

if ( ($_SESSION['customer_username']) == ($_POST['txtUsername']) )
{
	echo $error;
}

else { ?>

<?php
			$customerUsername = $_SESSION['customer_username'];
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");	
			$sqlQuery = "SELECT newsagent_id FROM customer WHERE username = '$customerUsername' " ;
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			$sqlValues = mysql_fetch_array($sqlResult);
			
			$newsagentId = $sqlValues['newsagent_id'];

		if (isset ( $_GET['productid'] ) AND (isset ($newsagentId) ) )
		{ 
			$productId = $_GET['productid']; 


			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");
			$sqlQueryResultCustomerId = "SELECT id FROM customer WHERE username = '$customerUsername' " ;	
			$sqlResultCustomerId =  mysql_query($sqlQueryResultCustomerId) or die("Can't Make query");
			$workedResultCustomerId = mysql_fetch_array($sqlResultCustomerId);
			$customerId = $workedResultCustomerId['id'];
			
			$sqlQueryResultProductName = "SELECT name FROM product WHERE id = '$productId' AND newsagent_id = '$newsagentId' " ;	
			$sqlResultProductName =  mysql_query($sqlQueryResultProductName) or die("Can't Make query");
			$workedProductName = mysql_fetch_array($sqlResultProductName);
			$productName = $workedProductName['name'];
			
			$sqlQueryResultProductPrice = "SELECT price FROM product WHERE id = '$productId' AND newsagent_id = '$newsagentId' " ;	
			$sqlResultProductPrice =  mysql_query($sqlQueryResultProductPrice) or die("Can't Make query");
			$workedProductPrice = mysql_fetch_array($sqlResultProductPrice);
			$productPrice = $workedProductPrice['price'];

			$sqlQueryResultNewsagentName = "SELECT company_name, name, telephone FROM newsagent WHERE id = '$newsagentId'" ;	
			$sqlResultNewsagentName =  mysql_query($sqlQueryResultNewsagentName) or die("Can't Make query");
			$workedResultNewsagentName = mysql_fetch_array($sqlResultNewsagentName);
			$newsagentName = $workedResultNewsagentName['company_name'];
			$newsagentContactName = $workedResultNewsagentName['name'];
			$newsagentTelephone = $workedResultNewsagentName['telephone'];
			
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

STARTHEADER;



	$display_page = <<< PAGE

		<html>
		
			<body>	

			
			<form name="formSubscribe" method="post" action="subscribe_process.php" />
			
				<table>
				
					<tr>
						<p><b>You have choosen to subscribe:</b> $productName</p>
						
						<p><b>Newsagent company:</b> $newsagentName</p>
						
						<p><b>Newsagent contact name:</b> $newsagentContactName</p>
						
						<p><b>Telephone:</b> $newsagentTelephone</p>
						
						<p><b>Price:</b> RM $productPrice</p>
						
						<p><b>Quantity:</b>
						
						<input type="text" name="txtQuantity" value=1 /> </p>
						
						<input type="hidden" name="productId" value="$productId" />
						<input type="hidden" name="customerId" value="$customerId" />
						
						
						<p>Please note that you do not have to specify subscription duration since your bill will be calculated on daily basis and you can halt or cancel your subscribtion anytime.
						Your subscription will start when you click the confirmation button below and stop whenever your wish by editing your subscriptions detail. You will only be charge on what you received
						and the bill will be delivered by our delivery boy. Thank you.
						</p>
						
		
					</tr>
					
					<tr>
						<td>
						<br />
						<input type="submit" name="btnConfirm" value="Confirm" />
						</td>
					</tr>
			</table>	
			</form>
PAGE;

		$footer = <<< STARTFOOTER
		
	   <br>
	   </div>
	  <p align="left"><img src="../images/div2.jpg" width="400" height="17"></p>
	</div>
	</body>
	</html>
STARTFOOTER;

		echo $header;	
		echo $display_page;
		echo $footer;	
		} 
		
		else 
		{ 
			echo "<b><p>You haven't select a newsagent or there's no product to subscribe.</b></p>";
		}
		

		
?>

<?php } ?>