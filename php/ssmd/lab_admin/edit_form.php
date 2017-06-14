<?php

session_start();

if ( ($_SESSION['lab_username']) == ($_POST['txtUsername']) )
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
              <td bgcolor="#EEEEDD"><strong>Edit Inventory</strong></td>
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
			
			$inventoryid = $_GET['inventoryid'];
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT * FROM lab WHERE id = $inventoryid";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

			$sqlValues = mysql_fetch_array($sqlResult);
				
			$category = $sqlValues[1];
			$name = $sqlValues[2];
			$serial = $sqlValues[3];
			$price = $sqlValues[4];
			$location = $sqlValues[5];
			$condition = $sqlValues[6];			
			$description = $sqlValues[7];		
			
			if ($condition == "Excellent")
			{
				$condition2 = "Faulty";
			}
			
			if ($condition == "Faulty")
			{
				$condition2 = "Excellent";
			}			
				
			if ($category == "Hardware")
			{
				$category2 = "Software";
				$category3 = "other";
			}

			if ($category == "Software")
			{
				$category2 = "Hardware";
				$category3 = "Other";
			}

			if ($category == "Other")
			{
				$category2 = "Hardware";
				$category3 = "Software";
			}

	$display_page = <<< PAGE
				
		<form name="formAddInventory" method="post" action="edit_process.php" >
			<table>
				<tr>
					<td>Category: </td>
					<td> <select name="txtCategory" 
					<option value="$category">$category</option>
					<option value="$category2">$category2</option>
					<option value="$category3">$category3</option>		
					</select> </td>
				</tr>
				
				<tr>
					<td>Name: </td>
					<td><input type="text" name="txtItemName" value="$name" />
					<input type="hidden" name="txtId" value="$inventoryid">
					</td>
				</tr>

				<tr>
					<td>Serial Number: </td>
					<td><input type="text" name="txtSerial" value="$serial" /></td>
				</tr>

				<tr>
					<td>Price (RM): </td>
					<td><input type="text" name="txtPrice" value="$price" /></td>
				</tr>								
				<tr>
				
					<td>Location: </td>
					<td><input type="text" name="txtLocation" value="$location" /></td>
				</tr>

				<tr>
					<td>Condition: </td>
					<td> <select name="txtCondition" 
					<option value="$condition">$condition</option>
					<option value="$condition2">$condition2</option>		
					</select></td>
				</tr>
							
				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4">$description</textarea></td>
				</tr>	
								
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Update" />
					</td>
			</table>				
			
PAGE;
echo $top;
echo $display_page;
echo $bottom;
			?>
			
<?php }

?>