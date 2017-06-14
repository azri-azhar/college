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
// File Name: edit_subscription.php
//
// Purpose: Display page for customer's subscription 
// editing. 
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
			
			$sqlQuery = "SELECT product.name, newsagent.company_name, orderlist.quantity, orderlist.id FROM product, orderlist, newsagent WHERE orderlist.product_id = product.id AND orderlist.customer_id = $customerId AND product.newsagent_id = newsagent.id" ;
			
			$sqlResult =  mysql_query($sqlQuery) or mysql_error();
			
			$columnCount = mysql_num_fields($sqlResult);
			
			
			$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Are you sure you want to unsubscribe?");
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
					
					echo "<p>If you're away temporarily on holiday or business, you can unsubscribe your newspaper and we will not charge you. You can subscribe back anytime you want. You can use this page to unsubscribe permanently too. All changes come into effect immediately.</p>";
					
					echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
					echo "<br>";
					
					echo "<tr>";
						echo "<td>Product Name</td>";
						echo "<td>Newsagent Name</td>";
						echo "<td>Quantity</td>";
						echo "<td>Unsubscribe</td>";
						
					echo "</tr>";
						
						while($sqlValues = mysql_fetch_array($sqlResult))
						{
							echo "<tr>";

								for($column = 3; $column < $columnCount; $column++)
								{
									echo "<td>$sqlValues[0]</td>\n";
									echo "<td>$sqlValues[1]</td>\n";
									echo "<td>$sqlValues[2]</td>\n";
									echo "<td> <a href=\"editsubscription_process.php?unsubscribeid=";
									echo "$sqlValues[3]\" onClick=\"return confirmSubmit()\" ";
									echo ">Unsubscribe</a>";
								
								}
							echo "</tr>";
						}
					
						echo "</table>"; 
						
						echo $footer;
}			

?>