<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Example</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="./access/css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%
        if (request.getAttribute("errorMessage") == null || request.getAttribute("errorMessage") == "") {
            out.println("<div></div>");
        } else {
            out.println("<div class='errorMessage'>" + request.getAttribute("errorMessage") + "</div>");
        }
    %>
   <!--  <div class="container d-flex justify-content-center align-items-center" style="height: 100vh">
    	<div class="card black-card" style="width: 400px">
    		<div class="card-body text-center">
    			<h2 class="card-title">Login</h2>
    			<label class="mb-3 card-title" style="color:gray">Please enter your login and password!</label>
    			<br> -->
    			<div>
        <form action="Login" method="post">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" placeholder="Please enter your email" required><br />
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Please enter password" required><br />
            
            <button type="submit">Login</button>
        </form>
    		</div>
    	</div>
    </div>
    </div>
    <div>
        <%
            if (request.getAttribute("loggedOut") == "loggedOut") {
        %>
                You are logged out
        <%    
            } else {}
        %>
    </div>
</body>
</html>