<?php

session_start();

if ( ($_SESSION['research_username']) == ($_POST['txtUsername']) )
{
	echo "<b><p>Unathorized. Please log-in.</b></p>";
}

else { ?>

		<form name="formAddResearch" method="post" action="newresearch_process.php" >
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
			</table>

<?php }

?>