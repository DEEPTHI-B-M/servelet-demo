<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] places={"mumbai","mysore","bangalore"};
		pageContext.setAttribute("myplaces",places);
	%>
	<%
		for(String place: places){
			out.println(place);
		}
	%>
	<p>Using tags</p>
	<c:forEach var="places" items="${myplaces}">
		--> ${places} <br/>
	</c:forEach>
</body>
</html>