<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updatestudent" method="post">
		<input type="hidden" name="studentId" value="${STUDENT.id}" />
		<table>
			<tr>
				<td>First Name</td>
				<td><input name="firstName" value="${STUDENT.firstName}"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input name="lastName" value="${STUDENT.lastName}"/></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><input name="emailId" value="${STUDENT.email}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" value="Save"/></td>
			</tr>
				
		</table>
	</form>
</body>
</html>