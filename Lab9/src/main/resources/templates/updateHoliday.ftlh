<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="../css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="textCenter">	
	<h1>Update Holiday</h1>
		<form action="/updateHoliday/${entry.id}" method="POST">
			Holiday Date: <select name="day" id="day">
				<#list days>
					<#items as day>
						<!--option value="${day}"${day}</option-->
						<option value="${day}">${day}</option>
					</#items>
					<#else>
						<p>Days are empty></p>
				</#list>
			</select>
			<select name="month" id="month">
				<#list months>
					<#items as month>
						<option value="${month}">${month}</option>
					</#items>
					<#else>
						<p>Months are empty></p>
				</#list>
			</select>
			<select name="year" id="year">
				<#list years>
					<#items as year>
						<option value="${year}">${year?string["0"]}</option>
					</#items>
					<#else>
						<p>years are empty></p>
				</#list>
			</select><br />
			Holiday Name: <input type="text" name="holidayName" id="holidayName" value="${entry.holidayName}"><br />
			<button>Update Holiday</button>
		</form>
	</div> <!--textCenter div-->
</body>
</html>