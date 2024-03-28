<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>
<body>
	<form action="/edit/${entry.id}" method="POST">
		Name: <@spring.formInput type="text" name="" id="" value="${entry.name}"/><@spring.showErrors "<br />"<br />
		<@spring.formTextarea "entry.message" rows="5" cols="60" /><@spring.showErrors "<br /> " <br />
		<textarea name="" id="" rows="5" cols="60">${entry.message}</textarea>
		<button> Update Comment </button>
	</form>
</body>
</html>