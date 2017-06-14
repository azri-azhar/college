<?php

session_start();

if ( ($_SESSION['lab_username']) == ($_POST['txtUsername']) )
{
	$auto = <<< AUTO

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
              <td bgcolor="#EEEEDD"><strong>Authorization</strong></td>
          </tr>
          </table>          
<p>Unathorized. Please enter a valid username and password.</p>
          <p>&nbsp;</p></td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>
AUTO;

	echo $auto;	

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
              <td bgcolor="#EEEEDD"><strong>Lab Management </strong></td>
          </tr>
          </table>          
          <p>Add new item in inventory records.</p>
          <p>
          
		<form name="formAddInventory" method="post" action="addinventory_process.php" >
			<table>
				<tr>
					<td>Category: </td>
					<td> <select name="txtCategory" 
					<option value="Hardware">Hardware</option>
					<option value="Software">Software</option>
					<option value="Other">Other</option>		
					</select> </td>
				</tr>
				
				<tr>
					<td>Name: </td>
					<td><input type="text" name="txtItemName" /></td>
				</tr>

				<tr>
					<td>Serial Number: </td>
					<td><input type="text" name="txtSerial" /></td>
				</tr>

				<tr>
					<td>Price (RM): </td>
					<td><input type="text" name="txtPrice" /></td>
				</tr>								
				<tr>
				
					<td>Location: </td>
					<td><input type="text" name="txtLocation" /></td>
				</tr>

				<tr>
					<td>Condition: </td>
					<td> <select name="txtCondition" 
					<option value="Excellent">Excellent</option>
					<option value="Faulty">Faulty</option>		
					</select></td>
				</tr>
							
				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4"></textarea></td>
				</tr>	
								
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add" />
						<input type="reset" name="btnReset" value="Reset" />
					</td>
				</tr>
			</table>
			
</p></td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>
<?php }

?>