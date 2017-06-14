<?php

session_start();

if ( ($_SESSION['ordering_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else { ?>

		<form name="formAddOrdering" method="post" action="neworder_process.php" >
			<table>				
				<tr>
					<td>Ordered By: </td>
					<td><input type="text" name="txtBy" /></td>
				</tr>

				<tr>
					<td>Product/Service Name: </td>
					<td><input type="text" name="txtProduct" /></td>
				</tr>

				<tr>
					<td>Quantity: </td>
					<td><input type="text" name="txtQuantity" /></td>
				</tr>								

				<tr>
					<td>Description: </td>
					<td><textarea name="txtDescription" rows="4"></textarea></td>
				</tr>					

				<tr>
					<td>Supplier: </td>
					<td><input type="text" name="txtSupplier" /></td>
				</tr>							

				<tr>
					<td>Price (RM): </td>
					<td><input type="text" name="txtPrice" /></td>
				</tr>	
								
				<tr> 
					<td>
						<br />
						<input type="submit" name="btnAdd" value="Add" />
						<input type="reset" name="btnReset" value="Reset" />
					</td>
			</table>

<?php }

?>