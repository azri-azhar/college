<?php

session_start();

if ( ($_SESSION['record_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else { ?>
			
			<?php 
			
			$studentid = $_GET['studentid'];

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
              <td bgcolor="#EEEEDD"><strong>Add Examination Result</strong></td>
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
			
			$display_page = <<< PAGE
				
				<form name="formResult" method="post" action="addresult_process.php" >
					<table>
						<tr>
							<td>Semester:</td>
							<td><input type="text" name="txtSemester" />
							<td><input type="hidden" name="txtStudentId" value="$studentid" />				
							</td>
						</tr>
						
						<tr>
							<td>Subject:</td>
							<td><input type="text" name="txtSubject" /></td>
						</tr>
		
						<tr>
							<td>Subject Code:</td>
							<td><input type="text" name="txtCode" /></td>
						</tr>
						
						<tr>
							<td>Result:</td>
							<td> <select name="txtResult" /> 
							<option value="Distinction">Distinction</option>
							<option value="Credit">Credit</option>	
							<option value="Pass">Pass</option>	
							<option value="Fail">Fail</option>	
							</select> </td>
						</tr>				
						
						<tr> 
							<td>
								<br />
								<input type="submit" name="btnAddResult" value="Add" />
							</td>
					</table>				
PAGE;
		
echo $top;			
echo $display_page;
				
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			$sqlQuery = "SELECT id, semester, subject, code, result FROM exam WHERE student_id = $studentid";
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
						echo "<td>Id</td>";
						echo "<td>Semester</td>";
						echo "<td>Subject</td>";
						echo "<td>Subject Code</td>";	
						echo "<td>Result</td>";	
						echo "<td>Action</td>";							
			echo "</tr>";
			
			while($sqlValues = mysql_fetch_array($sqlResult))
			{
				echo "<tr>";
				
					for($column = 4; $column < $columnCount; $column++)
					{
						echo "<td>$sqlValues[0]</td>\n";
						echo "<td>$sqlValues[1]</td>\n";
						echo "<td>$sqlValues[2]</td>\n";						
						echo "<td>$sqlValues[3]</td>\n";
						echo "<td>$sqlValues[4]</td>\n";
						echo "<td> <a href=\"addresult_process.php?deleteid=";
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