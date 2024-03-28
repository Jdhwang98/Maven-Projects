<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Holiday Calendar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="textCenter">		
		<div><h1>US Holidays</h1><br />
	<#list entries> 
		<table>
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Holiday</th>
					<th scope="col">Update/Delete</th>
				</tr>
			</thead>
			<tbody>
				<#items as entry>
					<tr>
						<td scope="row">${entry.holidayDate.format("dd MMMM yyyy")}</td>
						<td>${entry.holidayName}</td>
						<td><a href="updateHoliday/${entry.id}">Update</a> | <a href="index/${entry.id}">Delete</a></td>
					</tr>
				</#items>
			</tbody>
		</table><br />
	<#else>
		<p>Entries is empty!<p>
	</#list>
	<a class="btn btn-secondary w-40" href="/addHoliday" role="button">Add Holiday</a>
	<div>
</body>
</html>