<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dependency Injection Example</title>
</head>
<body>
	<h2>Dependency Injection Example</h2>
	
	<#list entries>
		<table>
			<thead>
				<tr><th>Name</th><th>Message></th><th>date</th></tr>
			</thead>
			<tbody>
				<#items as entry>
					<tr>
						<td>${entry.name}</td>
						<td>${entry.message}</td>
						<td>${entry.date.format("LONG_DATE")}</td>
					</tr>
				</#items>
			</tbody>
		</table>
	<#else>
		<p>Entries is empty<p>
	</#list>
</body>
</html>