<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook 2</title>
</head>
<body>
	<h2>This is GuestBook2</h2>
	<h2>${entries[0].name} says ${entries[0].message}</h2>
	<h2>${entries[0].getAll()}</h2>
	<#list entries>
		<table>
			<thead>
				<tr><th>Name</th><th>Message></th><th>Date</th>
			</thead>
			<tbody>
				<#items as entry>
					<tr>
						<td>${entry.name}</td>
						<td>${entry.message}</td>
						<td>${entry.date}</td>
					</tr>
				</#items>
			</tbody>
		</table>
	<#else>
		<p>Entries is empty!</p>
	<#/else>
	</list>
</body>
</html>