<%@ page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		Connection con;
		PreparedStatement ps;
		
		public void jspInit(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				ps=con.prepareStatement("insert into account values(?,?,?,?)");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		public void jspDestroy(){
			try{
				ps.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
	<%
		int accno=Integer.parseInt(request.getParameter("accno"));
		int bal=Integer.parseInt(request.getParameter("bal"));
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		
		ps.setInt(1,accno);
		ps.setString(2,lname);
		ps.setString(3,fname);
		ps.setInt(4,bal);
		
		ps.executeUpdate();
	%>
	<%@ include file="openaccount.html" %>
</body>
</html>