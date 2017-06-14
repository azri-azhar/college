<?php

$username = $_POST['txtUsername'];
$password = md5( $_POST['txtPassword'] ) ;

$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
$sqlDb = mysql_select_db('ssmd') or die("Can select db");
$sqlQuery = "SELECT * FROM authorization WHERE username = '$username' AND password = '$password' AND class = 5 ";

$sqlResult = mysql_query($sqlQuery) or die("Can't make query");
$worked = mysql_fetch_array($sqlResult);

if (!$worked)
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

	else
	{
			session_start();
			$_SESSION['student_username'] = $worked['username'];
			$_SESSION['student_id'] = $worked['related_id'];
			header("Location: main.php");
	}
	
?>	