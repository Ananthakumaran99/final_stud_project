<%@page import="jspStudent.DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
</head>
<body>
	<%Student student=(Student)request.getAttribute("student"); %>
	<form action="edit " method="post">
		ID: <input type="number" name="id" value="<%=student.getStudentId()%>" readonly="readonly"><br>
		<br> <br> Name: <input type="text" name="name" value="<%=student.getStudentname()%>" required="required"><br>
		<br> <br> Email: <input type="text" name="email" value="<%=student.getStudentEmail()%>" required="required"><br>
		<br> <br> Password: <input type="text" name="password" value="<%=student.getStudentPassword()%>" required="required"><br>
		<br> <br> Address: <input type="text" name="address"value="<%=student.getStudentAddress()%>"required="required"><br>
		<br> <br> PhoneNumber: <input type="number"name="phonenumber" value="<%=student.getStudentphone()%>"required="required"><br>
		<br> <br> <input type="submit" value="EDIT">
	</form>
</body>
</html>