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
// File Name: product.php
//
// Purpose: Display product for adding and deleting.
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
	<title>Newsagent: Add Delivery Boy</title>
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
	    <p>You can add your product here. Your customers will be able to subscribe these products.</p>	
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

else { ?> <?php echo $header ?>

		<form name="formAddProduct" method="post" action="product_process.php" >
			<table>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="txtProductName" />
				</tr>
				
				<tr>
					<td>Product Type</td>
					<td><input type="text" name="txtProductType" />
				</tr>

				<tr>
					<td>Price</td>
					<td><input type="text" name="txtProductPrice" />
				</tr>
				
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add Product" />
					</td>
			</table>	
			
			<?php 
			
			$username = $_SESSION['newsagent_username'];
			$newsagentId = $_SESSION['newsagent_id'];
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('azri') or die("Can't select database");
		
			$sqlQuery = "SELECT id, name, type, price FROM product WHERE newsagent_id = '$newsagentId'";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			
			$columnCount = mysql_num_fields($sqlResult);
			
			
			$javascript = <<< STARTJAVA
			
					<script LANGUAGE="JavaScript">
						<!--
						function confirmSubmit()
						{
						var agree=confirm("Are you sure you want to delete?");
						if (agree)
							return true ;
						else
							return false ;
						}
						// -->
					</script>
STARTJAVA;
				
			echo $javascript;
			
			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";
			
					echo "<tr>";
						echo "<td>Product Name</td>";
						echo "<td>Type</td>";
						echo "<td>Price</td>";
						echo "<td>Delete</td>";
					echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 3; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";
						echo "<td>RM ". "$sqlValues[3]</td>\n";
						
						echo "<td> <a href=\"delete_product.php?deleteid=";
						echo "$sqlValues[0]\" onClick=\"return confirmSubmit()\" ";
						echo ">Delete</a>";
						
					}
				echo "</tr>";
			}
			
			echo "</table>";
			
			echo $footer;
			
			?>

<?php }

?>