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
			
			$studentid = $_GET['studentid'];
			
			$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
			$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
		
			$sqlQuery = "SELECT * FROM student WHERE id = $studentid";
			$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");

			$sqlValues = mysql_fetch_array($sqlResult);

			$studentid = $sqlValues[0];
			$name = $sqlValues[1];
			$ic = $sqlValues[2];
			$gender = $sqlValues[3];
			$race = $sqlValues[4];
			$age = $sqlValues[5];
			$address = $sqlValues[6];
			$phone = $sqlValues[7];
			$email = $sqlValues[8];
			$course = $sqlValues[9];	
			
			if ($gender == "Male")
			{
				$gender2 = "Female";
			}
			
			if ($gender == "Female")
			{
				$gender2 = "Male";
			}			
				
			if ($race == "Malay")
			{
				$race2 = "Chinese";
				$race3 = "Indian";
				$race4 = "Other";
			}

			if ($race == "Chinese")
			{
				$race2 = "Malay";
				$race3 = "Indian";
				$race4 = "Other";
			}

			if ($race == "Indian")
			{
				$race2 = "Malay";
				$race3 = "Chinese";
				$race4 = "Other";
			}

			if ($race == "Other")
			{
				$race2 = "Malay";
				$race3 = "Chinese";
				$race4 = "Indian";
			}

	$display_page = <<< PAGE

	
		<form name="formAddNewStudent" method="post" action="updatestudent_process.php" >
			<table>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="txtName" value="$name" /></td>
					<input type="hidden" name="txtId" value="$studentid">
				</tr>

				<tr>
					<td>IC/Passport: </td>
					<td><input type="text" name="txtIc" value="$ic" /></td>
				</tr>

				<tr>
					<td>Gender: </td>
					<td> <select name="txtGender" /> 
					<option value="$gender">$gender</option>
					<option value="$gender2">$gender2</option>	
					</select> </td>
				</tr>
				
				<tr>
					<td>Race: </td>
					<td> <select name="txtRace" /> 
					<option value="$race">$race</option>
					<option value="$race2">$race2</option>	
					<option value="$race3">$race3</option>	
					<option value="$race4">$race4</option>	
					</select> </td>
				</tr>
								
				<tr>
					<td>Age: </td>
					<td><input type="text" name="txtAge" value="$age" /></td>
				</tr>
				
				<tr>
					<td>Address: </td>
					<td><textarea name="txtAddress" rows="4">$address</textarea></td>
				</tr>

				<tr>
					<td>Phone: </td>
					<td><input type = "text" name = "txtPhone" value = "$phone" /> </td>
				</tr>
							
				<tr>
					<td>E-Mail </td>
					<td><input type="text" name="txtEmail" value = "$email" /></td>
				</tr>	

				<tr>
					<td>Course: </td>
					<td><input type="text" name="txtCourse" value = "$course" /></td>
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