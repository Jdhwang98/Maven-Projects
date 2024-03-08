<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
<link href="./access/css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h2>Login Success Welcome ${name}</h2>
    <div>
        Using Session: ${sessionScope.name}<br />
        Session ID: <% out.print(session.getId()); %>
    </div>
    <div>
        Using Request: <%= request.getAttribute("name") %>
    </div>
    <br>
    <div>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>