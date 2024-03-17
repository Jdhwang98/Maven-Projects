<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="./assets/css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>
 	<div>
        <a href="Logout">Logout</a>
    </div>
	<div class="textCenter">		
		<h1>Downloads</h1><br />
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">File Name</th>
					<th scope="col">Preview</th>
					<th scope="col">Download</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td scope="row">1</td>
					<td>Apple</td>
					<td><img src="./assets/images/apple.jpg" alt="Apple" width="200" height="132"></td>
					<td>
						<form action="Download" method="POST">
						<input type="hidden" name="fruit" value="apple"/>
						<button type="submit" class="btn btn-primary">Download</button>
						</form>
					</td>
					
				</tr>
				<tr>
					<td scope="row">2</td>
					<td>orange</td>
					<td><img src="./assets/images/orange.jpg" alt="Orange" width="200" height="132"></td>
					<td>
						<form action="Download" method="POST">
						<input type="hidden" name="fruit" value="orange"/>
						<button type="submit" class="btn btn-primary">Download</button>
						</form>
					</td>
				</tr>
				<tr>
					<td scope="row">3</td>
					<td>Banana</td>
					<td><img src="./assets/images/banana.jpg" alt="Banana" width="200" height="132"></td>
					
					<td>
						<form action="Download" method="POST">
						<input type="hidden" name="fruit" value="banana"/>
						<button type="submit" class="btn btn-primary">Download</button>
						</form>
					</td>
				</tr>
			</tbody>
		</table><br />
	</div>
</body>
</html>