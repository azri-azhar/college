<?php

session_start();

if ( ($_SESSION['record_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else 
{

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
              <td bgcolor="#EEEEDD"><strong>New Student Registration</strong></td>
          </tr>
          </table>          
			<p>Go back to <a href="javascript:history.go(-1)">previous page</a> to add more.</p>
			<p>Go back to <a href="main.php">main menu</a></p>
          <p>&nbsp;</p></td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>
PAGE;
	
	if ( isset( $_POST['txtStudentId'] ) )
	{
	$id = $_POST['txtStudentId'];			
	$semester = $_POST['txtSemester'];
	$subject = $_POST['txtSubject'];
	$code = $_POST['txtCode'];
	$result = $_POST['txtResult'];
	
	$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
	$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
	
	$sqlQuery = "INSERT INTO exam(student_id, semester, subject, code, result) 
	VALUES('$id', '$semester', '$subject', '$code', '$result')";
	
	$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
	}

	if ( isset($_GET['deleteid']) )
	{
				$deleteid = $_GET['deleteid'];
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
				$sqlQuery = "DELETE FROM exam WHERE id = $deleteid";
				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query");
				unset($_GET['deleteid']);	
				unset($deleteid);
	}
			
			
 echo $page;
			
}

?>