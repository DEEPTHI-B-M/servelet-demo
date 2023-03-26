package com.studentweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.project.resources.model.Student;


public class StudentDataUtil {
	List<Student>students=new ArrayList<>();
	
	private DataSource datasource;
	public StudentDataUtil(DataSource datasource) {
		this.datasource=datasource;
	}
	
	public List<Student>getStudents(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	
		try {
			con=this.datasource.getConnection();
			stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from student");
			while(resultSet.next()) {
			int id=resultSet.getInt("id");
				String fname=resultSet.getString("first_name");
				String lname=resultSet.getString("last_name");
				String email=resultSet.getString("email");
				Student student=new Student(id,fname,lname,email);
				students.add(student);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(con,stmt,rs);
		}
		return students;
	}
	
	private void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int studentId) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			con=this.datasource.getConnection();
			String sql="delete from student where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt,null);
		}
		
	}
	
	public void updataStudent(int studentId,String firstName,String lastName,String emailId) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			con=this.datasource.getConnection();
			String sql="update student set first_name=?,email=? where id=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, emailId);
			stmt.setInt(4, studentId);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt,null);
		}
	}
}
