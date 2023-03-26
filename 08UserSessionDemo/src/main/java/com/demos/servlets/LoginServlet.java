package com.demos.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedstatement;
	
	public void init(ServletConfig config) {
		try {
			ServletContext context=config.getServletContext();
    		String dburl=context.getInitParameter("dburl");
    		String dbuser=context.getInitParameter("dbuser");
    		String dbpassword=context.getInitParameter("dbpassword");
    		Class.forName("com.mysql.jdbc.Driver");
    		connection=DriverManager.getConnection(dburl,dbuser,dbpassword);
    		preparedstatement=connection.prepareStatement("select * from user where email = ? and password = ?");
    	}catch(SQLException e){
    		e.printStackTrace();
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(!isValidInput(username,false)||!isValidInput(password,false)) {
			out.println("<h1>pls enter valid input</h1>");
			return;
		}
		try {
			preparedstatement.setString(1,username);
			preparedstatement.setString(2,password);
			ResultSet resultset=null;
			
			boolean result=preparedstatement.execute();
			if(result)
				resultset=preparedstatement.getResultSet();
			
			if(resultset.next()) {
				System.out.println("User sucessfully logged in.Navigating to home page");
				HttpSession session=request.getSession();
				session.setAttribute("username",username);
				response.addCookie(new Cookie("favoritecolour","Orange"));
				response.addCookie(new Cookie("token","!@#$RF2992"));
				RequestDispatcher rd=request.getRequestDispatcher("home");
				rd.forward(request, response);
			}else {
				out.println("<p>user not found</p>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			
		}catch(SQLException e) {
			out.println("Product Not created.error occured.error message="+e.getMessage());
			e.printStackTrace();
		}
	}
	private boolean isValidInput(String inputValue,boolean isNumber) {
		if(inputValue==null||inputValue.isBlank()||inputValue.isEmpty()) {
			return false;
		}else if(isNumber) {
			try {
				Integer.parseInt(inputValue);
				return true;
			}catch(NumberFormatException nfe) {
				return false;
			}
		}else {
			return true;
		}
	}
	
	public void destroy() {
		try {
			if(connection!=null) {
				connection.close();
			}
			if(preparedstatement!=null) {
				preparedstatement.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
