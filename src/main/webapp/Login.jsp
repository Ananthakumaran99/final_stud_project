<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (message != null) {
	%>

	<%=message%>


	<%
	}
	%>



	<form action="login" method="post">
		Email: <input type="text" name="email"> Password: <input
			type="text" name="password"><br>
		<br> <input type="submit" value="SUBMIT">




	</form>
</body>
</html>