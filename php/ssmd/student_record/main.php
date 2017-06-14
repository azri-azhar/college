<?php

session_start();

if ( ($_SESSION['record_username']) == ($_POST['txtUsername']) )
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
        <td width="23%" height="354" valign="top" bgcolor="#DDDDEE"><table width="100%"  border="0" cellspacing="2" cellpadding="2">
          <tr>
            <td bgcolor="#BBCCDD"><strong>Menu</strong></td>
          </tr>
        </table>          
        <p><img src="../button.gif" width="12" height="12">            <a href="../index.php">Log-out</a></p>
          </td>
        <td width="77%" valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" cellspacing="2" cellpadding="2">
          <tr>
              <td bgcolor="#EEEEDD"><strong>Student Management </strong></td>
          </tr>
          </table>          
          <p>Manage students record and their examination results. </p>
          <p><img src="../button.gif" width="12" height="12"> <a href="new_student.php">New Student Registration</a><a href="lab.php"><br>
            </a><br />
              <img src="../button.gif" width="12" height="12"> <a href="view_student.php">View Students Record</a><a href="ordering.php"><br>
              </a><br />
              <img src="../button.gif" width="12" height="12"> <a href="update_student.php">Update or Delete Student Record</a><a href="payment.php"><br>
              </a><br />
              <img src="../button.gif" width="12" height="12"> <a href="add_result.php">Add Examination Results</a></p>
          <p><img src="../button.gif" width="12" height="12"> <a href="view_hardware.php"></a><a href="view_exam.php">View Examination Results</a><a href="research.php"><br>
              </a></p></td></tr>
    </table></td>
  </tr>
</table>
</body>
</html>

<?php } ?>