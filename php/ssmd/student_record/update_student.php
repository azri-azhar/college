<?php

session_start();

if ( ($_SESSION['record_username']) == ($_POST['txtUsername']) )
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
              <td bgcolor="#EEEEDD"><strong>Update Students Record</strong></td>
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
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT * FROM student";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
			
			$columnCount = mysql_num_fields($sqlResult);

			$numberOfItem = mysql_num_rows($sqlResult);

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
echo $top;
			echo $javascript;
					
			echo "<table border = 1 cellspacing = 1 cellpadding = 5>";	
			echo "<br>";
			
			echo "<tr>";
						echo "<td>Id</td>";
						echo "<td>Name</td>";
						echo "<td>Gender</td>";	
						echo "<td>Gender</td>";
						echo "<td>Race</td>";
						echo "<td>Age</td>";
						echo "<td>Address</td>";	
						echo "<td>Phone</td>";
						echo "<td>E-Mail</td>";
						echo "<td>Course</td>";
						echo "<td>Action</td>";												
			echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 9; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[0]</td>\n";
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";
						echo "<td>$sqlValues[3]</td>\n";
						echo "<td>$sqlValues[4]</td>\n";
						echo "<td>$sqlValues[5]</td>\n";																		
						echo "<td>$sqlValues[6]</td>\n";
						echo "<td>$sqlValues[7]</td>\n";																		
						echo "<td>$sqlValues[8]</td>\n";
						echo "<td>$sqlValues[9]</td>\n";
						
						echo "<td> <a href=\"updatestudent_form.php?studentid=";
						echo "$sqlValues[0]\"";
						echo ">Update</a>";
						echo "&nbsp;&nbsp;";
						echo "<a href=\"deletestudent_process.php?studentid=";
						echo "$sqlValues[0]\" onClick=\"return confirmSubmit()\">Delete</a> ";
						echo  "</td>";							
					}
				echo "</tr>";
			}
			
			echo "</table>";
			echo "<p>Go back to <a href=\"main.php\">main menu</a></p>";			
echo $bottom;
			?>

<?php }

?>