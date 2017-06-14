<?php

session_start();

if ( ($_SESSION['research_username']) == ($_POST['txtUsername']) )
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
              <td bgcolor="#EEEEDD"><strong>Add New Research</strong></td>
          </tr>
          </table>          
          <p>
		<form name="formAddResearch" method="post" action="add_research.php" >
			<table>
				<tr>
					<td>Research Title: </td>
					<td><input type="text" name="txtTitle" /></td>
				</tr>

				<tr>
					<td>Research Field: </td>
					<td><input type="text" name="txtField" /></td>
				</tr>

				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4"></textarea></td>
				</tr>	
											
				<tr>				
					<td>Supervisor: </td>
					<td><input type="text" name="txtSupervisor" /></td>
				</tr>

				<tr>				
					<td>Total Fund Provided (RM): </td>
					<td><input type="text" name="txtFund" /></td>
				</tr>
											
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add" />
						<input type="reset" name="btnReset" value="Reset" />
					</td>
				</tr>
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
			
				$sqlQuery = "DELETE FROM research WHERE id = '$deleteid'";
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				unset($_GET['deleteid']);	
				unset($deleteid);		
			}
			
			if (isset( $_POST['txtTitle']) & (isset( $_POST['txtField'] ) ) )
			{
				$title = $_POST['txtTitle'];
				$field = $_POST['txtField'];
				$description = $_POST['txtDescription'];
				$supervisor = $_POST['txtSupervisor'];
				$fund = $_POST['txtFund'];
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = "INSERT INTO research(title, field, description, supervisor, fund) 
				VALUES('$title', '$field', '$description', '$supervisor', '$fund') ";
	
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				
				unset($_POST['txtTitle']);	
				unset($title);		
				unset($_POST['txtField'] );	
				unset($field);
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
		
			$sqlQuery = "SELECT * FROM research";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			$columnCount = mysql_num_fields($sqlResult);

			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";
			
			echo "<tr>";
						echo "<td>Id</td>";
						echo "<td>Title</td>";
						echo "<td>Field</td>";	
						echo "<td>Description</td>";
						echo "<td>Supervisor</td>";
						echo "<td>Fund</td>";
						echo "<td>Action</td>";													
			echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 5; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[0]</td>\n";
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";
						echo "<td>$sqlValues[3]</td>\n";
						echo "<td>$sqlValues[4]</td>\n";
						echo "<td>$sqlValues[5]</td>\n";							
						echo "<td> <a href=\"add_research.php?deleteid=";
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