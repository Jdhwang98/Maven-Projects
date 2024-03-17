<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="./assets/css/Styles.css" rel="stylesheet" type="text/css">
</head>
<body>

   
	<div class ='container text-center d-flex justify-content-center'>
		<div class='row align-items-center'>
			<div class = "row">
				<div class='col-6'>
					<div class='card'>
						<div class='card-body'>
				
							<h2>login</h2>
							<span style="color:gray">Please enter your login and password!</span>
							<form action="Login" method = "post"><br />
								<div class="form-group">
								
									<input class="form-control form-control-md" type="text" name="email"> 
									<p>Email</p>
									<input class="form-control form-control-md" type="text" name="password">
									<p>Password</p>
	<%
        if (request.getAttribute("errorMessage") == null || request.getAttribute("errorMessage") == "") {
            out.println("<div></div>");
        } else {
            out.println("<div class='errorMessage'>" + request.getAttribute("errorMessage") + "</div>");
        }
    %>
									<a href="Register.jsp">Create New Account</a><br />
									<button type="submit" class="btn btn-dark">Login</button><br />
								</div>
							</form>
							<div>
								 <i class="bi bi-facebook" style="font-size: 30px;"></i>
               					 <i class="bi bi-twitter-x" style="font-size: 30px;"></i>
                			 	<i class="bi bi-google" style="font-size: 30px;" ></i>
							</div>
							<div>
								<p>Don't have an account? <a href="Register.jsp">Sign Up</a> </p>
							</div>
						</div><!--card-body-->
					</div><!--card-->
				</div><!-- col- -->
			</div><!--row-->
		</div><!-- alignment -->
	</div> <!-- container -->
	

</body>
</html>