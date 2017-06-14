<?php

session_start();

if ( ($_SESSION['ordering_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else { ?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Intergrated Information System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body background="../background.gif" link="#0000CC" vlink="#0000CC" alink="#0000CC">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#99CCFF"><div align="center"><img src="../header2.jpg" width="960" height="154"></div></td>
  </tr>
  <tr>
    <td height="251" bgcolor="#DDE6EE"><table width="100%"  border="0" cellspacing="2" cellpadding="2">
      <tr>
        <td width="77%" height="354" valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" cellspacing="2" cellpadding="2">
          <tr>
              <td bgcolor="#EEEEDD"><strong>Add or Delete Order</strong></td>
          </tr>
          </table>          
          <p>
          
		<form name="formAddOrdering" method="post" action="delete_order.php" >
			<table>				
				<tr>
					<td>Ordered By: </td>
					<td><input type="text" name="txtBy" /></td>
				</tr>

				<tr>
					<td>Product/Service Name: </td>
					<td><input type="text" name="txtProduct" /></td>
				</tr>

				<tr>
					<td>Quantity: </td>
					<td><input type="text" name="txtQuantity" /></td>
				</tr>								

				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4"></textarea></td>
				</tr>					

				<tr>
					<td>Supplier: </td>
					<td><input type="text" name="txtSupplier" /></td>
				</tr>							

				<tr>
					<td>Price (RM): </td>
					<td><input type="text" name="txtPrice" /></td>
				</tr>	
								
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add" />
						<input type="reset" name="btnReset" value="Reset" />
					</td>
			</table>
			
			
			<?php 
			
			$bottom = <<< BOTTOM
</p>          </td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>

BOTTOM;
			
			if ( isset($_GET['deleteid']) )
			{
				$deleteid = $_GET['deleteid'];
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = "DELETE FROM `order` WHERE id = '$deleteid'";
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				unset($_GET['deleteid']);	
				unset($deleteid);		
			}
			
			if (isset( $_POST['txtBy']) & (isset( $_POST['txtProduct'] ) ) )
			{
				$byee  = $_POST['txtBy'];
				$product = $_POST['txtProduct'];
				$quantity = $_POST['txtQuantity'];
				$description = $_POST['txtDescription'];
				$supplier = $_POST['txtSupplier'];
				$price = $_POST['txtPrice'];
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = " INSERT INTO `order` (`by`, `name`, `quantity`, `description`, `supplier`, `price`) VALUES('$byee', '$product', '$quantity', '$description', '$supplier', '$price') ";
	
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				
				unset($_POST['txtBy']);	
				unset($byee);		
				unset($_POST['txtProduct'] );	
				unset($product);
			}
												
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
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT * FROM `order`";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			$columnCount = mysql_num_fields($sqlResult);

			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";
			
			echo "<tr>";
						echo "<td>Id</td>";
						echo "<td>Ordered By</td>";
						echo "<td>Product/Service</td>";	
						echo "<td>Quantity</td>";
						echo "<td>Description</td>";
						echo "<td>Supplier</td>";
						echo "<td>Price</td>";	
						echo "<td>Action</td>";													
			echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 7; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[0]</td>\n";
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";
						echo "<td>$sqlValues[3]</td>\n";
						echo "<td>$sqlValues[4]</td>\n";
						echo "<td>$sqlValues[5]</td>\n";							
						echo "<td>$sqlValues[6]</td>\n";						
						echo "<td> <a href=\"delete_order.php?deleteid=";
						echo "$sqlValues[0]\" onClick=\"return confirmSubmit()\" ";
						echo ">Delete</a>";
					}
				echo "</tr>";
			}
			
			echo "</table>";
			echo "<p>Go back to <a href=\"main.php\">main menu</a></p>";			
						echo $bottom;
			?>
<?php }

?>