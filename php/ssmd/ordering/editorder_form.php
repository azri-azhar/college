<?php

session_start();

if ( ($_SESSION['ordering_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else { ?>
			
			<?php 

	$top = <<< TOP
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
              <td bgcolor="#EEEEDD"><strong>Edit Order Record</strong></td>
          </tr>
          </table>          
          <p>
	
TOP;

$bottom = <<< BOTTOM
</p>          </td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>

BOTTOM;
			
			$editid = $_GET['editid'];
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT * FROM `order` WHERE `id` = $editid";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

			$sqlValues = mysql_fetch_array($sqlResult);
				
				$byee  = $sqlValues[1];
				$product = $sqlValues[2];
				$quantity = $sqlValues[3];
				$description = $sqlValues[4];
				$supplier = $sqlValues[5];
				$price = $sqlValues[6];		

	$display_page = <<< PAGE
				
		<form name="formAddOrdering" method="post" action="editorder_process.php" >
			<table>				
				<tr>
					<td>Ordered By: </td>
					<td><input type="text" name="txtBy" value="$byee" />
					<input type="hidden" name="txtId" value="$editid" /></td>
				</tr>

				<tr>
					<td>Product/Service Name: </td>
					<td><input type="text" name="txtProduct" value="$product" /></td>
				</tr>

				<tr>
					<td>Quantity: </td>
					<td><input type="text" name="txtQuantity" value="$quantity" /></td>
				</tr>								

				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4">$description</textarea></td>
				</tr>					

				<tr>
					<td>Supplier: </td>
					<td><input type="text" name="txtSupplier" value="$supplier" /></td>
				</tr>							

				<tr>
					<td>Price (RM): </td>
					<td><input type="text" name="txtPrice" value="$price" /></td>
				</tr>	
								
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Update" />
						<input type="reset" name="btnReset" value="Reset" />
					</td>
			</table>				
			
PAGE;
echo $top;
echo $display_page;
echo $bottom;
			?>
			
<?php }

?>