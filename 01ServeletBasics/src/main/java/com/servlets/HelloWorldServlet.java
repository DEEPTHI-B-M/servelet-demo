package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class HelloWorldServlet extends GenericServlet {
	public void service(ServletRequest request,ServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Hello World from Servelets!!</h3>");
		out.println("</body>");
		out.println("</html>");
	}
}
