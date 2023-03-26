package com.studentweb.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.resources.model.Student;
import com.studentweb.utils.StudentDataUtil;

@WebServlet("/updatestudent")
public class LoadStudent extends HttpServlet{
		private static final long serialVersionUID = 1L;
	    @Resource(name="jdbc/studentweb")
	    private DataSource datasource;
	    private StudentDataUtil studentDataUtil;
	    
	    public void init(ServletConfig config)throws ServletException {
	    	try {
	    		studentDataUtil = new StudentDataUtil(datasource);
	    	}catch(Exception ex) {
	    		throw new ServletException(ex);
	    	}
	    }
	    
	    

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String studentId=request.getParameter("studentId");
			int id=Integer.parseInt(studentId);
			Student student=studentDataUtil.getStudents(id);
			
			request.setAttribute("STUDENT",student);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/update.jsp");
			dispatcher.forward(request, response);
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}

	}

}
