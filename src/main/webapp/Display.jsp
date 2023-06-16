<%@page import="jspStudent.DTO.Student"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DisplayDetails</title>
</head>
<body>
	<%
	List<Student> students = (List) request.getAttribute("list");
	%>
	<table border="2px">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>ADDRESS</th>
			<th>FEES</th>
			<th>PHONE</th>
		</tr>
		<%
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getStudentname()%></td>
			<td><%=student.getStudentEmail()%></td>
			<td><%=student.getStudentPassword()%></td>
			<td><%=student.getStudentAddress()%></td>
			<td><%=student.getStudentphone()%></td>
			<td><%=student.getStudentfees()%></td>

			<td><a href="delete?id=<%=student.getStudentId()%>">DELETE</a></td>
			<td><a href="update?id=<%=student.getStudentId()%>">UPDATE</a></td>

		</tr>


		<%} %>
	</table>

</body>
</html>