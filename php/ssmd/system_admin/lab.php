<?php

session_start();

if ( ($_SESSION['system_admin']) == ($_POST['txtUsername']) )
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
              <td bgcolor="#EEEEDD"><strong>Lab Management Authorization </strong></td>
          </tr>
          </table>          
          <p>Manage username and password for Lab Management Authorization.</p>
          <p>

		<form name="formLab" method="post" action="lab.php" >
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="txtNewUsername" />
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtNewPassword" />
				</tr>
				
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add" />
					</td>
			</table>
					
			<?php 
			
			if ( isset($_GET['deleteid']) )
			{
				$deleteid = $_GET['deleteid'];
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = "DELETE FROM authorization WHERE class = 1 AND id = '$deleteid'";
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				unset($_GET['deleteid']);	
				unset($deleteid);		
			}
			
			if (isset( $_POST['txtNewUsername']) & (isset( $_POST['txtNewPassword'] ) ) )
			{
				$username = $_POST['txtNewUsername'];
				$password = md5( $_POST['txtNewPassword'] );
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = "INSERT INTO authorization(username, password, class) VALUES('$username', '$password', 1)";
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				
				unset($_POST['txtNewUsername']);	
				unset($username);		
				unset($_POST['txtNewPassword'] );	
				unset($password);
			}
						
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT id, username, password FROM authorization WHERE class = 1";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query" . mysql_error() );
			
			
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

$bottom = <<< BOTTOM
</p>          </td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>
BOTTOM;
			
			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";
			
			echo "<tr>";
						echo "<td>Id</td>";
						echo "<td>Username</td>";
						echo "<td>Password (Encrypted)</td>";
						echo "<td>Delete</td>";	
			echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 2; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[0]</td>\n";
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";						
						echo "<td> <a href=\"lab.php?deleteid=";
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