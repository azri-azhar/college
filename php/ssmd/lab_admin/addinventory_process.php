<?php

session_start();

if ( ($_SESSION['lab_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else 
{
				
				$category = $_POST['txtCategory'];
				$name = $_POST['txtItemName'];
				$serial = $_POST['txtSerial'];
				$price = $_POST['txtPrice'];
				$location = $_POST['txtLocation'];
				$condition = $_POST['txtCondition'];			
				$description = $_POST['txtDescription'];
				
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = "INSERT INTO lab(category, name, serial, price, location, condition, description) 
				VALUES('$category', '$name', '$serial', '$price', '$location', '$condition', '$description') ";
	
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				

$page = <<< PAGE

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
              <td bgcolor="#EEEEDD"><strong>Lab Management</strong></td>
          </tr>
          </table>          
          <p>The inventory item has been added. Go back to <a href="main.php">main menu</a></p>
          <p>&nbsp;</p></td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>
PAGE;
				if($sqlResult)
				{
					echo $page;
				}
}

?>