<?php

session_start();

if ( ($_SESSION['research_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else 
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
				
				
				if($sqlResult)
				{
					echo "<p>The research record has been added. Go back to <a href=\"main.php\">main menu</a></p>";
				}
}

?>