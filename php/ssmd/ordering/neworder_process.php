<?php

session_start();

if ( ($_SESSION['ordering_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else 
{
				
				$byee  = $_POST['txtBy'];
				$product = $_POST['txtProduct'];
				$quantity = $_POST['txtQuantity'];
				$description = $_POST['txtDescription'];
				$supplier = $_POST['txtSupplier'];
				$price = $_POST['txtPrice'];		
				
				$sqlConnect = mysql_connect('localhost', 'root') or die("Can't connect to database");
				$sqlDb = mysql_select_db('ssmd') or die("Can't select database");
			
				$sqlQuery = " INSERT INTO `order` (`by`, `name`, `quantity`, `description`, `supplier`, `price`) VALUES('$byee', '$product', '$quantity', '$description', '$supplier', '$price') ";
				

				$sqlResult =  mysql_query($sqlQuery) or die("Can't Make query" . mysql_error() );
				
				
				if($sqlResult)
				{
					echo "<p>The order has been added. Go back to <a href=\"main.php\">main menu</a></p>";
				}
}

?>