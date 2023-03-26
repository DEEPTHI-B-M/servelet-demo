<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Time on the server is <%= new java.util.Date() %>
	<br/><br/>
	
	<% java.util.Date mydate=new java.util.Date(); %>
	Mydate=<%= mydate %>
	<br/><br/>
	
	<c:set var="mynewdate" value="<%= new java.util.Date() %>" />
	Time on the server is ${mynewdate}
</body>
</html>