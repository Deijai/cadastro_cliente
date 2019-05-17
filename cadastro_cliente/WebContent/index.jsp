<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/estilo.css"/>
</head>
<body>

		
		
		<div class="login-page">
		  <div class="form">
		    <form class="login-form" action="LoginServelet" method="post">
		      <input type="text" name="email" placeholder="email"/>
		      <input type="password" name="senha" placeholder="senha"/>
		      <input type="submit" name="logar" value="Logar">
		    </form>
		  </div>
		</div>

</body>
</html>