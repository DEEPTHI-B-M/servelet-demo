<%@ page language="java" contentType="text/html; charset="UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
		</tr>
		<c:forEach var="student" items="${student_list}">
		<tr>
			<td>${student.id}</td>
			<td>${student.fistName}</td>
			<td>${student.lastName}</td>
			<td>${student.email}</td>
			<td><a href="deletestudent?studentId=${student.id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>